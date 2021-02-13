package com.online.taix.dao;

import com.online.taix.dto.AliMessageTemplate;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AliMessageDao {
    AliMessageTemplate getTemplate(Integer templateid);
}
