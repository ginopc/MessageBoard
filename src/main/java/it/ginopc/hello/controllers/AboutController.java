package it.ginopc.hello.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.ginopc.hello.models.About;
import it.ginopc.hello.services.AboutService;

@RestController
public class AboutController {
	
	@Autowired
	private AboutService service;

	@GetMapping(path="/about")
	public @ResponseBody About get() {
		return service.findById(1L).orElseThrow(() -> new RuntimeException("About item not found!"));
	}
}
