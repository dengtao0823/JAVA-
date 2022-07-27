package com.hnchances.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class User {
    //唯一标识id
    private int id;
    //用户名
    @TableField("userName")
    private String userName;

    //密码
    @TableField("passWord")
    private String passWord;

    //电话号码
    @TableField("phone")
    private String phone;

    //真实姓名
    @TableField("trueName")
    private String trueName;

    //职务（'0-学生，1-老师，2-领导或管理（可看所有班级））
    @TableField("identity")
    private int identity;

    //班级关联id
    @TableField("classID")
    private int classID;

    //课程id
    @TableField("courseID")
    private int courseID;

    //学生id
    @TableField("studentID")
    private int studentID;

    //注册日期
    @TableField("creatDateTime")
    private Date creatDateTime;

    //修改日期
    @TableField("updateDateTime")
    private Date updateDateTime;

    //最后登录时间
    @TableField("lastLoginDateTime")
    private Date lastLoginDateTime;

    //登录ip地址
    @TableField("loginIP")
    private String loginIP;

    //修改人id
    @TableField("updateByID")
    private int updateByID;

    //状态
    @TableField("status")
    private String status;

    //审核状态
    @TableField("verify")
    private String verify;

}
