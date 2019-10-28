package it.ginopc.hello.controllers;

import java.util.Optional;
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

import it.ginopc.hello.models.User;
import it.ginopc.hello.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private Logger log = Logger.getLogger(this.getClass().getName());

	@Autowired
	private UserService service;
	
	@GetMapping
	public @ResponseBody Iterable<User> findAll(){
		return service.findAll();
	}	
	
	@PostMapping
	public ResponseEntity<User> create(@Valid @RequestBody User user){
		return ResponseEntity.ok(service.save(user));
	}
	
	@GetMapping(path="/{id}")
	public @ResponseBody Optional<User> findById(@PathVariable Long id) {
		return service.findById(id);
	}

	
	@PutMapping(path="/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @Valid @RequestBody User user){
		
		if (!service.findById(id).isPresent()) {
			log.severe("Id " + id + " is not present!");
			ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(service.save(user));
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		
		if (!service.findById(id).isPresent()) {
			log.severe("Id " + id + " is not present!");
			ResponseEntity.badRequest().build();
		}
		
		service.deleteById(id);
		
		return ResponseEntity.ok().build();
	}
}
