package com.project4.BGMC.entity.serviceprovider;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Meter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "meter_type", nullable = false)
    private String meterType;

    @Column(name = "meter_rate", nullable = false)
    private Long meterRate;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;

    @Column(name = "no_of_readings")
    private Long noOfReadings;

    @Column(name = "time_interval")
    private String timeInterval;
}
