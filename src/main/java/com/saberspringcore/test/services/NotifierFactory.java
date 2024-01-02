package com.saberspringcore.test.services;

import com.saberspringcore.test.model.EmailNotifier;
import com.saberspringcore.test.model.Notifier;

public class NotifierFactory {
    public  Notifier getNotifier() {
        return new EmailNotifier();
    }
}
