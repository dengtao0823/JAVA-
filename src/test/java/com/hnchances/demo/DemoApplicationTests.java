package com.hnchances.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hnchances.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
private UserMapper userMapper;

    @Test
    void contextLoads() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("userName","admin");

        System.out.println(userMapper.selectOne(queryWrapper));
    }

}
