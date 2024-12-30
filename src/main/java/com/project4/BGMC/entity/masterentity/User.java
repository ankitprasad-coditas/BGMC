package com.project4.BGMC.entity.masterentity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false) // Use @JoinColumn here
    private Role role;

    private String profilePicPath;

    private Long stateId;

    private Long districtId;

    private Long cityId;

    @Column(nullable = false)
    private String companyId;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;

}
