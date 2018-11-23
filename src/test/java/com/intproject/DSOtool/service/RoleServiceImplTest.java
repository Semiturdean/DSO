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
public class RoleServiceImplTest extends TestBase {

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
    public void getRoleByRoleTest() {
        super.getRoleByRoleTest();
    }

    @Override
    @Test
    public void getRoleByIdTest() {
        super.getRoleByIdTest();
    }

    @Override
    @Test
    public void getRolesByUserIdTest() {
        super.getRolesByUserIdTest();
    }

    @Override
    @Test
    public void getRolesByUserEmailTest() {
        super.getRolesByUserEmailTest();
    }

    @Override
    @Test
    public void getRolesByUserNameTest() {
        super.getRolesByUserNameTest();
    }

    @Override
    @After
    public void tearDown() {
        super.tearDown();
    }
}
