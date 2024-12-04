package com.madra_soft_power.myapi.service;

import com.madra_soft_power.myapi.entity.SensorData;
import com.madra_soft_power.myapi.repository.SensorRepository;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        throw new UnsupportedOperationException("Unimplemented method 'saveBulkData'");
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
     * @return
     */
    public List<SensorData> getAllData() {
        return repository.findAll();
    }

    /**
     * Get all data by sensorID. Sensor ID passed as parameter
     * 
     * @param sensorId
     * @return
     */
    public List<SensorData> getDataBySensorId(String sensorId) {
        return repository.getBySensorId(sensorId);
    }

    /**
     * Get data between two timestamps passed as parameters
     * 
     * @param start
     * @param end
     * @return
     */
    public List<SensorData> getDataByDateRange(LocalDateTime start, LocalDateTime end) {
        return repository.getByTimestampBetween(start, end);
    }

    /**
     * 
     * @param sensorID
     * @param metric
     * @return
     */
    public Double getAvgSensorIdAndMetric(String sensorID, String metric) {
        return repository.getAvgSensorIdAndMetric(sensorID, metric);
    }

    public Double getAvgMetricValue(String metric) {
        return repository.getAvgMetricValue(metric);
    }

    public Double getSensorsAverage() {
        return repository.getSensorsAverage();
    }

}
