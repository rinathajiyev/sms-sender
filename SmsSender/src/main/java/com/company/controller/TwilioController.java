package com.company.controller;

import com.company.service.*;
import com.company.sms.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/sms")
public class TwilioController {

    @Autowired
    private Service service;

    @PostMapping
    public void sendSms(@RequestBody SmsRequest smsRequest){
        service.sendSms(smsRequest);
    }
}
