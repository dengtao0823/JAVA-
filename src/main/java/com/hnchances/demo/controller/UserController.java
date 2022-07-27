package com.hnchances.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hnchances.demo.mapper.UserMapper;
import com.hnchances.demo.pojo.User;
import com.hnchances.demo.pojo.basic.Msg;
import com.hnchances.demo.service.UserService;
import com.hnchances.demo.util.JWTUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping(value = "/user")
@Api(tags = "标准演示接口")
public class UserController {

    @Resource
    private UserService userService;

    /*
    用户登录
     */
    @ResponseBody
    @PostMapping("/login")
    public Msg login(@RequestBody User user){
        String userName = user.getUserName();
        String passWord = user.getPassWord();
        String password = userService.getPassword(userName);
        if (password ==null){
            return Msg.fail().add("info","用户名错误");
        }else if(!passWord.equals(password)) {
            return Msg.fail().add("info","密码错误");
        }else{
            return Msg.success().add("token", JWTUtil.createToken(userName));
        }
    }
    /*
      用户注册
    */
    @ResponseBody
    @PostMapping("/register")
    public Msg  register(@RequestBody User user){
        int count = userService.setUset(user);
        if (count ==1){
            return Msg.success().add("info","注册成功");

        }else return Msg.fail().add("info","注册失败");
    }

    /*
    用户修改
     */
    @RequiresRoles(value = {"学生","老师","领导"},logical = Logical.OR)
    @ResponseBody
    @PostMapping("/update")
    public Msg  update(@RequestBody User user){
        int count = userService.updateUser(user);
        if (count ==1){
            return Msg.success().add("info","修改信息成功");

        }else return Msg.fail().add("info","修改信息失败");
    }


    /*
    用户删除
     */
    @RequiresRoles(value = {"老师"})
    @ResponseBody
    @PostMapping("/del")
    public Msg delete(@RequestBody User user){
        int count = userService.deleteUser(user.getId());

        if (count ==1){
            return Msg.success().add("info","删除用户信息成功");

        }else return Msg.fail().add("info","删除用户信息失败");
    }

    /*
    获取用户信息
     */
    @RequiresRoles(value = {"学生","老师","领导"},logical = Logical.OR)
    @ResponseBody
    @PostMapping("/userinfo")
    public Msg userInfo(@RequestBody String token ){
        String username = JWTUtil.getUsername(token);
        User user = userService.selectUser(username);
        if (user != null){
            return Msg.success().add("User",user);
        }else {
            return Msg.error();
        }
    }



}
