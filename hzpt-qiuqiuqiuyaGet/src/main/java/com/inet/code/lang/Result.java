package com.inet.code.lang;

import lombok.Data;

import java.io.Serializable;

/**
 * author: YRS
 * description:返回值
 * create time: 15:05 2021/5/11
 */

@Data
public class Result implements Serializable {

    /**
     * 状态信息
     */
    private String code;
    /**
     * 携带信息
     */
    private String msg;
    /**
     * 携带数据
     */
    private Object data;

    /**
     *
     * @param data or mess or null
     * @return Result
     */
    public static Result success(Object data) {
        Result result200 = new Result();
        result200.setCode("200");
        result200.setData(data);
        result200.setMsg("操作成功");
        return result200;
    }
    public static Result fail(String mess) {
        Result result500 = new Result();
        result500.setCode("500");
        result500.setData(null);
        result500.setMsg("错误：" + mess);
        return result500;
    }
    public static Result out() {
        Result result404 = new Result();
        result404.setCode("404");
        result404.setData(null);
        result404.setMsg("超时");
        return result404;
    }
}


