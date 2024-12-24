package org.vinio.conf;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Конфигурация для двух очередей
 * gRPC queue - очередь, которую слушает grpc сервис
 * Audit queue - чередь, котрую слушает audit (нет реализации)
 * */
@Configuration
public class RMQConfig {
    static final String EXCHANGE_NAME = "defaultExchange";
    public enum QueueNames {
        GRPC_QUEUE("GRPCQueue"),
        AUDIT_QUEUE("AuditQueue"),
        NOTIFIER_QUEUE("NotifierQueue");
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
        return new DirectExchange(EXCHANGE_NAME, false, false);
    }

    // Создание очереди с указанным именем
    @Bean
    public Queue grpcQueue() {
        return createQueue(QueueNames.GRPC_QUEUE);
    }

    @Bean
    public Queue auditQueue() {
        return createQueue(QueueNames.AUDIT_QUEUE);
    }

    @Bean
    public Queue notifierQueue() {
        return createQueue(QueueNames.NOTIFIER_QUEUE);
    }

    private Queue createQueue(QueueNames queueName) {
        return new Queue(queueName.getName(), false);
    }

    // Создание привязок для каждой очереди
    @Bean
    public Binding bindingGrpcQueue(Queue grpcQueue, Exchange exchange) {
        return createBinding(grpcQueue, exchange, "grpc.key");
    }

    @Bean
    public Binding bindingAuditQueue(Queue auditQueue, Exchange exchange) {
        return createBinding(auditQueue, exchange, "audit.key");
    }

    @Bean
    public Binding bindingNotifierQueue(Queue notifierQueue, Exchange exchange) {
        return createBinding(notifierQueue, exchange, "notifier.key");
    }

    private Binding createBinding(Queue queue, Exchange exchange, String routingKey) {
        return BindingBuilder.bind(queue).to(exchange).with(routingKey).noargs();
    }
}
