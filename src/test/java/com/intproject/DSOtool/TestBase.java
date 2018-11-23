package com.intproject.DSOtool;

import com.intproject.DSOtool.data.Role;
import com.intproject.DSOtool.data.User;
import com.intproject.DSOtool.data.enums.RoleEnum;
import com.intproject.DSOtool.repositories.RoleRepository;
import com.intproject.DSOtool.repositories.UserRepository;
import com.intproject.DSOtool.service.RoleService;
import com.intproject.DSOtool.service.UserServiceImpl;
import com.intproject.DSOtool.service.exceptions.UserException;
import junit.framework.TestCase;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class TestBase extends TestCase {

    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleService roleServiceImpl;
    @Autowired
    RoleRepository roleRepository;

    protected User user1;
    protected User user2;
    protected User user3;
    protected Role role1;
    protected Role role2;
    protected List<Role> roles = new ArrayList<>();

    @Override
    protected void setUp() throws Exception {
        role1 = new Role(String.valueOf(RoleEnum.ADMIN).toLowerCase());
        role2 = new Role(String.valueOf(RoleEnum.CONSULTANT).toLowerCase());
        roles.add(role1);
        roles.add(role2);
        user1 = new User("user1",
                "HejDå1@gmail.com",
                "Hej",
                "password",
                "password", roles
        );
        user2 = new User("user2",
                "HejDå11@gmail.com",
                "Hej",
                "password",
                "password", roles
        );
        user3 = new User("user3",
                "HejDå111@gmail.com",
                "Hej",
                "password",
                "password", roles
        );

        userServiceImpl.createNewUserAccount(user1);
        userServiceImpl.createNewUserAccount(user2);
        userServiceImpl.createNewUserAccount(user3);
    }


    public void getUserByUserNameTest(){
        userServiceImpl.findUserByUsername(user1.getUserName());
        userServiceImpl.findUserByUsername(user2.getUserName());
        userServiceImpl.findUserByUsername(user3.getUserName());
    }

    public void getUserByIdTest(){
        Optional<User> user = userRepository.findByUserName(user1.getUserName());
            userServiceImpl.findUserById(user.get().getId());
    }

    public void getUsersByFirstNameTest(){
        userServiceImpl.findByFirstName(user1.getFirstName());
    }

    public void getUsersByLastNameTest(){
        userServiceImpl.findByLastName(user1.getLastName());
    }

    public void getUserByEmailTest(){
        userServiceImpl.findByEmail(user1.getEmailAddress());
    }

    public void getUserByRolesTest(){
        userServiceImpl.findAllByRoles(roles);
    }

    public void getRoleByIdTest(){
        Optional<Role> role = roleRepository.findByRole(role1.getRole());
        if(role.isPresent()){
            roleServiceImpl.findById(role.get().getId());
        }
    }

    public void getRoleByRoleTest(){
        roleServiceImpl.findByRole(role1.getRole());
        roleServiceImpl.findByRole(role2.getRole());
    }

    public void getRolesByUserIdTest(){
        Optional<User> user = userRepository.findByUserName(user1.getUserName());
        if(user.isPresent()){
            roleServiceImpl.findByUserId(user.get().getId());
        }
    }

    public void getRolesByUserNameTest(){
        roleServiceImpl.findByUserName(user1.getUserName());
    }

    public void getRolesByUserEmailTest(){
        roleServiceImpl.findByUserEmail(user1.getEmailAddress());
    }

    protected void tearDown(){
        Optional<User> optionalUser1 = userRepository.findByUserName(user1.getUserName());
        if(optionalUser1.isPresent()){
            userRepository.deleteById(optionalUser1.get().getId());
        }

        Optional<User> optionalUser2 = userRepository.findByUserName(user2.getUserName());
        if(optionalUser2.isPresent()){
            userRepository.deleteById(optionalUser2.get().getId());
        }

        Optional<User> optionalUser3 = userRepository.findByUserName(user3.getUserName());
        if(optionalUser3.isPresent()){
            userRepository.deleteById(optionalUser3.get().getId());
        }
    }
}
