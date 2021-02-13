package com.online.taix.service;

import com.online.taix.dto.TaixResult;
import com.online.taix.serviceverify.VerifyCode;

public interface VerifyCodeService {
    TaixResult<VerifyCode> generate(int identify, String phoneNumber);
    TaixResult checkVerfiyCode(int identify, String phoneNumber,String verifyCode);
}
