package com.mzl.dubboprovider;

import com.mzl.dubboapi.service.UserService;
import com.mzl.dubbocommon.entity.User;
import com.mzl.dubboprovider.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.Page;
import org.assertj.core.api.Assertions;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;
    
    @Test
    public void testMapper(){
        User user = new User();
        user.setUsername("lisi");
        user.setPassword("88888");
        user.setAge(20);
        user.setSex(0);
        user.setPhone("13678956739");
        userMapper.insert(user);
    }

    @Test
    public void testMapperWithPage(){
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setUsername("lisi");
            user.setPassword("88888");
            user.setAge(20 + i);
            user.setSex(1);
            user.setPhone("13678956739");
            userMapper.insert(user);
        }

        Page<User> byIdGreaterThanWithPage = userService.findPageByIdGreater(0, 1, 20);
        Assertions.assertThat(byIdGreaterThanWithPage.getPageSize()).isGreaterThanOrEqualTo(2);
        Assertions.assertThat(byIdGreaterThanWithPage.size()).isEqualTo(2);
    }
}