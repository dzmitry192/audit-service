package com.innowise.auditservice.service;

import com.innowise.auditservice.model.dto.ClientActionDto;
import com.innowise.auditservice.repository.ClientActionRepository;
import com.innowise.auditservice.service.api.ClientActionService;
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
}
