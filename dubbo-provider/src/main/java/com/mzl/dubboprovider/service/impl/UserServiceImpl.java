package com.mzl.dubboprovider.service.impl;

import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.alibaba.dubbo.config.annotation.Service;
import com.mzl.dubboapi.service.UserService;
import com.mzl.dubbocommon.entity.User;
import com.mzl.dubboprovider.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String sayHello(String name) {
        return "Hello！" + name + "！" + new Date();
    }

    @Override
    public Page<User> findPageByIdGreater(Integer minId, int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        return userMapper.findPageByIdGreater(minId);
    }

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    @Override
    public User findByUsername(String username) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username", username);
        return userMapper.selectOne(queryWrapper);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Override
    public String addUser(User user) {
        userMapper.insert(user);
        return "添加用户成功";
    }

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<User> findAllUser() {
        QueryWrapper queryWrapper = new QueryWrapper();
        return userMapper.selectList(queryWrapper);
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @Override
    public String updateUser(User user) {
        userMapper.updateById(user);
        return "更新用户成功";
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @Override
    public String deleteUser(Integer userId) {
        userMapper.deleteById(userId);
        return "删除用户成功";
    }

}