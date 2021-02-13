package com.online.taix.controller;

import com.online.taix.dto.TaixResult;
import com.online.taix.service.SendMessageService;
import com.online.taix.smsservice.AliNote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/ali")
public class ShortMessageController {

    @Autowired
    SendMessageService sendMessageService;

    @PostMapping("/send/sms-template")
    public TaixResult sendShortMessage(@RequestBody AliNote aliNote){
        return sendMessageService.send(aliNote);
    }
}
