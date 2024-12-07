package com.madra_soft_power.myapi.controller;

import com.madra_soft_power.myapi.entity.SensorData;
import com.madra_soft_power.myapi.service.DataService;
import com.madra_soft_power.myapi.repository.*;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @Autowired
    private SensorRepository repository;

    // TODO: Handle empty responses from DB. Any GET request is currently returning
    // a 200 OK. Implement new ResponseEntity with HTTPStatus.ok, created, etc.

    /**
     * POST data
     * 
     * @param data
     * @return 201 Created Successful response for adding entry and String of entry
     */
    @PostMapping("/add-data")
    public ResponseEntity<String> addData(@RequestBody SensorData data) {
        String saveDataResponse = service.saveData(data).toString();
        return new ResponseEntity<String>(saveDataResponse, HttpStatus.CREATED);
    }

    /**
     * POST data in bulk via list
     * TODO: This returns a 500 internal server error response but adds the data at
     * the moment. Fix.
     * 
     * @param data
     * @return 201 Created Successful response for bulk adding data
     */
    @PostMapping("/bulk-add-data")
    public ResponseEntity<String> bulkAddData(@RequestBody List<SensorData> data) {
        service.saveBulkData(data);
        return new ResponseEntity<>("Bulk weather data added successfully", HttpStatus.CREATED);
    }

    /**
     * Get all data from table
     * 
     * @return All data from table
     */
    @GetMapping("/get-all-data")
    public ResponseEntity<List<SensorData>> getAllData() {
        return ResponseEntity.ok(service.getAllData());
    }

    /**
     * Get data by sensorId passed as parameter
     * 
     * @param sensorId
     * @return All data for sensor ID
     */
    @GetMapping("/sensor/{sensorId}")
    public ResponseEntity<List<SensorData>> getBySensorID(@PathVariable String sensorId) {
        return ResponseEntity.ok(service.getDataBySensorId(sensorId));
    }

    /**
     * Tried to get this working to pull from DB by entry ID but wasn't able to
     * 
     * @param id
     * @return Entry of SensorData
     */
    @GetMapping("/entry/{id}")
    public ResponseEntity<Object> getMethodName(@PathVariable String id) {
        return ResponseEntity.ok(service.getEntryID(id));
        // return ResponseEntity.ok(repository.getReferenceById(id));
    }

    /**
     * Get data between date times passed as parameters
     * 
     * @param start
     * @param end
     * @return All data between timeframes
     */
    @GetMapping("/get-date-range")
    public ResponseEntity<List<SensorData>> getByDatRange(
            @RequestParam("start") String start,
            @RequestParam("end") String end) {
        LocalDateTime starTime = LocalDateTime.parse(start);
        LocalDateTime endTime = LocalDateTime.parse(end);
        return ResponseEntity.ok(service.getDataByDateRange(starTime, endTime));
    }

    /**
     * Get Average by sensorID and metric
     * 
     * @param sensorId
     * @param metric
     * @return Average data by sensor ID and metric, eg. Temperatur, Humidity
     */
    @GetMapping("/average/sensor/{sensorId}/metric/{metric}")
    public ResponseEntity<Double> getAvgForSensorIDAndMetric(
            @PathVariable String sensorId,
            @PathVariable String metric) {
        Double average = service.getAvgSensorIdAndMetric(sensorId, metric);
        return ResponseEntity.ok(average);
    }

    /**
     * Get average by metric
     * 
     * @param metric
     * @return Average value of metric
     */
    @GetMapping("/average/metric/{metric}")
    public ResponseEntity<Double> getAverageForMetric(@PathVariable String metric) {
        Double average = service.getAvgMetricValue(metric);
        return ResponseEntity.ok(average);
    }

    /**
     * Get sensors average
     * 
     * @return Average of all sensor data
     */
    @GetMapping("/average/sensors")
    public ResponseEntity<Double> getSensorsAverage() {
        Double average = service.getSensorsAverage();
        return ResponseEntity.ok(average);
    }

    /**
     * Get avg of specific sensor from last week
     * 
     * @param sensorId
     * @return Double, average of sensor data from last 7 days
     */
    @GetMapping("/average/{sensorId}/last-week")
    public ResponseEntity<Double> getAvgSensorTempLastWeek(@PathVariable String sensorId) {
        Double avgTemp = service.getAvgSensorTempLastWeek(sensorId);
        return ResponseEntity.ok(avgTemp);
    }

}
