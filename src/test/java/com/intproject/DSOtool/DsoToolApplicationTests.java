package com.intproject.DSOtool;

import com.intproject.DSOtool.data.Role;
import com.intproject.DSOtool.data.User;
import com.intproject.DSOtool.data.enums.RoleEnum;
import com.intproject.DSOtool.repositories.RoleRepository;
import com.intproject.DSOtool.repositories.UserRepository;
import com.intproject.DSOtool.service.RoleService;
import com.intproject.DSOtool.service.UserService;
import com.intproject.DSOtool.service.UserServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DsoToolApplicationTests {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleService roleService;
    @Autowired
    RoleRepository roleRepository;

    private User user1;
    private User user2;
    private User user3;

    private Role role1;
    private Role role2;

    @Before
    public void setUp(){
        role1 = new Role(String.valueOf(RoleEnum.CONSULTANT).toLowerCase());
        role2 = new Role(String.valueOf(RoleEnum.ADMIN).toLowerCase());
        List<Role> roles = new ArrayList<>();
        roles.add(role1);
        roles.add(role2);

        user1 = new User("Hejdåkkkkkk1",
                "HejDå1@gmail.com",
                "Hej",
                "password",
                "password", roles
        );
        user2 = new User("Hejdåkkkkkk11",
                "HejDå11@gmail.com",
                "Hej1",
                "password",
                "password", roles
        );
        user3 = new User("Hejdåkkkkkk111",
                "HejDå111@gmail.com",
                "Hej2",
                "password",
                "password", roles
        );

        roleService.createNewRole(role1);
        roleService.createNewRole(role2);

        userService.createNewUserAccount(user1);
        userService.createNewUserAccount(user2);
        userService.createNewUserAccount(user3);



    }

    @Test
    public void contextLoads() {
    }

    @After
    public void setupAfter(){
        //delete database
    }
}