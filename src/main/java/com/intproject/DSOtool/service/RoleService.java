package com.intproject.DSOtool.service;

import com.intproject.DSOtool.data.Role;
import com.intproject.DSOtool.data.User;

import java.util.List;

public interface RoleService {

    Role createNewRole(Role role);
    Role findById(Long id);
    Role findByRole(String role);
    List<Role> findByUserId(Long id);
    List<Role> findByUserName(String userName);
    List<Role> findByUserEmail(String email);
}
