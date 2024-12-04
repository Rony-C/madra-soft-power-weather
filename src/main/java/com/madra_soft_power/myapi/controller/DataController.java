package com.madra_soft_power.myapi.controller;

import com.madra_soft_power.myapi.entity.SensorData;
import com.madra_soft_power.myapi.service.DataService;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Handles the API Calls with RestController
 * All endpoints for this class are under /api with RequestMapping
 * POST requests are under the endpoint /add-data
 * If successful it will call the service to save the POSTed information
 * 
 * GET endpoints defined for specific use cases
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DataController {

    @Autowired
    private DataService service;

    @PostMapping("/add-data")
    public ResponseEntity<String> addData(@RequestBody SensorData data) {
        service.saveData(data);
        return ResponseEntity.ok("Weather data added successfully");
    }

    @PostMapping("/bulk-add-data")
    public ResponseEntity<String> bulkAddData(@RequestBody List<SensorData> data) {
        service.saveBulkData(data);
        return ResponseEntity.ok("Bulk weather data added successfully");
    }

    @GetMapping("/get-all-data")
    public ResponseEntity<List<SensorData>> getAllData() {
        return ResponseEntity.ok(service.getAllData());
    }

    @GetMapping("/sensor/{sensorId}")
    public ResponseEntity<List<SensorData>> getBySensorID(@PathVariable String sensorId) {
        return ResponseEntity.ok(service.getDataBySensorId(sensorId));
    }

    @GetMapping("/get-date-range")
    public ResponseEntity<List<SensorData>> getByDatRange(
            @RequestParam("start") String start,
            @RequestParam("end") String end) {
        LocalDateTime starTime = LocalDateTime.parse(start);
        LocalDateTime endTime = LocalDateTime.parse(end);
        return ResponseEntity.ok(service.getDataByDateRange(starTime, endTime));
    }

}
