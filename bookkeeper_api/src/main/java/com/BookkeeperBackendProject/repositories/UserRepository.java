package com.BookkeeperBackendProject.repositories;

import com.BookkeeperBackendProject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {
    User findByEmail(String email);
}
