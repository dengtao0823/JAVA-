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
@TableName("student")
public class Student {
    //唯一标识id
    private int id;

    //学生姓名
    @TableField("name")
    private String name;

    //出生年月日
    @TableField("birthday")
    private Date birthday;

    //身份证号码
    @TableField("idCard")
    private int idCard;

    //班级id
    @TableField("classID")
    private int classID;

    //状态
    @TableField("status")
    private String status;
}
