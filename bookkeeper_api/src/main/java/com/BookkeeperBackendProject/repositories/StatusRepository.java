package com.BookkeeperBackendProject.repositories;

import com.BookkeeperBackendProject.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusRepository extends JpaRepository<Status, Long> {

}
