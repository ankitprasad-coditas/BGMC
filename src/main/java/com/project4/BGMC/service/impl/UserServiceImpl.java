package com.project4.BGMC.service.impl;

import com.project4.BGMC.config.context.CompanyContext;
import com.project4.BGMC.dto.UserRequestDto;
import com.project4.BGMC.dto.UserResponseDto;
import com.project4.BGMC.entity.masterentity.Role;
import com.project4.BGMC.entity.masterentity.User;
import com.project4.BGMC.exceptions.DuplicateDataException;
import com.project4.BGMC.exceptions.MissingDataException;
import com.project4.BGMC.mapper.Impl.UserRequestMapper;
import com.project4.BGMC.mapper.Impl.UserResponseMapper;
import com.project4.BGMC.repository.RoleRepository;
import com.project4.BGMC.repository.UserRepository;
import com.project4.BGMC.service.UserService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JavaMailSender javaMailSender;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserResponseMapper userResponseMapper;
    private final UserRequestMapper userRequestMapper;

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto, String authorizationHeader) {
        if (userRepository.findByEmail(userRequestDto.getEmail()).isPresent()) {
            throw new DuplicateDataException("User Already Present");
        }

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new MissingDataException("Authorization header is missing or invalid");
        }


        Role exsistingRole = roleRepository.findById(userRequestDto.getRole()).orElseThrow(() -> new MissingDataException("Role Not Found"));
        User newUser = User.builder()
                .name(userRequestDto.getName())
                .email(userRequestDto.getEmail())
                .password(passwordEncoder.encode(generateRandomPassword(8)))
                .role(exsistingRole)
                .profilePicPath(userRequestDto.getProfilePicturePath())
                .stateId(userRequestDto.getStateId())
                .districtId(userRequestDto.getDistrictId())
                .cityId(userRequestDto.getCityId())
                .companyId(CompanyContext.getCompanyId())
                .build();

        return userResponseMapper.toDto(userRepository.save(newUser));
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
}
