package com.dm.study.appsclients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "notification",
        url = "http://notification:8082"
//        url = "${clients.notification.url}" //prop dont work
)
public interface NotificationClient {
    @PostMapping("api/v1/notification")
    void sendNotification(@RequestBody NotificationRequest rq);
}
