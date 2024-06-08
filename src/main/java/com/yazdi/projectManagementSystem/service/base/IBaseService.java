package com.yazdi.projectManagementSystem.service.base;

import com.yazdi.projectManagementSystem.dto.base.BaseDto;

import java.util.List;

public interface IBaseService<DTO extends BaseDto> {

    DTO save(DTO dto);
    List<DTO> saveAll(List<DTO> dtos);
    DTO findById(Long id);
    List<DTO> findAll();
    DTO update(DTO dto);
    void deleteById(Long id);
    boolean existsById(Long id);

}