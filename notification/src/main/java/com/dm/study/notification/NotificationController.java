package com.dm.study.notification;

import com.dm.study.appsclients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("api/v1/notification")
public class NotificationController {
    private NotificationService service;

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest rq) {
        log.info("New notification {}", rq);
        service.saveAndSend(rq);
    }
}
