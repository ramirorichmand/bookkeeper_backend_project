package com.BookkeeperBackendProject.services;

import com.BookkeeperBackendProject.models.User;
import com.BookkeeperBackendProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return user.orElse(null);
    }

    public User getUserById(Long id){
        Optionl<User>user = userRepository.findById(id);
        return user.orElse(null);

    }

    public User updateUser(int id, User user) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            return userRepository.save(existingUser);
        } else {
            return null;
        }
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email);

    }


}
