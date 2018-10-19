package com.intproject.DSOtool.service;


import com.intproject.DSOtool.data.User;
import com.intproject.DSOtool.repositories.RoleRepository;
import com.intproject.DSOtool.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import com.intproject.DSOtool.service.exceptions.UserExceptions;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User createNewUserAccount(User userDto){

        //temporary until the configuration class works properly, then it should auto-generate the encoder
       String generatedSecuredPasswordHash = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt(12));

        return userRepository.save(new User(
                userDto.getUsername(),
                userDto.getEmailadress(),
                userDto.getFirstname(),
                userDto.getLastname(),
                generatedSecuredPasswordHash));
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
        if (user.getUsername().length() < 10) {
            throw new UserExceptions("Username cannot be shorter than 10 characters");
        }
    }
}
