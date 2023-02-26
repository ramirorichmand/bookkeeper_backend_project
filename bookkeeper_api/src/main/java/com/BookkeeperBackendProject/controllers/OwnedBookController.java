package com.BookkeeperBackendProject.controllers;

import com.BookkeeperBackendProject.models.OwnedBook;
import com.BookkeeperBackendProject.models.ReviewInputDTO;
import com.BookkeeperBackendProject.services.OwnedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ownedBooks")
public class OwnedBookController {

    @Autowired
    private OwnedBookService ownedBookService;

    //get all owned books - method
//    @GetMapping(value = "ownedBooks")
//    public ResponseEntity<OwnedBook> getAllOwnedBooks(){
//        OwnedBook ownedBook = ownedBookService.g
//    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OwnedBook> getOwnedBookById(@PathVariable Long id){
        OwnedBook ownedBook = ownedBookService.getOwnedBookById(id);
        if (ownedBook != null) {
            return new ResponseEntity<>(ownedBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //create status method?

    @PostMapping
    public ResponseEntity<OwnedBook> createOwnedBook(@RequestBody OwnedBook ownedBook){
        ownedBook = ownedBookService.addOwnedBook(ownedBook);
        if (ownedBook != null) {
            return new ResponseEntity<>(ownedBook, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<OwnedBook> updateOwnedBook(@PathVariable Long id, @RequestBody OwnedBook ownedBook){
        ownedBook = ownedBookService.updateOwnedBook(id, ownedBook);
        if (ownedBook != null) {
            return new ResponseEntity<>(ownedBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PatchMapping(value = "/{id}/reviews")
    public ResponseEntity<OwnedBook> updateReview(@PathVariable Long id, @RequestBody ReviewInputDTO reviewInputDTO) throws Exception {
        OwnedBook ownedBook = new OwnedBook();
        ownedBook.setId(id);
        ownedBook.setReview(reviewInputDTO.getReview());

        ownedBook = ownedBookService.updateReview(reviewInputDTO, ownedBook);
        if (ownedBook != null){
            return new ResponseEntity<>(ownedBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOwnedBook(@PathVariable Long id){
        boolean isDeleted = ownedBookService.deleteOwnedBook(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
