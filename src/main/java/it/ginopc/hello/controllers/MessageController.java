package it.ginopc.hello.controllers;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.ginopc.hello.models.Message;
import it.ginopc.hello.services.MessageService;

@RestController
@RequestMapping(path="/messages")
public class MessageController {
	
	private Logger log = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private MessageService service;

	@GetMapping
	public @ResponseBody Iterable<Message> findAll(){
		log.info("User.findAll");
		return service.findAll();
	}
	
	@GetMapping(path="/{id}")
	public @ResponseBody Optional<Message> findById(@PathVariable Long id){
		log.log(Level.INFO, "User.findById({0})", id);
		return service.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<Message> create(@Valid @RequestBody Message message) {
		log.info("User.create");
		return ResponseEntity.ok(service.save(message));
	}
	
	@PutMapping(path="/{id}")
	public ResponseEntity<Message> update(@PathVariable Long id, @Valid @RequestBody Message message){
		log.info("User.update");
		if (!service.findById(id).isPresent()) {
			log.log(Level.SEVERE, "Id {0} is not present!", id);
			ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(service.save(message));
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Message> delete(@PathVariable Long id) {
		log.log(Level.INFO, "User.delete({0})", id);
		if (!service.findById(id).isPresent()) {
			log.log(Level.SEVERE, "Id {0} is not present!", id);
			ResponseEntity.badRequest().build();
		}
		
		service.deleteById(id);
		
		return ResponseEntity.ok().build();
	}
}
