package com.project4.BGMC.repository;

import com.project4.BGMC.entity.masterentity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District, Long> {

  @Query(value = "select * from district where state_id = ?1",nativeQuery = true)
  List<District> findByStateId(Long stateId);
}