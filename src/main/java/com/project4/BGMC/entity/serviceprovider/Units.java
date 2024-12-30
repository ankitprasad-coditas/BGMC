package com.project4.BGMC.entity.serviceprovider;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "units")
@Data
@NoArgsConstructor
public class Units {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "meter_id", nullable = false)
    private Meter meter;

    @Column(name = "units", nullable = false)
    private Long units;
}
