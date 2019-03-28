package com.logy.utils;

/**
 * 数据响应类
 * @param <T> 泛型
 */
public class DataResponse<T> {
    private int id;
    private int code;
    private int pageCount;
    private String message;
    private T data;

    /**
     * 无参构造函数
     */
    public DataResponse() {
        this.code = 200;
        this.message = "success";
    }

    /**
     * 有参构造函数
     * @param code  响应码
     * @param message   消息
     */
    public DataResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
