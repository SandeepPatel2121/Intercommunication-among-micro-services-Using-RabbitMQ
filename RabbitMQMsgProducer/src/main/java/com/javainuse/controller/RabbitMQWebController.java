package com.javainuse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.model.Employee;
import com.javainuse.service.RabbitMQSender;

@RestController
@RequestMapping(value = "/producer/")
public class RabbitMQWebController {

	@Autowired
	private RabbitMQSender rabbitMQSender;

	@GetMapping(value = "/1/queue")
	public String producer(@RequestParam("empName") String empName,@RequestParam("empId") String empId) {
	
	Employee emp=new Employee();
	emp.setEmpId(empId);
	emp.setEmpName(empName);
		rabbitMQSender.send(emp);

		return "Message sent to Queue 1";
	}
        
        @GetMapping(value = "/2/queue")
	public String producer2(@RequestParam("empName") String empName,@RequestParam("empId") String empId) {
	
	Employee emp=new Employee();
	emp.setEmpId(empId);
	emp.setEmpName(empName);
		rabbitMQSender.send2(emp);

		return "Message sent to Queue 2";
	}
        
}

