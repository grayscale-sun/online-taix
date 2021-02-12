package com.online.taix.dto;

import com.online.taix.serviceverify.VerifyCode;

import java.io.Serializable;

public class TaixResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int code;
    private String message;
    private T data;

    public TaixResult() {

    }

    public static TaixResult success(VerifyCode verifyCode) {
        TaixResult taixResult = new TaixResult();
        taixResult.setCode(0);
        taixResult.setMessage("获取验证码成功");
        taixResult.setData(verifyCode);
        return taixResult;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public TaixResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
