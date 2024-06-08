package com.yazdi.projectManagementSystem.repository;

import com.yazdi.projectManagementSystem.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
