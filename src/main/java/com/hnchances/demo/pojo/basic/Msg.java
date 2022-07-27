package com.hnchances.demo.pojo.basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @description  用于返回前端json数据的工具类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Msg {

    // 状态码
    private int code;
    // 提示信息
    private String message;

    // 封装有效数据
    private Map<String, Object> data = new HashMap<String, Object>();

    public static Msg success() {
        Msg result = new Msg();
        result.setCode(200);
        result.setMessage("成功");
        return result;
    }

    public static Msg fail() {
        Msg result = new Msg();
        result.setCode(400);
        result.setMessage("业务异常");
        return result;
    }
    public static Msg noPermission() {
        Msg result = new Msg();
        result.setCode(401);
        result.setMessage("no permission");
        return result;
    }

    public static Msg error() {
        Msg result = new Msg();
        result.setCode(500);
        result.setMessage("接口异常");
        return result;
    }

    public static Msg code(int code){
        Msg result = new Msg();
        result.setCode(code);
        result.setMessage("exception");
        return result;
    }

    public Msg add(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

}
