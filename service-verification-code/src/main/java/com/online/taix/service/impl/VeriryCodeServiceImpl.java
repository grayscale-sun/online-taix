package com.online.taix.service.impl;

import com.online.taix.dto.TaixResult;
import com.online.taix.feignservice.SmsFeignService;
import com.online.taix.service.VerifyCodeService;
import com.online.taix.serviceverify.VerifyCode;
import com.online.taix.smsservice.AliNote;
import com.online.taix.smsservice.MessageData;
import com.online.taix.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@Service
public class VeriryCodeServiceImpl implements VerifyCodeService {

    @Autowired
    RedisUtils redisUtils;

    @Autowired
    SmsFeignService smsFeignService;

    @Override
    public TaixResult<VerifyCode> generate(int identify, String phoneNumber) {
        //生成验证码
        VerifyCode verifyCode = new VerifyCode(String.valueOf((int) ((Math.random() * 9 +1) * Math.pow(10,5))));
        new Thread(new Runnable() {
            @Override
            public void run() {
                //存入redis - 异步
                redisUtils.signInRedis(String.valueOf(phoneNumber) + String.valueOf(identify) , verifyCode,30, TimeUnit.SECONDS);
            }
        }).start();
        //发送验证码
        //异步调用service-sms服务
        final AliNote aliNote = new AliNote();
        final ArrayList receivers = new ArrayList();
        final HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("verifycode",verifyCode);
        final MessageData messageData = new MessageData();
        messageData.setTemplateid(1);
        messageData.setTemplatemap(hashMap);
        receivers.add(phoneNumber);
        aliNote.setReceivers(receivers);
        aliNote.setMessageData(messageData);
        new Thread(new Runnable() {
            @Override
            public void run() {
                smsFeignService.sendMessage(aliNote);
            }
        }).start();
        return TaixResult.verifySuccess(verifyCode);
    }

    @Override
    public TaixResult checkVerfiyCode(int identify, String phoneNumber,String verifyCode) {
        TaixResult taixResult = new TaixResult();
        VerifyCode valueFromRedis = (VerifyCode)redisUtils.getValueFromRedis(String.valueOf(phoneNumber) + String.valueOf(identify));
        if(valueFromRedis !=null && valueFromRedis.getVerifyCode().equals(verifyCode)){
            taixResult.setCode(0);
            taixResult.setMessage("验证码验证通过");
            return taixResult;
        }
        taixResult.setCode(1);
        taixResult.setMessage("验证码验证失败");
        return taixResult;
    }


}
