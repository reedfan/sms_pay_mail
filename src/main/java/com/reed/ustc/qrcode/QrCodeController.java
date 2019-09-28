package com.reed.ustc.qrcode;

import com.reed.ustc.sms.SMSByHttpClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

/**
 * created by reedfan on 2019/9/28 0028
 */
@RestController
public class QrCodeController {

    @GetMapping("/tes")
    public String testSms(){
        QrCodeUtils.createCode();
        QrCodeUtils.parseCode(new File("D:/kankan/TDC-test.png"));
        return "success";
    }


}
