package com.intproject.DSOtool.service;

import com.intproject.DSOtool.data.Role;
import com.intproject.DSOtool.data.User;
import com.intproject.DSOtool.repositories.RoleRepository;
import com.intproject.DSOtool.repositories.UserRepository;
import com.intproject.DSOtool.service.exceptions.UserExceptions;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public RoleService(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    public Role createNewRole(Role role){

        return roleRepository.save(new Role(role.getRole()));

    }

    public void assignRoleToUser(Long id, Long userid){
        Optional<User> user = userRepository.findById(userid);
        Optional<Role> role = roleRepository.findById(id);

        if(!user.isPresent()){
            throw new UserExceptions("User not found");
        } else if (!role.isPresent()){
            throw new UserExceptions("Role has not been declared");
        } else if (user.get().getRoles() == null){
            user.ifPresent(u -> {
                role.get().setUsers(u);
                userRepository.save(user.get());
            });
        }
    }
}
