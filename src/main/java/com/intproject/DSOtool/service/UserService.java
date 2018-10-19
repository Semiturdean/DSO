package com.intproject.DSOtool.service;

import com.intproject.DSOtool.data.User;
import com.intproject.DSOtool.repositories.UserRepository;
import com.intproject.DSOtool.service.exceptions.UserExceptions;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createNewUserAccount(User userDto){

        return userRepository.save(new User(
                userDto.getUsername(),
                userDto.getEmailadress(),
                userDto.getFirstname(),
                userDto.getLastname(),
                userDto.getPassword()));
    }

    public Optional<User> findUserById(Long id) {
        Optional <User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user;
        } else {
            throw new UserExceptions("ID is non-existent");
        }
    }

    public void deleteUserById(Long id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
        }
    }

    public User findUserByUsername(String username){
        return userRepository.findByUsername(username).get();
    }
    private void validateUser(User user) {
        if (user.getFirstname() == null || user.getLastname() == null || user.getUsername() == null) {
            throw new UserExceptions("All required values for the user has not been assigned");
        }
        if (user.getUsername().length() < 10) {
            throw new UserExceptions("Username cannot be shorter than 10 characters");
        }
    }
}
