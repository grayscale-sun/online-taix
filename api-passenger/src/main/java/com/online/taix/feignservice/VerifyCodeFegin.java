package com.online.taix.feignservice;

import com.online.taix.dto.TaixResult;
import com.online.taix.hystrix.TpHystrixFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "service-verification-code",fallback = TpHystrixFallBack.class)
public interface VerifyCodeFegin {

    @GetMapping("/v1/verify-code/generate/{identify}/{phoneNumber}")
    public TaixResult generate(@PathVariable("identify") int identify,
                        @PathVariable("phoneNumber") String phoneNumber);

    @PostMapping("/v1/verify-code/check-verify-code/{identify}/{phoneNumber}/{verifyCode}")
    public TaixResult checkVerifyCode(@PathVariable("identify") int identify,
                               @PathVariable("phoneNumber") String phoneNumber,
                               @PathVariable("verifyCode") String verifyCode);
}
