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
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @JsonIgnore
    @Column(name = "description", nullable = false)
    private String description;

    @JsonIgnore
    @Column(name = "status", length = 10)
    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "districtid", nullable = false)
    private District district;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "state_id", nullable = false)
    private State state;

}
