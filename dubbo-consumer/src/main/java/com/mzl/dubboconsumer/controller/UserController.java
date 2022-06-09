package com.mzl.dubboconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.Page;
import com.mzl.dubboapi.service.UserService;
import com.mzl.dubbocommon.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName :   UserController
 * @Description: 用户控制器
 * @Author: mzl
 * @CreateDate: 2022/6/2 15:20
 * @Version: 1.0
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Reference
    private UserService userService;

    /**
     * 说hello方法（测试）
     * @param name
     * @return
     */
    @GetMapping("/sayHello")
    public String sayHello(String name){
        return userService.sayHello(name);
    }

    /**
     * 分页模糊查询大于每个id的所有用户
     * @param id
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/findPageByIdGreater")
    public Page<User> findPageByIdGreater(Integer id, int page, int pageSize){
        return userService.findPageByIdGreater(id, page, pageSize);
    }

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    @GetMapping("/findByUsername")
    public User findByUsername(String username){
        return userService.findByUsername(username);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping("/addUser")
    public String addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping("/findAllUser")
    public List<User> findAllUser(){
        return userService.findAllUser();
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @PostMapping("/updateUser")
    public String updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @GetMapping("/deleteUser")
    public String deleteUser(Integer userId){
        return userService.deleteUser(userId);
    }

}
