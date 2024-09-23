package com.revature.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import com.revature.notification.event.CurrencyEvent;

@SpringBootApplication
public class NotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}
	
	@KafkaListener(topics = "notificationTopic")
	public void getCurrencyNotification(CurrencyEvent event) {
		System.err.println("Message Received: " + event);
		
	}

}
