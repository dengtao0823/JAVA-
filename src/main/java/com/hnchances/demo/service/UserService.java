package com.hnchances.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hnchances.demo.pojo.User;
import org.springframework.stereotype.Service;


@Service
public interface UserService  {
    String getPassword(String username);


    String getRole(String username);

    int setUset(User user);

    int updateUser(User user);

    int deleteUser(int userId);

    User selectUser(String userName);

}
