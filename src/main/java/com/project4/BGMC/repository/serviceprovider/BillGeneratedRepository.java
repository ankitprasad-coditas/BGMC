package com.project4.BGMC.repository.serviceprovider;

import com.project4.BGMC.entity.serviceprovider.BillGenerated;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillGeneratedRepository extends JpaRepository<BillGenerated, Long> {
    // Add any custom query methods here if needed
}
