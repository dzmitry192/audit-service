package com.innowise.sivachenko.mapper;

import com.innowise.sivachenko.kafka.avro.AuditActionRequest;
import com.innowise.sivachenko.model.dto.ClientActionDto;
import com.innowise.sivachenko.model.entity.ClientActionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClientActionMapper {

    ClientActionMapper INSTANCE = Mappers.getMapper(ClientActionMapper.class);

    ClientActionDto clientActionEntityToClientActionDto(ClientActionEntity clientActionEntity);

    @Mapping(target = "id", ignore = true)
    ClientActionEntity auditActionRequestToClientActionEntity(AuditActionRequest auditActionRequest);
}
