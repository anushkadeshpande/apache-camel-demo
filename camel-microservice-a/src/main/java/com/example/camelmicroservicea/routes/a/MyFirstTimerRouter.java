package com.example.camelmicroservicea.routes.a;

import java.time.LocalDateTime;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyFirstTimerRouter extends RouteBuilder{
	
	@Autowired
	private GetCurrentTimeBean getCurrentTimeBean;
	
	@Autowired
	private SimpleLoggingProcessingComponent simpleLoggingComponent;

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		// timer
		from("timer:first-timer")
		.log("${body}")
		.transform().constant("My constant message")
		.log("${body}")
//		.transform().constant("Time now is " + LocalDateTime.now())
		.bean("getCurrentTimeBean", "getCurrentTime")	// transformation
		.log("${body}")
		.bean(simpleLoggingComponent)	// processing
		.log("${body}")
		.to("log:first-timer");
		// transformation
		
		// log
		
	}

}


@Component
class GetCurrentTimeBean {
	public String getCurrentTime() {
		return "Time now is" + LocalDateTime.now();
	}
}

@Component
class SimpleLoggingProcessingComponent {
	private Logger logger = LoggerFactory.getLogger(SimpleLoggingProcessingComponent.class);
	
	public void process(String message) {
		logger.info("SimpleLoggingProcessingComponent {}", message);
	}
}