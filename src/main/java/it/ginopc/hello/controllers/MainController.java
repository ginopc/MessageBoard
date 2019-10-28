package it.ginopc.hello.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@GetMapping(path="/")
	public @ResponseBody String index() {
		return "Hello Data Service v. 1.0.0";
	}
}
