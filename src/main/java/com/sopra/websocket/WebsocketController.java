package com.sopra.websocket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebsocketController {
	
	@RequestMapping("/websocket")
	public String websocket(){
		return "websocket/page";
	}
}
