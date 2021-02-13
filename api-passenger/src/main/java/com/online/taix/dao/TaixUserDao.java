package com.online.taix.dao;

import com.online.taix.dto.UserParam;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaixUserDao {
    UserParam findByUserName(String username);
}
