package com.project4.BGMC.entity.serviceprovider;

import com.project4.BGMC.entity.masterentity.User;
import com.project4.BGMC.enums.BillStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "bill_generated")
@Data
@NoArgsConstructor
public class BillGenerated {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "meter_reading_id", nullable = false)
    private MeterReading meterReading;

    @Column(name = "company_id", nullable = false)
    private String companyId;

    @Column(name = "total_amount", nullable = false)
    private Long totalAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private BillStatus status;

    @ManyToOne
    @JoinColumn(name = "city_head_id", nullable = false)
    private User cityHead;

    @Column(name = "discount")
    private Long discount;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

}
