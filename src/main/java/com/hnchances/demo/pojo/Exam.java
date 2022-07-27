package com.hnchances.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("exam")
public class Exam {
    //唯一标识id
    private int id;

    //考试名称
    @TableField("examName")
    private String examName;

    //状态
    @TableField("status")
    private String status;
}
