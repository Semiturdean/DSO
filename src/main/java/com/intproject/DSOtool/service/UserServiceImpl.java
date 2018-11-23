package com.intproject.DSOtool.service;


import com.intproject.DSOtool.data.Role;
import com.intproject.DSOtool.data.User;
import com.intproject.DSOtool.repositories.RoleRepository;
import com.intproject.DSOtool.repositories.UserRepository;
import com.intproject.DSOtool.service.exceptions.ServiceException;
import com.intproject.DSOtool.service.exceptions.UserException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User createNewUserAccount(User userDto){

        //validateUser(userDto);

        List<Role> roles;
        roles = userDto.getRoles();

        for (Role r : roles) {

            Optional<Role> role = roleRepository.findByRole(r.getRole());
            if(role.isPresent()){
                r.setId(role.get().getId());
            } else {
                throw new ServiceException(r.getRole() + " is not an existing role");
            }
        }

        String generatedSecuredPasswordHash = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt(12));
        userDto.setPassword(generatedSecuredPasswordHash);

        return userRepository.save(userDto);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        Optional <User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user;
        } else {
            throw new ServiceException("Couldn't find the ID in the database");
        }
    }

    @Override
    public void deleteUserById(Long id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
        } else {
            throw new UserException("A user with that ID could not be found or has already previously been deleted");
        }
    }

    @Override
    public User findUserByUsername(String username){
        Optional<User> user = userRepository.findByUserName(username);
        if(user.isPresent()){
            return user.get();
        } else {
            throw new UserException(String.format("A User with username: %s was not found", username));
        }
    }

    @Override
    public List<User> findByFirstName(String firstName) {
        List<User> userList = userRepository.findAllByFirstName(firstName);
        if(!userList.isEmpty()){
            return userList;
        } else {
            throw new UserException(String.format("No user with firstname %s was found", firstName));
        }
    }

    @Override
    public List<User> findByLastName(String lastName) {
        List<User> userList = userRepository.findAllByLastName(lastName);
        if(!userList.isEmpty()){
            return userList;
        } else {
            throw new UserException(String.format("No user with lastname %s was found", lastName));
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<User> user = userRepository.findByEmailAddress(email);
        if(user.isPresent()){
            return user;
        } else {
            throw new UserException(String.format("%s is not a registered email", email));
        }
    }

    @Override
    public Map<Role ,List<User>> findAllByRoles(List<Role> roles) {
        Map<Role, List<User>> map = new HashMap<>();
        for (Role role : roles) {
            List<User> userList = userRepository.findAllByRoles(role);
            map.put(role, userList);
        }
        if (!map.isEmpty()){
            return map;
        } else {
            throw new UserException("No users found");
        }
    }

    /*private void validateUser(User user) {
        if (user.getUserName().length() < 10) {
            throw new ServiceException("Username cannot be shorter than 10 characters");
        }

        List<Role> setOfRoles = checkForRepetition(user.getRoles());
    }

    private List<Role> checkForRepetition(List<Role> roles){


        
        return null;
    }*/
}
