package com.BookkeeperBackendProject.services;

import com.BookkeeperBackendProject.models.OwnedBook;
import com.BookkeeperBackendProject.models.ReviewInputDTO;
import com.BookkeeperBackendProject.models.StatusEnum;
import com.BookkeeperBackendProject.repositories.OwnedBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnedBookService {

    @Autowired
    private OwnedBookRepository ownedBookRepository;

    // The getStatusById() method retrieves a single status by its ID using the findById() method of the StatusRepository.

    public OwnedBook getOwnedBookById(Long id){
        return ownedBookRepository.findById(id).orElse(null);
    }

    public OwnedBook addOwnedBook(OwnedBook ownedBook){
        return ownedBookRepository.save(ownedBook);
    }

    public OwnedBook updateOwnedBook(Long id, OwnedBook ownedBook){
        OwnedBook existingOwnedBook = getOwnedBookById(id);
        if (existingOwnedBook != null) {
            existingOwnedBook.setStatus(ownedBook.getStatus());
            existingOwnedBook.setBook(ownedBook.getBook());
            existingOwnedBook.setUser(ownedBook.getUser());
            return ownedBookRepository.save(existingOwnedBook);
        } else {
            return null;
        }
    }

    public OwnedBook updateReview(ReviewInputDTO reviewInputDTO, OwnedBook ownedBook) throws Exception {
        OwnedBook existingOwnedBook = getOwnedBookById(ownedBook.getId());
        if (existingOwnedBook.getStatus() == StatusEnum.READ){
            existingOwnedBook.setReview(reviewInputDTO.getReview());
            existingOwnedBook.setRating(reviewInputDTO.getRating());
            return ownedBookRepository.save(existingOwnedBook);
        } else {
            throw new Exception("Read the book first to leave a review!");
        }
    }

    public boolean deleteOwnedBook(Long id){
        OwnedBook existingOwnedBook = getOwnedBookById(id);
        if (existingOwnedBook != null) {
            ownedBookRepository.delete(existingOwnedBook);
            return true;
        } else {
            return false;
        }
    }
}
