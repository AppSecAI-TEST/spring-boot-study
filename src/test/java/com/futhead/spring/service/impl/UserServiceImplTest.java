package com.futhead.spring.service.impl;

import com.futhead.spring.service.UserService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * UserServiceImpl Tester.
 *
 * @author futhead
 * @version 1.0
 * @since <pre>07/27/2017</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userSerivce;

    @Before
    public void before() throws Exception {
        userSerivce.deleteAllUsers();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: create(String name, Integer age)
     */
    @Test
    public void testCreate() throws Exception {
        userSerivce.create("a", 1);
        userSerivce.create("b", 2);
        userSerivce.create("c", 3);
        userSerivce.create("d", 4);
        userSerivce.create("e", 5);
        // 查数据库，应该有5个用户
        Assert.assertEquals(5, userSerivce.getAllUsers().intValue());

        //删除两个用户
        userSerivce.deleteByName("a");
        userSerivce.deleteByName("b");

        Assert.assertEquals(3, userSerivce.getAllUsers().intValue());
    }

    /**
     * Method: deleteByName(String name)
     */
    @Test
    public void testDeleteByName() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getAllUsers()
     */
    @Test
    public void testGetAllUsers() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: deleteAllUsers()
     */
    @Test
    public void testDeleteAllUsers() throws Exception {
//TODO: Test goes here... 
    }


} 
