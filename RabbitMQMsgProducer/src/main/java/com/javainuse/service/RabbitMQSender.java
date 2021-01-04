package com.javainuse.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.javainuse.model.Employee;

@Service
public class RabbitMQSender {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${rabbitmq.exchange}")
	private String exchange;
	
	@Value("${rabbitmq.routingkey}")
	private String routingkey;
        
	@Value("${rabbitmq.routingkey2}")
	private String routingkey2;
        
	public void send(Employee employee) {
		amqpTemplate.convertAndSend(exchange, routingkey, employee);
		System.out.println("Message Sent For Queue 1 : " + employee);
	}
        
	public void send2(Employee employee) {
		amqpTemplate.convertAndSend(exchange, routingkey2, employee);
		System.out.println("Message Sent For Queue 2 : " + employee);
	}
}