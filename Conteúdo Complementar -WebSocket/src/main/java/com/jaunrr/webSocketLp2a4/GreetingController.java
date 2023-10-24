package com.jaunrr.webSocketLp2a4;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greet(HelloMessage message){
        return new Greeting("hello" +
                HtmlUtils.htmlEscape(message.getMessage()));
    }
}
