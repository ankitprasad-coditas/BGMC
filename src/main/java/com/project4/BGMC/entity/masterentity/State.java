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
@Table(name = "state")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state_id")
    private Long id;

    @Column(name = "state_title",nullable = false, length = 100)
    private String name;

    @JsonIgnore
    @Column(name = "state_description", nullable = false)
    private String description;

    @JsonIgnore
    @Column(nullable = false, length = 10)
    private String status;
}
