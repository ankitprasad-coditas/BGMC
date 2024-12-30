package com.project4.BGMC.config.context;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CompanyContext {
    private static final ThreadLocal<String> CURRENT_TENANT = new ThreadLocal<>();

    public static void setCompanySchema(String companySchemaName) {
        if (companySchemaName == null || companySchemaName.isEmpty()) {
            log.warn("Tenant ID is null or empty");
        }
        CURRENT_TENANT.set(companySchemaName);
    }

    public static String getCompanySchema() {
        String company = CURRENT_TENANT.get();
        if (company == null) {
            log.warn("Tenant ID is not set in the context");
        }
        return company;
    }

    public static void clearCompanySchema() {
        CURRENT_TENANT.remove();
    }
}
