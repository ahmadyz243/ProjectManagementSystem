package com.yazdi.projectManagementSystem.repository;

import com.yazdi.projectManagementSystem.domain.User;
import com.yazdi.projectManagementSystem.enumiration.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    Long countByRole(UserRole role);

}