package com.online.taix.service.impl;

import com.online.taix.dto.TaixResult;
import com.online.taix.service.VerifyCodeService;
import com.online.taix.serviceverify.VerifyCode;
import com.online.taix.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class VeriryCodeServiceImpl implements VerifyCodeService {

    @Autowired
    RedisUtils redisUtils;

    @Override
    public TaixResult<VerifyCode> generate(int identify, String phoneNumber) {
        //生成验证码
        VerifyCode verifyCode = new VerifyCode(String.valueOf((int) (Math.random() * 1000000)));
        new Thread(new Runnable() {
            @Override
            public void run() {
                //存入redis - 异步
                redisUtils.signInRedis(String.valueOf(phoneNumber) + String.valueOf(identify) , verifyCode,30, TimeUnit.SECONDS);
            }
        }).start();
        return TaixResult.success(verifyCode);
    }

    @Override
    public TaixResult checkVerfiyCode(int identify, String phoneNumber,String verifyCode) {
        TaixResult taixResult = new TaixResult();
        VerifyCode valueFromRedis = (VerifyCode)redisUtils.getValueFromRedis(String.valueOf(phoneNumber) + String.valueOf(identify));
        if(valueFromRedis.getVerifyCode().equals(verifyCode)){
            taixResult.setCode(0);
            taixResult.setMessage("验证码验证通过");
            return taixResult;
        }
        taixResult.setCode(1);
        taixResult.setMessage("验证码验证失败");
        return taixResult;
    }


}
