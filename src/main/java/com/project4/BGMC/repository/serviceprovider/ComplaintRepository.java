package com.project4.BGMC.repository.serviceprovider;

import com.project4.BGMC.entity.serviceprovider.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    // Add custom query methods if needed, e.g.:
    // List<Complaint> findByStatus(Status status);
    // List<Complaint> findByUserId(Long userId);
    // List<Complaint> findByIsCustomer(boolean isCustomer);
}
