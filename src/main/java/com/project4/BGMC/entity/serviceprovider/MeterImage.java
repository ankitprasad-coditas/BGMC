package com.project4.BGMC.entity.serviceprovider;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "meter_images")
public class MeterImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "images_id")
    private Long imagesId;

    @Column(name = "images_path", nullable = false)
    private String imagesPath;

    @ManyToOne
    @JoinColumn(name = "meter_reading_id", nullable = false)
    private MeterReading meterReading;

}
