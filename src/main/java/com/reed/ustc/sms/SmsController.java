package com.reed.ustc.sms;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by reedfan on 2019/9/28 0028
 */
@RestController
public class SmsController {

    @GetMapping("/testSms")
    public String testSms(){
        String res = "";
        try {
             res = SMSByHttpClient.sendSms();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }


}
