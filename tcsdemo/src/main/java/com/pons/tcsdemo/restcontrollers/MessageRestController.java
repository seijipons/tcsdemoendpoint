package com.pons.tcsdemo.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pons.tcsdemo.entities.Message;
import com.pons.tcsdemo.services.MessageService;



@RestController
@RequestMapping("/message")
public class MessageRestController {
	@Autowired
	MessageService messageService;
	
	@GetMapping("/getMessages/{idUser}")
	@ResponseBody
	public ResponseEntity<List<Message>> getMessagesTo(@PathVariable String idUser){
		
		List<Message> messages= messageService.getMessagesTo(idUser);
		
		if (messages.size() == 0) {
			return ResponseEntity.notFound().header("Content-Type", "application/json").build();
		} else {
			return ResponseEntity.ok(messages);
		}
		
	}
	
	@PostMapping ("/sendMessage")
	@ResponseBody
	public ResponseEntity<Message> addMessage(@RequestBody Message newMessage){
				
		if (messageService.addMessage(newMessage) < 1) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		} else {
			// TODO Get the product with ID from database
			return new ResponseEntity<>(newMessage, HttpStatus.CREATED);
		}
	}
	
}
