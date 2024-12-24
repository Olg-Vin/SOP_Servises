package org.vinio.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Конфигурация для двух очередей
 * Main queue - очередь, которую слушает main сервис
 * Notification queue - чередь, котрую слушает notifier
 * */
@Configuration
public class RMQConfig {
    //    передавать названия очередей через переменные окружения
    static final String EXCHANGE_NAME = "defaultExchange";
    public enum QueueNames {
        MAIN_QUEUE("MainQueue");
//        NOTIFICATION_QUEUE("NotificationQueue");
        private final String name;
        QueueNames(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }

    @Bean
    public Exchange exchange() {
        return new TopicExchange(EXCHANGE_NAME, false, false);
    }

    // Создание очереди с указанным именем
    @Bean
    public Queue mainQueue() {
        return createQueue(QueueNames.MAIN_QUEUE);
    }

//    @Bean
//    public Queue notificationQueue() {
//        return createQueue(QueueNames.NOTIFICATION_QUEUE);
//    }

    private Queue createQueue(QueueNames queueName) {
        return new Queue(queueName.getName(), false);
    }

    // Создание привязок для каждой очереди
    @Bean
    public Binding bindingMainQueue(Queue mainQueue, Exchange exchange) {
        return createBinding(mainQueue, exchange, "main.key");
    }

//    @Bean
//    public Binding bindingNotificationQueue(Queue notificationQueue, Exchange exchange) {
//        return createBinding(notificationQueue, exchange, "notification.key");
//    }

    private Binding createBinding(Queue queue, Exchange exchange, String routingKey) {
        return BindingBuilder.bind(queue).to(exchange).with(routingKey).noargs();
    }
}
