package com.madra_soft_power.myapi.repository;

import com.madra_soft_power.myapi.entity.SensorData;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Part of Data access layer to allow CRUD operations on DB
 * Define getters for accessing DB
 * Query for specifying specific SQL queries
 */
@Repository
public interface SensorRepository extends JpaRepository<SensorData, Long> {

        /**
         * Get results based on sensorID
         * 
         * @param sensorId
         * @return All data for sensor ID
         */
        List<SensorData> getBySensorId(String sensorId);

        /**
         * Get results between two specified datetimes
         * 
         * @param start
         * @param end
         * @return List of results between datetimes
         */
        List<SensorData> getByTimestampBetween(LocalDateTime start, LocalDateTime end);

        /**
         * Get Average by sensorId and metric. Set sensorID and metric
         * 
         * @param sensorId
         * @param metric
         * @return Average of sensor ID and metric
         */
        @Query("SELECT AVG(s.value) FROM SensorData s WHERE s.sensorId = :sensorId AND s.metric = :metric")
        Double getAvgSensorIdAndMetric(@Param("sensorId") String sensorId, @Param("metric") String metric);

        /**
         * Get average of specific metric
         * 
         * @param metric
         * @return Average of metric
         */
        @Query("SELECT AVG(s.value) FROM SensorData s WHERE s.metric = :metric")
        Double getAvgMetricValue(@Param("metric") String metric);

        /**
         * Get average for all metrics
         * 
         * @return Average for all metrics
         */
        @Query("SELECT AVG(s.value) FROM SensorData s")
        Double getSensorsAverage();

        /**
         * Get avg temp for sensor for last week
         * 
         * @param sensorId
         * @param startDate
         * @param endDate
         * @return Average temperature for sensor ID in last 7 days
         */
        @Query("SELECT AVG(s.value) FROM SensorData s " +
                        "WHERE s.sensorId = :sensorId AND s.metric = 'Temperature' " +
                        "AND s.timestamp BETWEEN :startDate AND :endDate")
        Double getAvgTempLastWeek(
                        @Param("sensorId") String sensorId,
                        @Param("startDate") LocalDateTime startDate,
                        @Param("endDate") LocalDateTime endDate);

}
