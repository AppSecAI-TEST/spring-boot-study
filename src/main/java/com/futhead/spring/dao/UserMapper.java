package com.futhead.spring.dao;

import com.futhead.spring.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.cache.annotation.CachePut;

import java.util.List;
import java.util.Map;

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

    @CachePut(cacheNames = "users")
    @Update("UPDATE USER SET AGE = #{age} WHERE NAME = #{name}")
    void update(User user);

    @Delete("DELETE FROM USER WHERE ID = #{id}")
    void delete(Long id);

    @Insert("INSERT INTO USER(NAME, AGE) VALUES (#{name, jdbcType=VARCHAR}, #{age, jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    @SelectProvider(type = UserSqlBuilder.class, method = "buildUserQuery")
    List<User> userQuery(User user);

    class UserSqlBuilder {

        public String buildUserQuery(final User user) {
            return  new SQL(){{
                SELECT("*");
                FROM("user");
                if (user.getName() != null) {
                    WHERE("name = '" + user.getName() + "'");
                }
                if(user.getAge() != null) {
                    WHERE("age = " + user.getAge());
                }

            }}.toString();
        }
    }
}
