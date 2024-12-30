package com.project4.BGMC.config.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CompanyInfo {

    @Bean
    public Map<String, String> companyInfoMap() {
        return new HashMap<>();
    }
}
