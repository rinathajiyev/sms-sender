package com.company.impl;

import com.company.config.*;
import com.company.inter.*;
import com.company.sms.*;
import com.google.i18n.phonenumbers.*;
import com.twilio.rest.api.v2010.account.*;
import com.twilio.type.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service("twilio")
public class TwilioSmsSender implements SmsSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwilioSmsSender.class);

    private final TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioSmsSender(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }


    @Override
    public void sendSms(SmsRequest smsRequest) {
        if(isValidPhoneNumber(smsRequest.getPhoneNumber())) {
            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
            String message = smsRequest.getMessage();
            MessageCreator creator = Message.creator(to, from, message);
            creator.create();
            LOGGER.info("Send sms {}", smsRequest);
        } else{
            System.out.println(new IllegalArgumentException("Format of the phone number is incorrect!"));
        }
    }

    private boolean isValidPhoneNumber(String phoneNumber){
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        boolean isValid = false;
        try{
            Phonenumber.PhoneNumber phoneNumberObject = phoneNumberUtil.parse(phoneNumber, "AZE");
            isValid = phoneNumberUtil.isValidNumber(phoneNumberObject);
        }catch (NumberParseException e){
            System.err.println("NumberParseException: " + e.toString());
        }

        return isValid;
    }
}
