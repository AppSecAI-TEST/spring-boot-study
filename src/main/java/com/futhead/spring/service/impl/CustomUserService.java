package com.futhead.spring.service.impl;

import com.futhead.spring.dao.SysRoleMapper;
import com.futhead.spring.dao.SysUserRepository;
import com.futhead.spring.domain.SysRole;
import com.futhead.spring.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/30.
 */
@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser user = sysUserRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        //用于添加用户权限
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        List<SysRole> roles = sysRoleMapper.findRolesById(user.getId());
        for (SysRole role: roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new User(user.getUsername(), user.getPassword(), authorities);
    }
}
