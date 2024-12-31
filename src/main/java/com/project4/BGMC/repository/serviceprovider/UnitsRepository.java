package com.project4.BGMC.repository.serviceprovider;

import com.project4.BGMC.entity.serviceprovider.Units;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitsRepository extends JpaRepository<Units, Long> {
    List<Units> findByMeter_Id(Long meterId);
}
