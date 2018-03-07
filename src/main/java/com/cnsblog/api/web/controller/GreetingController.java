package com.cnsblog.api.web.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@Slf4j
@RestController
public class GreetingController extends BaseController {

	@SendTo("/global-message/tick")
    @MessageMapping("/from-client")
	public String fromClient(String content) throws Exception {
        log.info("Message from client: {}", content);
        Thread.sleep(1000);
        return content;
    }
}
