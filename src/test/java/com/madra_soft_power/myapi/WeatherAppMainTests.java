package com.madra_soft_power.myapi;

import com.madra_soft_power.myapi.controller.DataController;
import com.madra_soft_power.myapi.service.DataService;
import com.madra_soft_power.myapi.entity.SensorData;
import com.madra_soft_power.myapi.repository.SensorRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WeatherAppMainTests {

	@Autowired
	private DataController dataController;

	@Autowired
	private DataService dataService;

	@Autowired
	private SensorRepository sensorRepository;

	/**
	 * Test connection to classes
	 */
	@Test
	void classesLoad() {
		assertNotNull(dataController);
		assertNotNull(dataService);
		assertNotNull(sensorRepository);
	}

	/**
	 * Test Get by SensorID is not empty
	 * TODO Actually test specific values in response
	 */
	@Test
	void testGetBySensorId() {
		dataService.saveData(
				new SensorData(null, "sensor_73", "Temperature", 14.6, LocalDateTime.of(2024, 12, 07, 14, 01)));

		List<SensorData> sensorID = dataService.getDataBySensorId("sensor_73");

		assertNotNull(sensorID);
		assertFalse(sensorID.isEmpty());
	}

	/**
	 * Test average by Sensor ID and Temperature
	 * TODO Add more tests for other metrics
	 */
	@Test
	void testAverageCalculation() {
		dataService.saveData(new SensorData(null, "sensor_avg", "Temperature", 20.0, LocalDateTime.now()));
		dataService.saveData(new SensorData(null, "sensor_avg", "Temperature", 30.0, LocalDateTime.now()));

		Double average = dataService.getAvgSensorIdAndMetric("sensor_avg", "Temperature");

		assertNotNull(average);
		assertEquals(25.0, average);
	}

	/**
	 * Test get by date range
	 * TODO Add more date ranges
	 */
	@Test
	void testGetDataByDateRange() {
		LocalDateTime startTime = LocalDateTime.now().minusDays(1);
		LocalDateTime endTime = LocalDateTime.now();
		SensorData data1 = new SensorData(null, "sensor_7", "Pressure", 1020.0, LocalDateTime.now().minusHours(1));
		SensorData data2 = new SensorData(null, "sensor_8", "Pressure", 1015.0, LocalDateTime.now().minusHours(2));
		sensorRepository.save(data1);
		sensorRepository.save(data2);

		List<SensorData> dataInRange = dataController.getByDatRange(startTime.toString(), endTime.toString()).getBody();

		assertNotNull(dataInRange);
		assertFalse(dataInRange.isEmpty());
		assertTrue(dataInRange.contains(data1));
	}

}
