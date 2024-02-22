package com.innowise.sivachenko.model.entity;

import com.innowise.sivachenko.kafka.avro.AuditServiceType;
import com.innowise.sivachenko.kafka.avro.AuditActionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "client-actions")
@Entity
public class ClientActionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Email
    @Column(name = "email")
    private String email;
    @NotBlank
    @Column(name = "actionType")
    private AuditActionType actionType;
    @NotBlank
    @Column(name = "serviceType")
    private AuditServiceType serviceType;
    @NotNull
    @Column(name = "actionStatus")
    private Integer actionStatus;
    @NotNull
    @Column(name = "actionTime")
    private Instant actionTime;
}
