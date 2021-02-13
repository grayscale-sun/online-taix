package com.online.taix.service.impl;

import com.online.taix.dao.TaixUserDao;
import com.online.taix.dto.LoginParam;
import com.online.taix.dto.TaixResult;
import com.online.taix.dto.UserParam;
import com.online.taix.feignservice.VerifyCodeFegin;
import com.online.taix.service.LoginService;
import com.online.taix.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    public static final Integer identify = 1;

    @Autowired
    VerifyCodeFegin verifyCodeFegin;

    @Autowired
    TaixUserDao taixUserDao;

    @Autowired
    private TokenUtil tokenUtil;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public TaixResult getVarifyCode(String phonenum) {
        return verifyCodeFegin.generate(identify,phonenum);
    }

    @Override
    public TaixResult login(LoginParam loginParam) {
        /*校验验证码*/
        if(verifyCodeFegin.checkVerifyCode(identify,loginParam.getUsername(),loginParam.getVarifycode()).getCode()==0){
            UserParam userParam = taixUserDao.findByUserName(loginParam.getUsername());
            if(userParam != null && userParam.getPassword().equals(loginParam.getPassword())){
                /*生成token*/
                String token = tokenUtil.generateToken(userParam.getUsername());
                Map<String, String> tokenMap = new HashMap<>();
                tokenMap.put("token", token);
                tokenMap.put("tokenHead", tokenHead);
                return TaixResult.success("登录成功",tokenMap);
            }
            return TaixResult.failure("用户名或者密码错误");
        }else {
            return TaixResult.failure("验证码错误");
        }
    }

}
