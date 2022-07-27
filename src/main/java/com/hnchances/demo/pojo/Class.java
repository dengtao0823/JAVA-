package com.hnchances.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("class")
public class Class {
    //唯一标识id
    private int id;
    //班级名称
    @TableField("className")
    private String className;

    //状态
    @TableField("status")
    private Integer status;
}
