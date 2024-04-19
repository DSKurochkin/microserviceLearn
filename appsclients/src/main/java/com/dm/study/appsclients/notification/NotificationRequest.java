package com.dm.study.appsclients.notification;

import java.io.Serializable;
import java.time.LocalDateTime;


public record NotificationRequest(
        Integer toCustomerId,
        String toCustomerEmail,
        String message,
        String sender,
        LocalDateTime sentAt
) implements Serializable {
}

