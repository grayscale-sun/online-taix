package com.online.taix.service;

import com.online.taix.dto.LoginParam;
import com.online.taix.dto.TaixResult;

public interface LoginService {
    TaixResult getVarifyCode(String phonenum);

    String login(LoginParam loginParam);
}
