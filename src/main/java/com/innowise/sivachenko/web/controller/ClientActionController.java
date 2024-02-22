package com.innowise.sivachenko.web.controller;

import com.innowise.sivachenko.kafka.avro.AuditActionType;
import com.innowise.sivachenko.kafka.avro.AuditServiceType;
import com.innowise.sivachenko.model.dto.ClientActionDto;
import com.innowise.sivachenko.service.ClientActionServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Log4j2
@RestController
@RequestMapping("/api/v1/audit-service")
@RequiredArgsConstructor
public class ClientActionController {

    private final ClientActionServiceImpl clientActionService;

    @GetMapping("/")
    public ResponseEntity<Page<ClientActionDto>> getClientActions(
            @RequestParam(name = "email", required = false) @Email String email,
            @RequestParam(name = "actionType", required = false) @NotBlank AuditActionType actionType,
            @RequestParam(name = "serviceType", required = false) @NotBlank AuditServiceType serviceType,
            @RequestParam(name = "actionStatus", required = false) @NotNull Integer actionStatus,
            @RequestParam(name = "timeBefore", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime timeBefore,
            @RequestParam(name = "timeAfter", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime timeAfter,
            Pageable pageable
    ) {
        log.info("Request for getting client actions");
        return ResponseEntity.ok().body(clientActionService.getActions(email, actionType, serviceType, actionStatus, timeBefore, timeAfter, pageable));
    }

    @GetMapping("/{actionId}")
    public ResponseEntity<ClientActionDto> getClientActionById(@PathVariable(name = "actionId") Long actionId) {
        log.info("Request for getting client action with id = {}", actionId);
        return ResponseEntity.ok().body(clientActionService.getClientActionById(actionId));
    }
}
