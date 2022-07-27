package com.hnchances.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("course")
public class Course {
    //唯一标识id
    private int id;

    //课程名称
    @TableField("courseName")
    private String courseName;

    //状态
    @TableField("status")
    private String status;
}
