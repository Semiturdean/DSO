package com.intproject.DSOtool.service.validators;

import com.intproject.DSOtool.data.Role;
import com.intproject.DSOtool.data.enums.RoleEnum;
import com.intproject.DSOtool.service.exceptions.UserExceptions;


public class RoleValidation {

    public RoleValidation() { }

    public void validateRole(String role){
        if(role == null){
            throw new UserExceptions("No role was appointed");
        }
        else if(!role.equalsIgnoreCase(String.valueOf(RoleEnum.ADMIN)) && !role.equalsIgnoreCase(String.valueOf(RoleEnum.CONSULTANT))) {
            throw new UserExceptions(role + " is not a valid role");
        }
    }
}
