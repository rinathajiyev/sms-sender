package com.company.inter;

import com.company.sms.*;

public interface SmsSender {

    void sendSms(SmsRequest smsRequest);
}
