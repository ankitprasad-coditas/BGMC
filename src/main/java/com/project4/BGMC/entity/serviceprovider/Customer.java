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
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "city_id", nullable = false)
    private Long cityId;

    @Column(name = "company_id", nullable = false)
    private Long companyId;

    @ManyToOne
    @JoinColumn(name = "meter_id")
    private Meter meter;

    @Column(name = "reading_status", nullable = false)
    private boolean readingStatus;
}
