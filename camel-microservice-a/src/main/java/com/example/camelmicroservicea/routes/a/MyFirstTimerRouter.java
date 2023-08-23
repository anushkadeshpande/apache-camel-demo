package com.example.camelmicroservicea.routes.a;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyFirstTimerRouter extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		// timer
		from("timer:first-timer")
		.transform().constant("My constant message")
		.to("log:first-timer");
		// transformation
		
		// log
		
	}

}
