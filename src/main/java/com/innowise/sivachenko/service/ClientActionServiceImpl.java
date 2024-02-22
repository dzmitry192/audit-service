package com.innowise.sivachenko.service;

import com.innowise.sivachenko.kafka.avro.AuditActionRequest;
import com.innowise.sivachenko.model.dto.ClientActionDto;
import com.innowise.sivachenko.repository.ClientActionRepository;
import com.innowise.sivachenko.service.api.ClientActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientActionServiceImpl implements ClientActionService {

    private final ClientActionRepository clientActionRepository;

    @Override
    public Page<ClientActionDto> getActions(Pageable pageable) {
        return null;
    }

    @Override
    public void saveActionRequest(AuditActionRequest actionRequest) {

    }
}
