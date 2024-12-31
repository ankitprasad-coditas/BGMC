package com.project4.BGMC.entity.masterentity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false) // Use @JoinColumn here
    private Role role;

    private String profilePicPath;

    private Long stateId = 0l;

    private Long districtId = 0l;

    private Long cityId = 0l;

    @Column(nullable = false)
    private String companyId;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;

}
