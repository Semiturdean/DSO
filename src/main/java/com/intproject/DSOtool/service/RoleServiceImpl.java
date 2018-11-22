package com.intproject.DSOtool.service;

import com.intproject.DSOtool.data.Role;
import com.intproject.DSOtool.data.User;
import com.intproject.DSOtool.repositories.RoleRepository;
import com.intproject.DSOtool.repositories.UserRepository;
import com.intproject.DSOtool.service.exceptions.RoleException;
import com.intproject.DSOtool.service.exceptions.UserException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;
    private UserRepository userRepository;

    public RoleServiceImpl(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Role createNewRole(Role role){

        // TODO Skapa en metod som sparar en lista av roller

        if(roleRepository.findByRole(role.getRole()).isPresent()){
            throw new RoleException(String.format("%s is already an existing role", role.getRole()));
        } else {
        /*RoleValidation roleValidation = new RoleValidation();
        roleValidation.validateRole(role.getRole()); */
            role.setRole(role.getRole().toLowerCase());
            return roleRepository.save(role);
        }
    }

    @Override
    public Role findById(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        if(role.isPresent()){
            return role.get();
        } else {
            throw new RoleException(String.format("The role with ID: %d" , id));
        }
    }

    @Override
    public Role findByRole(String roleName) {
        Optional<Role> role = roleRepository.findByRole(roleName);
        if(role.isPresent()){
            return role.get();
        } else {
            throw new RoleException(String.format("%s could not be found", roleName));
        }
    }

    @Override
    public List<Role> findByUserId(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
           return user.get().getRoles();
        } else {
            throw new UserException(String.format("No user was found with id: %d", id));
        }
    }

    @Override
    public List<Role> findByUserName(String userName) {
        Optional<User> user = userRepository.findByUserName(userName);
        if(user.isPresent()){
            return user.get().getRoles();
        }  else {
            throw new UserException(String.format("No user was found with username: %s", userName));
        }
    }

    @Override
    public List<Role> findByUserEmail(String email) {
        Optional<User> user = userRepository.findByEmailAddress(email);
        if(user.isPresent()){
            return user.get().getRoles();
        } else {
            throw new UserException(String.format("No user was found with email: %s", email));
        }
    }
}
