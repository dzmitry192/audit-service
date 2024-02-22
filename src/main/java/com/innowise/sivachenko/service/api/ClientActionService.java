package com.innowise.sivachenko.service.api;

import com.innowise.sivachenko.kafka.avro.AuditActionRequest;
import com.innowise.sivachenko.kafka.avro.AuditActionType;
import com.innowise.sivachenko.kafka.avro.AuditServiceType;
import com.innowise.sivachenko.model.dto.ClientActionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

public interface ClientActionService {
    Page<ClientActionDto> getActions(
            String email,
            AuditActionType actionType,
            AuditServiceType serviceType,
            Integer actionStatus,
            LocalDateTime timeBefore,
            LocalDateTime timeAfter,
            Pageable pageable);
    ClientActionDto getClientActionById(Long actionId);
    void saveActionRequest(AuditActionRequest actionRequest);
}
