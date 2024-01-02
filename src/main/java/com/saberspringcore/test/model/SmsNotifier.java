package com.saberspringcore.test.model;

public class SmsNotifier implements Notifier {
    @Override
    public void notify(String message) {
        System.out.println("sms is sending with message ===> "+message);
    }
}
