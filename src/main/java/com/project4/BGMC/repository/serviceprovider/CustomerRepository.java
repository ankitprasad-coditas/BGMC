package com.project4.BGMC.repository.serviceprovider;

import com.project4.BGMC.entity.serviceprovider.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Add custom query methods if needed, e.g.:
    // Optional<Customer> findByEmail(String email);
    // List<Customer> findByCityId(Long cityId);
    // List<Customer> findByCompanyId(Long companyId);
}
