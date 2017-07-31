package com.futhead.spring.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Administrator on 2017/7/30.
 */
@Mapper
public interface SysUserMapper {

//    @Select("SELECT sru.*, sr.name FROM sys_user su LEFT JOIN sys_role_user sru ON su.id = sru.sys_user_id LEFT JOIN sys_role sr ON sru.sys_role_id = sr.id WHERE username = #{username}")
//    SysUser findByUsername(String username);
}
