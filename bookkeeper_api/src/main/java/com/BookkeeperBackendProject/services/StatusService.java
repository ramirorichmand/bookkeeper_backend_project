package com.BookkeeperBackendProject.services;

import com.BookkeeperBackendProject.models.Status;
import com.BookkeeperBackendProject.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    // The getStatusById() method retrieves a single status by its ID using the findById() method of the StatusRepository.
    public Status getStatusById(Long id){
        return statusRepository.findById(id).orElse(null);
    }

    public Status addStatus(Status status){
        return statusRepository.save(status);
    }

    public Status updateStatus(Long id, Status status){
        Status existingStatus = getStatusById(id);
        if (existingStatus != null) {
            existingStatus.setStatus(status.getStatus());
            existingStatus.setBook(status.getBook());
            existingStatus.setUser_id(status.getUser);
            return statusRepository.save(existingStatus);
        } else {
            return null;
        }
    }

    public boolean deleteStatus(Long id){
        Status existingStatus = getStatusById(id);
        if (existingStatus != null) {
            statusRepository.delete(existingStatus);
            return true;
        } else {
            return false;
        }
    }
}
