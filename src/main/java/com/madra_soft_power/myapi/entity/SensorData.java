package com.madra_soft_power.myapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Defines what the SensorMetric pojo needs
 * Annotating as JPA Entity for db
 * Defining table name instead of being auto-generated with Class Name
 */

@Entity
@Data
@Builder // Builder pattern
@Table(name = "weather_data")
public class SensorData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String sensorId;

    @Column(nullable = false)
    private String metric;

    @Column(nullable = false)
    private Double value;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    // Explicitly defined no-args constructor
    public SensorData() {
    }

    // Explicitly defined all-args constructor
    public SensorData(Long id, String sensorId, String metric, Double value, LocalDateTime timestamp) {
        this.id = id;
        this.sensorId = sensorId;
        this.metric = metric;
        this.value = value;
        this.timestamp = timestamp;
    }
}
