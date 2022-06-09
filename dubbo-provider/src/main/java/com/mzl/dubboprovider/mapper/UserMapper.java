package com.mzl.dubboprovider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.mzl.dubbocommon.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    Page<User> findPageByIdGreater(@Param("minId")Integer minId);
}