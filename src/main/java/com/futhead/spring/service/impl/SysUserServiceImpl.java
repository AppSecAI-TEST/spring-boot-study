package com.futhead.spring.service.impl;

import com.futhead.spring.dao.SysUserRepository;
import com.futhead.spring.domain.SysUser;
import com.futhead.spring.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/7/30.
 */
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public SysUser findByUsername(String username) {
        return sysUserRepository.findByUsername(username);
    }
}
