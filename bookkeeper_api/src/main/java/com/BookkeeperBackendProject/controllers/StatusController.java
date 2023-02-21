package com.BookkeeperBackendProject.controllers;

import com.BookkeeperBackendProject.models.Status;
import com.BookkeeperBackendProject.services.StatusService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Status> getStatusById(@PathVariable Long id){
        Status status = statusService.getStatusById(id);
        if (status != null) {
            return new ResponseEntity<>(status, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<Status> updateStatus(@RequestBody Status status){
        status = statusService.addStatus(status);
        if (status != null) {
            return new ResponseEntity<>(status, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Status> updateStatus(@PathVariable Long id, @RequestBody Status status){
        status = statusService.updateStatus(id, status);
        if (status != null) {
            return new ResponseEntity<>(status, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatus(@PathVariable Long id){
        boolean isDeleted = statusService.deleteStatus(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
