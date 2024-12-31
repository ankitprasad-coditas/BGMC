package com.project4.BGMC.entity.masterentity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "district")
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "districtid")
    private Long id;

    @Column(name = "district_title",nullable = false, length = 100)
    private String name;

    @JsonIgnore
    @Column(name = "district_description",nullable = false)
    private String description;

    @JsonIgnore
    @Column(name = "district_status",nullable = false, length = 10)
    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "state_id", nullable = false)
    private State state;
}
