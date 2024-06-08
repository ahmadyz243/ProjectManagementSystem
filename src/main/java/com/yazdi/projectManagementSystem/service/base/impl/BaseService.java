package com.yazdi.projectManagementSystem.service.base.impl;

import com.yazdi.projectManagementSystem.domain.base.BaseEntity;
import com.yazdi.projectManagementSystem.dto.base.BaseDto;
import com.yazdi.projectManagementSystem.exception.EntityNotFoundException;
import com.yazdi.projectManagementSystem.mapper.IMapper;
import com.yazdi.projectManagementSystem.service.base.IBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public abstract class BaseService<T extends BaseEntity, DTO extends BaseDto, R extends JpaRepository<T, Long>>
        implements IBaseService<DTO> {
    protected BaseService(R repository, IMapper<T, DTO> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    protected final R repository;
    protected final IMapper<T, DTO> mapper;


    @Override
    public DTO save(DTO dto) {
        log.info("save; input: {}", dto);
        T t = mapper.dtoToEntity(dto);
        repository.save(t);
        dto = mapper.entityToDto(t);
        log.info("save; result: {}", dto);
        return dto;
    }

    @Override
    public List<DTO> saveAll(List<DTO> dtos) {
        log.info("saveAll; number of inputs: {}", dtos.size());
        List<T> entities = new ArrayList<>();
        for(DTO dto: dtos){
            entities.add(
                    mapper.dtoToEntity(dto)
            );
        }
        repository.saveAll(entities);
        dtos.clear();
        for(T t: entities){
            dtos.add(
                    mapper.entityToDto(t)
            );
        }
        log.info("saveAll; result: {}", dtos);
        return dtos;
    }

    @Override
    public DTO findById(Long id) {
        log.info("findById: input: {}", id);
        T t = repository.findById(id).get();
        DTO dto = mapper.entityToDto(t);
        log.info("findById; result: {}", dto);
        return dto;
    }

    @Override
    public List<DTO> findAll() {
        log.info("findAll invoked");
        List<T> entities = repository.findAll();
        List<DTO> dtos = new ArrayList<>();
        for(T t: entities){
            dtos.add(
                    mapper.entityToDto(t)
            );
        }
        log.info("findAll; number of results: {}", dtos.size());
        return dtos;
    }

    @Override
    public DTO update(DTO dto) {
        log.info("update: input: {}", dto);
        if(!repository.existsById(dto.getId())){
            throw new EntityNotFoundException(String.format("entity not found with this id: %d", dto.getId()));
        }
        T t = repository.save(mapper.dtoToEntity(dto));
        dto = mapper.entityToDto(t);
        log.info("update; result: {}", dto);
        return dto;
    }

    @Override
    public void deleteById(Long id) {
        log.info("deleteById; input: {}", id);
        repository.deleteById(id);
        log.info("entity deleted successfully");
    }

    @Override
    public boolean existsById(Long id) {
        log.info("existsById; input: {}", id);
        var exists = repository.existsById(id);
        log.info("existsById; output: {}", exists);
        return exists;
    }

}