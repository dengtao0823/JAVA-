package com.hnchances.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("grades")
public class Grades {
    //唯一标识id
    private int id;

    //课程关联id
    @TableField("courseID")
    private int courseID;

    //考试关联id
    @TableField("examID")
    private int examID;

    //班级关联id
    @TableField("classID")
    private int classID;

    //成绩
    @TableField("grades")
    private float grades;

    //状态
    @TableField("status")
    private String status;
}
