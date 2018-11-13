package com.intproject.DSOtool.service.validators;

import com.intproject.DSOtool.data.User;
import com.intproject.DSOtool.repositories.RoleRepository;
import com.intproject.DSOtool.repositories.UserRepository;
import com.intproject.DSOtool.service.exceptions.UserExceptions;

public class UserValidation {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserValidation(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    private void validateUser(User user) {
        if (user.getUserName().length() < 10) {
            throw new UserExceptions("Username cannot be shorter than 10 characters");
        }
    }
}
