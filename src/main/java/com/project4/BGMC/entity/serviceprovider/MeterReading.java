package com.project4.BGMC.entity.serviceprovider;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "meter_reading")
@Data
@NoArgsConstructor
public class MeterReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "units", nullable = false)
    private Long units;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "meter_type", nullable = false)
    private Meter meterType;

    @Column(name = "ground_worker_id")
    private Long groundWorkerId;
}
