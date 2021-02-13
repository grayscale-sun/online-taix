package com.online.taix.service.impl;

import com.online.taix.dao.TaixUserDao;
import com.online.taix.dto.LoginParam;
import com.online.taix.dto.TaixResult;
import com.online.taix.dto.UserParam;
import com.online.taix.feignservice.VerifyCodeFegin;
import com.online.taix.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    VerifyCodeFegin verifyCodeFegin;

    @Autowired
    TaixUserDao taixUserDao;

    @Override
    public TaixResult getVarifyCode(String phonenum) {
        Integer identify = 1;
        return verifyCodeFegin.generate(identify,phonenum);
    }

    @Override
    public String login(LoginParam loginParam) {
        UserParam userParam = taixUserDao.findByUserName(loginParam.getUsername());
        System.out.println(userParam.toString());
        return "token";
    }

}
