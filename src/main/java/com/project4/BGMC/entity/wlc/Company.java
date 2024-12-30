package com.project4.BGMC.entity.wlc;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "company")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Company {

    @Id
    @Size(max = 30)
    @Column(name = "company_id")
    private String companyId;

    @Size(max = 30)
    @Column(name = "company_schema_name")
    private String companySchemaName;

}