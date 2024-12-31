package com.project4.BGMC.config.context;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CompanyContext {
    private static final ThreadLocal<String> CURRENT_COMPANY_SCHEMA_NAME = new ThreadLocal<>();
    private static final ThreadLocal<String> CURRENT_COMPANY_ID = new ThreadLocal<>();

    public static void setCompanySchema(String companySchemaName) {
        if (companySchemaName == null || companySchemaName.isEmpty()) {
            log.warn("Tenant ID is null or empty");
        }
        CURRENT_COMPANY_SCHEMA_NAME.set(companySchemaName);
    }

    public static String getCompanySchema() {
        String company = CURRENT_COMPANY_SCHEMA_NAME.get();
        if (company == null) {
            log.warn("Tenant ID is not set in the context");
        }
        return company;
    }

    public static void clearCompanySchema() {
        CURRENT_COMPANY_SCHEMA_NAME.remove();
    }

    public static void setCurrentCompanyId(String companyId) {
        if (companyId == null || companyId.isEmpty()) {
            log.warn("Tenant ID is null or empty");
        }
        CURRENT_COMPANY_ID.set(companyId);
    }

    public static String getCompanyId() {
        String company = CURRENT_COMPANY_ID.get();
        if (company == null) {
            log.warn("Tenant ID is not set in the context");
        }
        return company;
    }

    public static void clearCompanyId() {
        CURRENT_COMPANY_ID.remove();
    }
}
