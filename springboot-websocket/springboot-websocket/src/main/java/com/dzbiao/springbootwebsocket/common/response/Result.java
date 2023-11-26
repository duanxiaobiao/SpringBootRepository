package com.dzbiao.springbootwebsocket.common.response;

/**
 * @Author: DZBiao
 * @Date : 2021/9/19
 * @Description : 描述：
 **/

/**
 * REST接口封装统一返回数据工具类
 */
public class Result {

    /**
     * 响应状态码
     */
    private Integer code;
    /**
     * 响应成功与否
     */
    private boolean success;
    /**
     * 响应消息
     */
    private String msg;
    /**
     * 响应数据
     */
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Result() {
    }

    public Result(Integer code, boolean success, String msg) {
        this.code = code;
        this.success = success;
        this.msg = msg;
    }

    public Result(Integer code, boolean success, String msg, Object data) {
        this.code = code;
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 成功 返回默认成功信息
     *
     * @return
     */
    public static Result SUCCESS() {
        return new Result(200, true, "操作成功", null);
    }

    /**
     * 成功 返回（data数据）成功信息
     *
     * @param data
     * @return
     */
    public static Result SUCCESS(Object data) {
        return new Result(200, true, "操作成功", data);
    }

    /**
     * 成功 返回自定义（消息、data数据）成功信息
     *
     * @param msg
     * @param data
     * @return
     */
    public static Result SUCCESS(String msg, Object data) {
        return new Result(200, true, msg, data);
    }

    /**
     * 失败 返回默认失败信息
     *
     * @return
     */
    public static Result ERROR() {
        return new Result(-1, false, "操作失败", null);
    }

    /**
     * 失败 返回自定义（消息）失败信息
     *
     * @param msg
     * @return
     */
    public static Result ERROR(String msg) {
        return new Result(-1, false, msg, null);
    }

    /**
     * 失败 返回自定义（消息、状态码）失败信息
     *
     * @param code
     * @param msg
     * @return
     */
    public static Result ERROR(Integer code, String msg) {
        return new Result(code, false, msg, null);
    }

}
