package com.innowise.sivachenko.service;

import com.innowise.sivachenko.kafka.avro.AuditActionRequest;
import com.innowise.sivachenko.kafka.avro.AuditActionType;
import com.innowise.sivachenko.kafka.avro.AuditServiceType;
import com.innowise.sivachenko.mapper.ClientActionMapper;
import com.innowise.sivachenko.model.dto.ClientActionDto;
import com.innowise.sivachenko.model.entity.ClientActionEntity;
import com.innowise.sivachenko.model.exception.ActionNotFoundException;
import com.innowise.sivachenko.repository.ClientActionRepository;
import com.innowise.sivachenko.service.api.ClientActionService;
import com.innowise.sivachenko.service.specifications.ClientActionSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class ClientActionServiceImpl implements ClientActionService {

    private final ClientActionRepository clientActionRepository;

    @Override
    public Page<ClientActionDto> getActions(String email, AuditActionType actionType, AuditServiceType serviceType, Integer actionStatus, LocalDateTime timeBefore, LocalDateTime timeAfter, Pageable pageable) {
        Page<ClientActionDto> actionDtoPage = clientActionRepository.findAll(
                        Specification.where(
                                ClientActionSpecification.withEmail(email)
                                        .and(ClientActionSpecification.withActionType(actionType))
                                        .and(ClientActionSpecification.withServiceType(serviceType))
                                        .and(ClientActionSpecification.withActionStatus(actionStatus))
                                        .and(ClientActionSpecification.withActionTimeBetween(timeBefore, timeAfter))
                        ), pageable)
                .map(ClientActionMapper.INSTANCE::clientActionEntityToClientActionDto);

        saveActionRequest(new AuditActionRequest(
            SecurityContextHolder.getContext().getAuthentication().getName(),
                AuditActionType.GET,
                AuditServiceType.AUDIT,
                HttpStatus.SC_OK,
                Instant.now()
        ));
        log.info("Request for getting actions successfully completed");
        return actionDtoPage;
    }

    @Override
    public ClientActionDto getClientActionById(Long actionId) {
        Optional<ClientActionEntity> optionalClientAction = clientActionRepository.findById(actionId);
        if (optionalClientAction.isPresent()) {
            return ClientActionMapper.INSTANCE.clientActionEntityToClientActionDto(optionalClientAction.get());
        } else {
            throw new ActionNotFoundException("Action not found");
        }
    }

    @Override
    public void saveActionRequest(AuditActionRequest actionRequest) {
        ClientActionEntity clientAction = clientActionRepository.save(ClientActionMapper.INSTANCE.auditActionRequestToClientActionEntity(actionRequest));
        log.info("Client action with id = {} successfully saved", clientAction.getId());
    }
}
