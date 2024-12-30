package com.project4.BGMC.config.context;

import jakarta.persistence.EntityManager;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class CompanySchemaAspect {

    @Autowired
    private EntityManager entityManager;

    @Before("@annotation(org.springframework.transaction.annotation.Transactional)")
    public void setCompanySchemaBeforeQuery() {
        String company = CompanyContext.getCompanySchema();
        if (company != null && !company.isEmpty()) {
            entityManager.createNativeQuery("SET search_path TO " + company).executeUpdate();
        }
    }
}
