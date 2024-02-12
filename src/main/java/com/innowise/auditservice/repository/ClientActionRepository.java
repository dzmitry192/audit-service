package com.innowise.auditservice.repository;

import com.innowise.auditservice.model.entity.ClientActionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientActionRepository extends JpaRepository<ClientActionEntity, Long> {
}
