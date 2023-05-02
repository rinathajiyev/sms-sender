package com.company.service;

import com.company.impl.*;
import com.company.inter.*;
import com.company.sms.*;
import org.springframework.beans.factory.annotation.*;

@org.springframework.stereotype.Service
public class Service {

    private SmsSender smsSender;

    @Autowired
    public Service(@Qualifier("twilio") TwilioSmsSender smsSender) {
        this.smsSender = smsSender;
    }

    public void sendSms(SmsRequest smsRequest){
        smsSender.sendSms(smsRequest);
    }
}
