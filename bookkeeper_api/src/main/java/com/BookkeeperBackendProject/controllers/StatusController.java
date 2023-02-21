package com.BookkeeperBackendProject.controllers;

import com.BookkeeperBackendProject.models.OwnedBook;
import com.BookkeeperBackendProject.services.StatusService;
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
    public ResponseEntity<OwnedBook> getStatusById(@PathVariable Long id){
        OwnedBook ownedBook = statusService.getStatusById(id);
        if (ownedBook != null) {
            return new ResponseEntity<>(ownedBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<OwnedBook> updateStatus(@RequestBody OwnedBook ownedBook){
        ownedBook = statusService.addStatus(ownedBook);
        if (ownedBook != null) {
            return new ResponseEntity<>(ownedBook, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<OwnedBook> updateStatus(@PathVariable Long id, @RequestBody OwnedBook ownedBook){
        ownedBook = statusService.updateStatus(id, ownedBook);
        if (ownedBook != null) {
            return new ResponseEntity<>(ownedBook, HttpStatus.OK);
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
