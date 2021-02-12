package com.online.taix.controller;

import com.online.taix.dto.TaixResult;
import com.online.taix.service.VerifyCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/verify-code")
public class VerificationController {

    @Autowired
    VerifyCodeService veriryCodeService;

    /**
     *@description : 生成验证码
     *@Author : Sun
     *@date :
     */
    @GetMapping("/generate/{identify}/{phoneNumber}")
    public TaixResult generate(@PathVariable("identify") int identify,
                               @PathVariable("phoneNumber") int phoneNumber){
        return veriryCodeService.generate(identify,phoneNumber);
    }

    /**
     *@description : 校验验证码
     *@Author : Sun
     *@date :
     */
    @PostMapping("/check-verify-code/{identify}/{phoneNumber}/{verifyCode}")
    public TaixResult checkVerifyCode(@PathVariable("identify") int identify,
                                      @PathVariable("phoneNumber") int phoneNumber,
                                      @PathVariable("verifyCode") String verifyCode){
        return veriryCodeService.checkVerfiyCode(identify,phoneNumber,verifyCode);
    }
}
