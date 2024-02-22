package com.innowise.sivachenko.kafka.listener;

import com.innowise.sivachenko.kafka.avro.AuditActionRequest;
import com.innowise.sivachenko.service.ClientActionServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class KafkaListeners {

    private final ClientActionServiceImpl clientActionService;

    @KafkaListener(topics = "${kafka.topic.client-service-audit-topic}", groupId = "client-service-audit-topic", containerFactory = "listenerContainerFactory")
    public void clientServiceAuditTopicListener(AuditActionRequest actionRequest) {
        log.info("Action request from {} service", actionRequest.getServiceType().name());
        clientActionService.saveActionRequest(actionRequest);
    }

    @KafkaListener(topics = "${kafka.topic.car-service-audit-topic}", groupId = "car-service-audit-topic", containerFactory = "listenerContainerFactory")
    public void carServiceAuditTopicListener(AuditActionRequest actionRequest) {
        log.info("Action request from {} service", actionRequest.getServiceType().name());
        clientActionService.saveActionRequest(actionRequest);
    }

    @KafkaListener(topics = "${kafka.topic.rent-service-audit-topic}", groupId = "rent-service-audit-topic", containerFactory = "listenerContainerFactory")
    public void rentServiceAuditTopicListener(AuditActionRequest actionRequest) {
        log.info("Action request from {} service", actionRequest.getServiceType().name());
        clientActionService.saveActionRequest(actionRequest);
    }

    @KafkaListener(topics = "${kafka.topic.payment-service-audit-topic}", groupId = "payment-service-audit-topic", containerFactory = "listenerContainerFactory")
    public void paymentServiceAuditTopicListener(AuditActionRequest actionRequest) {
        log.info("Action request from {} service", actionRequest.getServiceType().name());
        clientActionService.saveActionRequest(actionRequest);
    }

    @KafkaListener(topics = "${kafka.topic.notification-service-audit-topic}", groupId = "notification-service-audit-topic", containerFactory = "listenerContainerFactory")
    public void notificationServiceAuditTopicListener(AuditActionRequest actionRequest) {
        log.info("Action request from {} service", actionRequest.getServiceType().name());
        clientActionService.saveActionRequest(actionRequest);
    }
}
