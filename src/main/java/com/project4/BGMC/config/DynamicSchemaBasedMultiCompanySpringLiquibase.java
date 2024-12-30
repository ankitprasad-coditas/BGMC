package com.project4.BGMC.config;

import com.project4.BGMC.entity.wlc.Company;
import com.project4.BGMC.repository.wlc.CompanyRepository;
import liquibase.exception.LiquibaseException;
import liquibase.integration.spring.SpringLiquibase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;


import javax.sql.DataSource;
import java.util.Collection;
import java.util.Collections;


@Slf4j
public class DynamicSchemaBasedMultiCompanySpringLiquibase implements InitializingBean, ResourceLoaderAware {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private DataSource dataSource;

    @Autowired
    @Qualifier("companyLiquibaseProperties")
    private LiquibaseProperties liquibaseProperties;

    private ResourceLoader resourceLoader;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("Schema based multitenancy enabled");
        this.runOnAllSchemas(dataSource, companyRepository.findAll());
    }

    protected void runOnAllSchemas(DataSource dataSource, Collection<Company> companies) throws LiquibaseException {
        for(Company company : companies) {
            log.info("Initializing Liquibase for tenant " + company.getCompanyId());
            SpringLiquibase liquibase = this.getSpringLiquibase(dataSource, company.getCompanySchemaName());
            liquibase.afterPropertiesSet();
            log.info("Liquibase ran for tenant " + company.getCompanyId());
        }
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

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {

    }
}