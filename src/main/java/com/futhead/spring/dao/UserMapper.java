package com.futhead.spring.dao;

import com.futhead.spring.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by futhead on 2017-7-28.
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE NAME = #{name}")
    User findByName(@Param("name") String name);


    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    /**
     * @Results加不加没影响
     * @return
     */
    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    @Select("SELECT NAME, AGE FROM USER")
    List<User> findAll();

}
