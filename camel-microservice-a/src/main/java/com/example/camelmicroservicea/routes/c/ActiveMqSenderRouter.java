package com.example.camelmicroservicea.routes.c;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqSenderRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("timer:active-mq-timer?period=10000")
		.transform().constant("ActiveMq message")
		.log("${body}")
		.to("activemq:my-activemq-queue");
	}

}
