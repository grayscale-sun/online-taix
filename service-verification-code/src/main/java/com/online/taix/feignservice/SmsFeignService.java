package com.online.taix.feignservice;

import com.online.taix.dto.TaixResult;
import com.online.taix.smsservice.AliNote;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("service-sms")
public interface SmsFeignService {

    @PostMapping("/v1/ali/send/sms-template")
    TaixResult sendMessage(AliNote aliNote);

}
