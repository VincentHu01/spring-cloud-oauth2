package com.ai.uaa.service;


import com.ai.uaa.dao.UserDao;
import com.ai.uaa.pojo.UaaUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;


@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("执行了loadUserByUsername方法");

        List<UaaUser> user = userDao.selectUser(s);

        if (CollectionUtils.isEmpty(user)) {
            throw new UsernameNotFoundException("用户名不存在！！！");
        }

        String password = passwordEncoder.encode(user.get(0).getPassword());
        return new User(s, password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal"));
    }
}
