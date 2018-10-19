package com.intproject.DSOtool.service;

import com.intproject.DSOtool.data.CustomUserDetailsImpl;
import com.intproject.DSOtool.data.User;
import com.intproject.DSOtool.repositories.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;
    UserRepository userRepository;

    User user1;

    @Before
    public void setUp(){
        user1 = new User("Hejdåkkkkkk",
                "HejDå@gmail.com",
                "Hej",
                "password",
                "password");
    }

    @Test
    public void createUser(){
        userService.createNewUserAccount(user1);
    }

    @After
    public void setupAfter(){
        userService.deleteUserById(1L);
    }
}
