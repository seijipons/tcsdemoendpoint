package com.pons.tcsdemo.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping()
	@ResponseBody
	public ResponseEntity<List<Message>> getMessagesTo(@RequestParam String id){
		
		List<Message> messages= messageService.getMessagesTo(id);
		
		if (messages.size() == 0) {
			return ResponseEntity.notFound().header("Content-Type", "application/json").build();
		} else {
			return ResponseEntity.ok(messages);
		}
		
	}
	
	@PostMapping(value = "", produces = "application/json; charset=UTF-8")
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
