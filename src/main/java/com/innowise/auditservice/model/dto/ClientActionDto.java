package com.innowise.auditservice.model.dto;

import java.time.Instant;

public record ClientActionDto(
        Long id,
        String email,
        String actionType,
        Integer actionStatus,
        Instant actionTime
) {
}
