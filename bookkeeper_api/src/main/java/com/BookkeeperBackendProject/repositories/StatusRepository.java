package com.BookkeeperBackendProject.repositories;

import com.BookkeeperBackendProject.models.OwnedBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<OwnedBook, Long> {

}
