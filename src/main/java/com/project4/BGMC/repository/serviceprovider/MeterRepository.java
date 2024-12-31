package com.project4.BGMC.repository.serviceprovider;

import com.project4.BGMC.entity.serviceprovider.Meter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeterRepository extends JpaRepository<Meter, Long> {
    // Add custom query methods if needed, e.g.:
    // Optional<Meter> findByMeterType(String meterType);
    // List<Meter> findByIsDeleted(boolean isDeleted);
}
