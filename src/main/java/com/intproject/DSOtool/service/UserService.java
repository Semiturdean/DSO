package com.intproject.DSOtool.service;


import com.intproject.DSOtool.data.Role;
import com.intproject.DSOtool.data.User;
import com.intproject.DSOtool.data.enums.RoleEnum;
import com.intproject.DSOtool.repositories.RoleRepository;
import com.intproject.DSOtool.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import com.intproject.DSOtool.service.exceptions.UserExceptions;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {


    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User createNewUserAccount(User userDto){

        //validateUser(userDto);

        List<Role> roles;
        roles = userDto.getRoles();
        for (Role r : roles) {

            Optional<Role> role = roleRepository.findByRole(r.getRole());
            if(!role.isPresent()){
                roleRepository.save(r);
            }
            userDto.setRoles(roles);
        }

        String generatedSecuredPasswordHash = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt(12));
        userDto.setPassword(generatedSecuredPasswordHash);

        return userRepository.save(userDto);
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

    protected User findUserByUsername(String username){
        return userRepository.findByUserName(username).get();
    }

    /*private void validateUser(User user) {
        if (user.getUserName().length() < 10) {
            throw new UserExceptions("Username cannot be shorter than 10 characters");
        }

        List<Role> setOfRoles = checkForRepetition(user.getRoles());
    }

    private List<Role> checkForRepetition(List<Role> roles){


        
        return null;
    }*/
}
