package com.online.taix.serviceverify;

import java.io.Serializable;

public class VerifyCode implements Serializable {

    private static final long serialVersionUID = 10235L;


    private String verifyCode;

    public VerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
}
