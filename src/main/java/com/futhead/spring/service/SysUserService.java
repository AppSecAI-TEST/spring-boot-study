package com.futhead.spring.service;

import com.futhead.spring.domain.SysUser;

/**
 * Created by Administrator on 2017/7/30.
 */
public interface SysUserService {

    SysUser findByUsername(String username);

}
