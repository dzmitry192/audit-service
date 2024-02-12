package com.innowise.auditservice.service.api;

import com.innowise.auditservice.model.dto.ClientActionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientActionService {
    Page<ClientActionDto> getActions(Pageable pageable);
}
