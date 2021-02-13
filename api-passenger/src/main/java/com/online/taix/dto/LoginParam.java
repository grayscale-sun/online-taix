package com.online.taix.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


public class LoginParam implements Serializable {

    @NotEmpty(message = "用户名不能为空")
    private String username;
    @NotEmpty(message = "密码不能为空")
    private String password;
    @Email(message = "邮箱格式不合法")
    private String email;
    @NotEmpty(message = "验证码不能为空")
    private String varifycode;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVarifycode() {
        return varifycode;
    }

    public void setVarifycode(String varifycode) {
        this.varifycode = varifycode;
    }
}
