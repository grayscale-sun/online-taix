package com.online.taix.controller;

import com.online.taix.dto.LoginParam;
import com.online.taix.dto.TaixResult;
import com.online.taix.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/admin")
public class TaixAdminController {

    @Autowired
    LoginService loginService;

    @PostMapping("/get-varify-code")
    public TaixResult getVarifyCode(@RequestParam String phonenum){
        return loginService.getVarifyCode(phonenum);
    }

    @PostMapping("/login")
    public TaixResult login(@RequestBody LoginParam loginParam){
        return loginService.login(loginParam);
    }

    @Value("${server.port}")
    private String port;

    @GetMapping("/test")
    public String test(){
        return port;
    }

}
