package com.futhead.spring.dao;

import com.futhead.spring.domain.User;
import org.apache.ibatis.annotations.Select;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by futhead on 2017-7-28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testCreate() throws Exception {
        userMapper.insert("futhead", 28);
        userMapper.insert("mohan", 27);
    }

    @Test
    public void testFindByName() throws Exception {
        User futhead = userMapper.findByName("futhead");
        Assert.assertEquals(futhead.getAge().intValue(), 28);
    }

    @Test
    public void testFindAll() throws Exception {
        List<User> users = userMapper.findAll();
        for (User user: users) {
            System.out.println(user.toString());
        }
    }


}
