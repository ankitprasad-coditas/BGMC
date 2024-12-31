package com.project4.BGMC.repository.serviceprovider;

import com.project4.BGMC.entity.serviceprovider.MeterReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeterReadingRepository extends JpaRepository<MeterReading, Long> {
    // Custom query methods if needed
    List<MeterReading> findByCustomerId(Long customerId);

    List<MeterReading> findByMeterTypeId(Long meterTypeId);

    List<MeterReading> findByGroundWorkerId(Long groundWorkerId);
}
