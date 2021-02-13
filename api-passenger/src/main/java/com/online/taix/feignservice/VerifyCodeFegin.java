package com.online.taix.feignservice;

import com.online.taix.dto.TaixResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("service-verification-code")
@RequestMapping("/v1/verify-code")
public interface VerifyCodeFegin {

    @GetMapping("/generate/{identify}/{phoneNumber}")
    TaixResult generate(@PathVariable("identify") int identify,
                        @PathVariable("phoneNumber") String phoneNumber);

    @PostMapping("/check-verify-code/{identify}/{phoneNumber}/{verifyCode}")
    TaixResult checkVerifyCode(@PathVariable("identify") int identify,
                               @PathVariable("phoneNumber") String phoneNumber,
                               @PathVariable("verifyCode") String verifyCode);
}
