package com.dm.study.notification;

import com.dm.study.appsclients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationService {
    private final NotificationRepository repository;

    public void saveAndSend(NotificationRequest rq) {
        repository.save(
                Notification.builder()
                        .toCustomerId(rq.toCustomerId())
                        .toCustomerEmail(rq.toCustomerEmail())
                        .message(rq.message())
                        .sender(rq.sender())
                        .sentAt(rq.sentAt())
                        .build()
        );

    }
}
