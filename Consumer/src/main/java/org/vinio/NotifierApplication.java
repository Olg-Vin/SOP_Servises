package org.vinio;


import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NotifierApplication {
    static final String queueName = "NotifierQueue";

    @Autowired
    private NotificationService notificationService;

    @Bean
    public Queue myQueue() {
        return new Queue(queueName, false);
    }

    @RabbitListener(queues = queueName)
    public void listen(String message) {
        System.out.println("Message read from " + queueName + " : " + message);
        notificationService.sendNotification(message);
    }

    public static void main(String[] args) {
        SpringApplication.run(NotifierApplication.class, args);
    }
}
