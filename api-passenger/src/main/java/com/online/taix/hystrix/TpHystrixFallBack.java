package com.online.taix.hystrix;

import com.online.taix.dto.TaixResult;
import com.online.taix.feignservice.VerifyCodeFegin;
import org.springframework.stereotype.Component;

@Component
public class TpHystrixFallBack implements VerifyCodeFegin {

    @Override
    public TaixResult generate(int identify, String phoneNumber) {
        System.out.println("hystrix 请求失败！");
        return TaixResult.success("success");
    }

    @Override
    public TaixResult checkVerifyCode(int identify, String phoneNumber, String verifyCode) {
        return null;
    }

}
