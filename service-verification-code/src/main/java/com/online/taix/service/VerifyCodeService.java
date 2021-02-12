package com.online.taix.service;

import com.online.taix.dto.TaixResult;
import com.online.taix.serviceverify.VerifyCode;

public interface VerifyCodeService {
    TaixResult<VerifyCode> generate(int identify, int phoneNumber);
    TaixResult checkVerfiyCode(int identify, int phoneNumber,String verifyCode);
}
