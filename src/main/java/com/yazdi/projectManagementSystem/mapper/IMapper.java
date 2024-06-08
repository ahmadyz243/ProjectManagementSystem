package com.yazdi.projectManagementSystem.mapper;

import com.yazdi.projectManagementSystem.domain.base.BaseEntity;

public interface IMapper<T extends BaseEntity, DTO> {

    T dtoToEntity(DTO dto);
    DTO entityToDto(T entity);

}