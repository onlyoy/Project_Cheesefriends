package mul.cam.a.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import mul.cam.a.chatbot.Chatbot;
import mul.cam.a.chatbot.PapagoTranslator;

@RestController
public class ChatbotController {
	
	@PostMapping(value = "chatBot")
	public String chatBot(String msg) {
		//System.out.println("NaverCloudController chatBot " +  new Date());
		
		String json = Chatbot.chatBot(msg);
		return json;
	}
	
	@CrossOrigin(origins="http://localhost:3000")	
	@PostMapping(value = "papago")
	public String papago(String msg) {
		
	//	System.out.println(msg + "+++~~~~~~~~~~~");
		
		System.out.println("NaverCloudController papago " +  new Date());
		String json = PapagoTranslator.papago(msg);
		
		return json;
	}
}