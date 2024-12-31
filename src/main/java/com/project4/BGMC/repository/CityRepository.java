package com.project4.BGMC.repository;

import com.project4.BGMC.entity.masterentity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

  @Query(value = "select * from city where districtid =?1 and state_id = ?2",nativeQuery = true)
  List<City> findByDistrictIdAndStateId(Long districtId, Long stateId);
}