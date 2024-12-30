package com.project4.BGMC.security;

import com.project4.BGMC.entity.masterentity.User;
import com.project4.BGMC.exceptions.MissingDataException;
import com.project4.BGMC.repository.RoleRepository;
import com.project4.BGMC.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepo;
    private final RoleRepository roleRepo;

    @Override
    public UserDetails loadUserByUsername(String emailId) throws MissingDataException {
        User user = userRepo.findByEmail(emailId)
                .orElseThrow(() -> new MissingDataException("User not found"));

        if (user.isDeleted()) {
            throw new MissingDataException("User is deleted and cannot log in");
        }

        return new CustomUserDetails(user);
    }
}

