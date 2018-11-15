package com.intproject.DSOtool.service.validators;

import com.intproject.DSOtool.data.enums.RoleEnum;
import com.intproject.DSOtool.service.exceptions.ServiceException;


public class RoleValidation {

    public RoleValidation() { }

    public void validateRole(String role){
        if(role == null){
            throw new ServiceException("No role was appointed");
        }
        else if(!role.equalsIgnoreCase(String.valueOf(RoleEnum.ADMIN)) && !role.equalsIgnoreCase(String.valueOf(RoleEnum.CONSULTANT))) {
            throw new ServiceException(role + " is not a valid role");
        }
    }
}
