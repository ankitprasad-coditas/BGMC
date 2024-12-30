package com.project4.BGMC.repository.wlc;

import com.project4.BGMC.entity.wlc.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepository extends MongoRepository<Company,String> {
}
