package com.cnsblog.api.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.cnsblog.api.web.domain.Greeting;
import com.cnsblog.api.web.domain.HelloMessage;

@CrossOrigin
@RestController
public class GreetingController extends BaseController {

	private final Logger LOG = LoggerFactory.getLogger(GreetingController.class);

	@MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + message.getName() + "!");
    }
}
