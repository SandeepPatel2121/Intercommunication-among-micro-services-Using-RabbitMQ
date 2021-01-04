package com.javainuse.config;

import com.javainuse.model.Employee;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author bypt-dev-laptop-9
 */
@Component
public class RabbitMQConsumer {

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void recievedMessage(Employee employee) {
        System.out.println("Recieved Message From RabbitMQ Queue 1 : " + employee);
    }
    
    @RabbitListener(queues = "${rabbitmq.queue2}")
    public void recievedMessage2(Employee employee) {
        System.out.println("Recieved Message From RabbitMQ Queue 2 : " + employee);
    }
    
}
