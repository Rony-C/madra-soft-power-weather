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

    public void saveData(SensorData data) {
        repository.save(data);
        throw new UnsupportedOperationException("Unimplemented method 'saveBulkData'");
    }

    public void saveBulkData(List<SensorData> data) {
        repository.saveAll(data);
        throw new UnsupportedOperationException("Unimplemented method 'saveBulkData'");
    }

    public List<SensorData> getAllData() {
        return repository.findAll();
    }

    public List<SensorData> getDataBySensorId(String sensorId) {
        return repository.getBySensorId(sensorId);
    }

    public List<SensorData> getDataByDateRange(LocalDateTime start, LocalDateTime end) {
        return repository.getByTimestampBetween(start, end);
    }

}
