package com.project4.BGMC.service.wlc.impl;

import com.project4.BGMC.dto.CompanyRequestDto;
import com.project4.BGMC.dto.CompanyResponseDto;
import com.project4.BGMC.entity.masterentity.Role;
import com.project4.BGMC.entity.masterentity.User;
import com.project4.BGMC.entity.wlc.Company;
import com.project4.BGMC.exceptions.CompanyCreationException;
import com.project4.BGMC.exceptions.MissingDataException;
import com.project4.BGMC.mapper.Impl.CompanyResponseMapper;
import com.project4.BGMC.repository.RoleRepository;
import com.project4.BGMC.repository.UserRepository;
import com.project4.BGMC.repository.wlc.CompanyRepository;
import com.project4.BGMC.service.wlc.CompanyManagementService;
import jakarta.annotation.PostConstruct;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import liquibase.exception.LiquibaseException;
import liquibase.integration.spring.SpringLiquibase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.core.io.ResourceLoader;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.*;

@RequiredArgsConstructor
@Service
public class CompanyManagementServiceImpl implements CompanyManagementService {

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    @Qualifier("companyLiquibaseProperties")
    private LiquibaseProperties liquibaseProperties;
    private final ResourceLoader resourceLoader;
    private final CompanyRepository companyRepository;
    private final Map<String, String> tenantMap;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final JavaMailSender javaMailSender;
    private final CompanyResponseMapper companyResponseMapper;

    private static final String VALID_SCHEMA_NAME_REGEXP = "[A-Za-z0-9_]*";

    @Override
    public void createCompany(CompanyRequestDto companyRequestDto) {

        String schemaName = companyRequestDto.getCompanyName().toLowerCase();
        String tenantId = UUID.randomUUID().toString();

        if (!schemaName.matches(VALID_SCHEMA_NAME_REGEXP)) {
            throw new CompanyCreationException("Invalid schema name: " + schemaName);
        }

        try {
            createSchema(schemaName);
            runLiquibase(dataSource, schemaName);
            tenantMap.put(tenantId, schemaName);
        } catch (DataAccessException e) {
            throw new CompanyCreationException("Error when creating schema: " + schemaName, e);
        } catch (LiquibaseException e) {
            throw new CompanyCreationException("Error when populating schema: ", e);
        }

        Company company = Company.builder()
                .companyId(tenantId)
                .companySchemaName(schemaName)
                .citiList(Collections.singletonList(companyRequestDto.getCity()))
                .companyEmail(companyRequestDto.getPrimaryEmail())
                .build();
        companyRepository.save(company);

        String randomPassword = generateRandomPassword(8);
        Role adminRole = roleRepository.findByName("ADMIN").orElseThrow(()-> new MissingDataException("Role Not Found"));
        User companyAdmin = User.builder()
                .name(schemaName+"_Admin")
                .email(companyRequestDto.getPrimaryEmail())
                .password(passwordEncoder.encode(randomPassword))
                .role(adminRole)
                .profilePicPath("NA")
                .cityId(companyRequestDto.getCity())
                .companyId(tenantId)
                .build();

        userRepository.save(companyAdmin);
        sendRandomPasswordEmail(companyAdmin, randomPassword);
    }

    private void createSchema(String schema) {
        jdbcTemplate.execute((StatementCallback<Boolean>) stmt -> stmt.execute("CREATE SCHEMA " + schema));
    }

    private void runLiquibase(DataSource dataSource, String schema) throws LiquibaseException {
        SpringLiquibase liquibase = getSpringLiquibase(dataSource, schema);
        liquibase.afterPropertiesSet();
    }

    protected SpringLiquibase getSpringLiquibase(DataSource dataSource, String schema) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setResourceLoader(resourceLoader);
        liquibase.setDataSource(dataSource);
        liquibase.setDefaultSchema(schema);
        if (liquibaseProperties.getParameters() != null) {
            liquibaseProperties.getParameters().put("schema", schema);
            liquibase.setChangeLogParameters(liquibaseProperties.getParameters());
        } else {
            liquibase.setChangeLogParameters(Collections.singletonMap("schema", schema));
        }
        liquibase.setChangeLog(liquibaseProperties.getChangeLog());
//        liquibase.setContexts(liquibaseProperties.getContexts());
        liquibase.setLiquibaseSchema(liquibaseProperties.getLiquibaseSchema());
        liquibase.setLiquibaseTablespace(liquibaseProperties.getLiquibaseTablespace());
        liquibase.setDatabaseChangeLogTable(liquibaseProperties.getDatabaseChangeLogTable());
        liquibase.setDatabaseChangeLogLockTable(liquibaseProperties.getDatabaseChangeLogLockTable());
        liquibase.setDropFirst(liquibaseProperties.isDropFirst());
        liquibase.setShouldRun(liquibaseProperties.isEnabled());
//        liquibase.setLabels(liquibaseProperties.getLabels());
        liquibase.setRollbackFile(liquibaseProperties.getRollbackFile());
        liquibase.setTestRollbackOnUpdate(liquibaseProperties.isTestRollbackOnUpdate());
        return liquibase;
    }

    @PostConstruct
    public void loadTenants() {
        List<Company> companyList = companyRepository.findAll();
        for (Company company : companyList) {
            tenantMap.put(company.getCompanyId(), company.getCompanySchemaName());
        }
    }


    private String generateRandomPassword(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            password.append(characters.charAt(random.nextInt(characters.length())));
        }
        return password.toString();
    }

    private void sendRandomPasswordEmail(User user, String randomPassword) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

            helper.setTo(user.getEmail());
            helper.setSubject("Your New Account Password");
            helper.setText(String.format(
                    "Dear %s,\n\nYour account has been created.\nYour temporary password is: %s\n",
                    user.getName(), randomPassword
            ));

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }


    // Get All Companies
    @Override
    public List<CompanyResponseDto> getALlCompanies() {
        return companyResponseMapper.toDtoList(companyRepository.findAll());
    }

}
