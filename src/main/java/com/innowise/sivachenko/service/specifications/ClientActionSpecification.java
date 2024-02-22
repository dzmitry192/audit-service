package com.innowise.sivachenko.service.specifications;

import com.innowise.sivachenko.kafka.avro.AuditActionType;
import com.innowise.sivachenko.kafka.avro.AuditServiceType;
import com.innowise.sivachenko.model.entity.ClientActionEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class ClientActionSpecification {

    public static Specification<ClientActionEntity> withEmail(String email) {
        return (action, query, builder) -> email != null ? builder.equal(action.get("email"), email) : null;
    }

    public static Specification<ClientActionEntity> withActionType(AuditActionType actionType) {
        return (action, query, builder) -> actionType != null ? builder.equal(action.get("actionType"), actionType) : null;
    }

    public static Specification<ClientActionEntity> withServiceType(AuditServiceType serviceType) {
        return (action, query, builder) -> serviceType != null ? builder.equal(action.get("serviceType"), serviceType) : null;
    }

    public static Specification<ClientActionEntity> withActionStatus(Integer actionStatus) {
        return (action, query, builder) -> actionStatus != null ? builder.equal(action.get("actionStatus"), actionStatus) : null;
    }

    public static Specification<ClientActionEntity> withActionTimeBetween(LocalDateTime timeBefore, LocalDateTime timeAfter) {
        return (action, query, builder) -> {
            if (timeBefore == null && timeAfter == null) {
                return null;
            }

            if (timeBefore != null && timeAfter != null) {
                return builder.between(action.get("actionTime"), convertToInstant(timeBefore), convertToInstant(timeAfter));
            } else if (timeBefore != null) {
                return builder.greaterThanOrEqualTo(action.get("actionTime"), convertToInstant(timeBefore));
            } else {
                return builder.lessThanOrEqualTo(action.get("actionTime"), convertToInstant(timeAfter));
            }
        };
    }

    private static Instant convertToInstant(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant();
    }
}
