package com.intproject.DSOtool.service;

import com.intproject.DSOtool.data.Role;
import com.intproject.DSOtool.repositories.RoleRepository;
import com.intproject.DSOtool.service.validators.RoleValidation;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role createNewRole(Role role){

        // TODO Skapa en metod som sparar en lista av roller

        /*RoleValidation roleValidation = new RoleValidation();
        roleValidation.validateRole(role.getRole()); */
        role.setRole(role.getRole().toLowerCase());
            return roleRepository.save(role);
    }
}
