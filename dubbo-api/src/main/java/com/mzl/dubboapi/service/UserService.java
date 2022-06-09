package com.mzl.dubboapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.Page;
import com.mzl.dubbocommon.entity.User;

import java.util.List;


public interface UserService extends IService<User> {

    String sayHello(String name);

    /**
     * 根据用户名查询用户
     * @param username
     */
    User findByUsername(String username);

    /**
     * 分页模糊查询大于每个id的所有用户
     * @param id
     * @param page
     * @param pageSize
     * @return
     */
    Page<User> findPageByIdGreater(Integer id, int page, int pageSize);

    /**
     * 添加用户
     * @param user
     * @return
     */
    String addUser(User user);

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAllUser();

    /**
     * 更新用户
     * @param user
     * @return
     */
    String updateUser(User user);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    String deleteUser(Integer userId);
}