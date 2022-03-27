package com.ai.uaa.dao;


import com.ai.uaa.pojo.UaaUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {

    List<UaaUser> selectUser(@Param("name") String userName);
}
