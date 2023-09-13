package com.example.camelmicroserviceb.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqReceiverRouter extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("activemq:my-activemq-queue")
		.log("log:received-message-from-activemq");
	}

}
