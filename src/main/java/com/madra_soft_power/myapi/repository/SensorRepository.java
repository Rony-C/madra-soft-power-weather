package com.madra_soft_power.myapi.repository;

import com.madra_soft_power.myapi.entity.SensorData;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Part of Data access layer to allow CRUD operations on DB
 * Define
 */
@Repository
public interface SensorRepository extends JpaRepository<SensorData, Long> {

    List<SensorData> getBySensorId(String sensorId);

    List<SensorData> getByTimestampBetween(LocalDateTime start, LocalDateTime end);

}
