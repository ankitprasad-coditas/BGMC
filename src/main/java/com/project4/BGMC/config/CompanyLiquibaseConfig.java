package com.project4.BGMC.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "multitenancy.tenant.liquibase.enabled", havingValue = "true", matchIfMissing = true)
public class CompanyLiquibaseConfig {

    @Bean
    @ConfigurationProperties("multitenancy.tenant.liquibase")
    public LiquibaseProperties companyLiquibaseProperties() {
        return new LiquibaseProperties();
    }

    @Bean
    public DynamicSchemaBasedMultiCompanySpringLiquibase tenantLiquibase() {
        return new DynamicSchemaBasedMultiCompanySpringLiquibase();
    }

}