package com.innowise.sivachenko.repository;

import com.innowise.sivachenko.model.entity.ClientActionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientActionRepository extends JpaRepository<ClientActionEntity, Long>, JpaSpecificationExecutor<ClientActionEntity> {
}