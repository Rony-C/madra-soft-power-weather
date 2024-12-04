package com.madra_soft_power.myapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Defines what the SensorMetric object needs
 * Defining table name instead of being auto-generated
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
}
