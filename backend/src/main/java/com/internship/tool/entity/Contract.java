package com.internship.tool.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "contracts")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // This was missing! It maps Java 'contractName' to SQL 'contract_name'
    @Column(name = "contract_name", nullable = false)
    private String contractName;

    @Column(name = "vendor_name")
    private String vendorName;

    private String status;

    @Column(name = "risk_score")
    private Double riskScore;

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Column(columnDefinition = "TEXT")
    private String summary;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}