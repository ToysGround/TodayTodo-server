package com.toysground.todaytodo.dto;

import lombok.Data;

@Data
public class ResultEntity<T> {

    private String code = "200";
    private String msg = "SUCCESS";
    private T data;


    public ResultEntity(T data) {
        this.data = data;
    }

    public ResultEntity(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
