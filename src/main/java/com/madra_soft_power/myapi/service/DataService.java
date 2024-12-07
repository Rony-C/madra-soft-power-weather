package com.madra_soft_power.myapi.service;

import com.madra_soft_power.myapi.entity.SensorData;
import com.madra_soft_power.myapi.repository.SensorRepository;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service defines it as a service
 * Works as connector between the Controller and Repo
 * Saves the object passed from the controller to the repo
 */
@Service
@RequiredArgsConstructor
public class DataService {

    @Autowired
    private SensorRepository repository;

    /**
     * Saves single entry of data
     * 
     * @param data
     */
    public void saveData(SensorData data) {
        repository.save(data);
    }

    /**
     * Save bulk entry of data from a list
     * 
     * @param data
     */
    public void saveBulkData(List<SensorData> data) {
        repository.saveAll(data);
        throw new UnsupportedOperationException("Unimplemented method 'saveBulkData'");
    }

    /**
     * Get all Data from table
     * 
     * @return All data
     */
    public List<SensorData> getAllData() {
        return repository.findAll();
    }

    /**
     * Get all data by sensorID. Sensor ID passed as parameter
     * 
     * @param sensorId
     * @return All data by sensor ID
     */
    public List<SensorData> getDataBySensorId(String sensorId) {
        return repository.getBySensorId(sensorId);
    }

    /**
     * Get data between two timestamps passed as parameters
     * 
     * @param start
     * @param end
     * @return All data between two timestamps
     */
    public List<SensorData> getDataByDateRange(LocalDateTime start, LocalDateTime end) {
        return repository.getByTimestampBetween(start, end);
    }

    /**
     * Get average by sensor and metric
     * 
     * @param sensorID
     * @param metric
     * @return Avg for sensor ID and metric
     */
    public Double getAvgSensorIdAndMetric(String sensorID, String metric) {
        return repository.getAvgSensorIdAndMetric(sensorID, metric);
    }

    /**
     * Get avg value by metric
     * 
     * @param metric
     * @return All time average for metric
     */
    public Double getAvgMetricValue(String metric) {
        return repository.getAvgMetricValue(metric);
    }

    /**
     * Get avg of all sensors
     * 
     * @return All time average for all sensors
     */
    public Double getSensorsAverage() {
        return repository.getSensorsAverage();
    }

    /**
     * Get avg of sensor from last 7 days
     * Handles null values
     * 
     * @param sensorId
     * @return Average temperatur for last 7 days or 0.0 if null
     */
    public Double getAvgSensorTempLastWeek(String sensorId) {
        LocalDateTime endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusDays(7);

        Double avgTemp = repository.getAvgTempLastWeek(sensorId, startTime, endTime);
        return avgTemp != null ? avgTemp : 0.0;
    }
}
