package com.intproject.DSOtool.service;


import com.intproject.DSOtool.TestBase;
import com.intproject.DSOtool.repositories.RoleRepository;
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
public class UserServiceImplTest extends TestBase {

    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleService roleServiceImpl;
    @Autowired
    RoleRepository roleRepository;


    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Override
    @Test
    public void getUserByUserNameTest() {
        super.getUserByUserNameTest();
    }

    @Override
    @Test
    public void getUserByIdTest() {
        super.getUserByIdTest();
    }

    @Override
    @Test
    public void getUsersByFirstNameTest() {
        super.getUsersByFirstNameTest();
    }

    @Override
    @Test
    public void getUsersByLastNameTest() {
        super.getUsersByLastNameTest();
    }

    @Override
    @Test
    public void getUserByEmailTest() {
        super.getUserByEmailTest();
    }

    @Override
    @Test
    public void getUserByRolesTest() {
        super.getUserByRolesTest();
    }

    @Override
    @After
    public void tearDown() {
        super.tearDown();
    }
}
