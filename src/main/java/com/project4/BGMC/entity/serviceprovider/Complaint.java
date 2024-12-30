package com.project4.BGMC.entity.serviceprovider;

import com.project4.BGMC.entity.masterentity.User;
import com.project4.BGMC.enums.Status;
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
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "escalated_role")
    private String escalatedRole;

    @Column(name = "comments")
    private String comments;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "issue_subject", nullable = false)
    private String issueSubject;

    @Column(name = "is_customer", nullable = false)
    private boolean isCustomer;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
