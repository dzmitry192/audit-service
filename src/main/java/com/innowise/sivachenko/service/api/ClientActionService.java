package com.innowise.sivachenko.service.api;

import com.innowise.sivachenko.kafka.avro.AuditActionRequest;
import com.innowise.sivachenko.model.dto.ClientActionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientActionService {
    Page<ClientActionDto> getActions(Pageable pageable);
    void saveActionRequest(AuditActionRequest actionRequest);
}
