package com.BookkeeperBackendProject.services;

import com.BookkeeperBackendProject.models.OwnedBook;
import com.BookkeeperBackendProject.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    // The getStatusById() method retrieves a single status by its ID using the findById() method of the StatusRepository.
    public OwnedBook getStatusById(Long id){
        return statusRepository.findById(id).orElse(null);
    }

    public OwnedBook addStatus(OwnedBook ownedBook){
        return statusRepository.save(ownedBook);
    }

    public OwnedBook updateStatus(Long id, OwnedBook ownedBook){
        OwnedBook existingOwnedBook = getStatusById(id);
        if (existingOwnedBook != null) {
            existingOwnedBook.setStatus(ownedBook.getStatus());
            existingOwnedBook.setBook(ownedBook.getBook());
            existingOwnedBook.setUser_id(ownedBook.getUser);
            return statusRepository.save(existingOwnedBook);
        } else {
            return null;
        }
    }

    public boolean deleteStatus(Long id){
        OwnedBook existingOwnedBook = getStatusById(id);
        if (existingOwnedBook != null) {
            statusRepository.delete(existingOwnedBook);
            return true;
        } else {
            return false;
        }
    }
}
