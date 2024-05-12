package com.dm.study.notification.rabbitmq;

import com.dm.study.appsclients.notification.NotificationRequest;
import com.dm.study.notification.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationService service;

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consume(NotificationRequest rq) {
        log.info("Consumed {} from queue", rq);
        service.saveAndSend(rq);
    }

}
