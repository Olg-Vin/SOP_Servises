package org.vinio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationService{
    @Autowired
    private SimpMessagingTemplate template;
    public void sendNotification(String message) {
        System.out.println("Получено сообщение\n" + message);
        template.convertAndSend("/topic/notifications", message);
    }
}

