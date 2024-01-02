package com.saberspringcore.test.model;

public class EmailNotifier implements Notifier {
    @Override
    public void notify(String message) {
        System.out.println("email is sending with message ===> "+message);
    }
}
