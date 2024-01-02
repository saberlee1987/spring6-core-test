package com.saberspringcore.test.services.impl;

import com.saberspringcore.test.model.Notifier;
import com.saberspringcore.test.services.NotificationService;
import lombok.Data;

@Data
public class NotificationServiceImpl implements NotificationService {
    private Notifier notifier;

    @Override
    public void notify(String message) {
        String styled = "[subject:Notification][content:" + message + "]";
        notifier.notify(styled);
    }
}
