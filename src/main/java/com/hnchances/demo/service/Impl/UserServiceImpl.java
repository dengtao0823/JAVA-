package com.hnchances.demo.service.Impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnchances.demo.mapper.UserMapper;
import com.hnchances.demo.pojo.User;
import com.hnchances.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Collection;
import java.util.Map;
import java.util.function.Function;


@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    @Lazy
    private UserMapper userMapper;

    @Override
    public String getPassword(String username) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("userName",username);
        if (userMapper.selectOne(queryWrapper) !=null)
        return userMapper.selectOne(queryWrapper).getPassWord();
        else
            return null;
    }

    @Override
    public String getRole(String username) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("userName",username);
        int identity= userMapper.selectOne(queryWrapper).getIdentity();
        if (identity ==0){
            return "学生";
        }
        else if (identity == 1){
             return "老师";
        }
        else if (identity == 2){
            return "领导";
        }
        else return  "用户权限出错";
    }

    @Override
    public int setUset(User user) {
        user.setCreatDateTime(Calendar.getInstance().getTime());
        user.setUpdateDateTime(Calendar.getInstance().getTime());
        user.setLastLoginDateTime(Calendar.getInstance().getTime());
        user.setStatus("0");
        user.setVerify("1");
        return userMapper.insert(user);
    }

    @Override
    public int updateUser( User user) {
        return userMapper.updateById(user);
    }

    @Override
    public int deleteUser(int userId) {
        User user = userMapper.selectById(userId);
        user.setStatus("1");
        return userMapper.updateById(user);
    }

    @Override
    public User selectUser(String userName) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("userName",userName);
        return userMapper.selectOne(queryWrapper);
    }



}
