package com.innowise.sivachenko.model.dto;

import com.innowise.sivachenko.kafka.avro.AuditActionType;
import com.innowise.sivachenko.kafka.avro.AuditServiceType;

import java.time.Instant;

public record ClientActionDto(
        Long id,
        String email,
        AuditActionType actionType,
        AuditServiceType serviceType,
        Integer actionStatus,
        Instant actionTime
) {
}
