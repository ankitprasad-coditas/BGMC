package com.project4.BGMC.repository.serviceprovider;

import com.project4.BGMC.entity.serviceprovider.MeterImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeterImageRepository extends JpaRepository<MeterImage, Long> {
    // Add custom query methods if needed, e.g.:
    // List<MeterImage> findByMeterReadingId(Long meterReadingId);
}
