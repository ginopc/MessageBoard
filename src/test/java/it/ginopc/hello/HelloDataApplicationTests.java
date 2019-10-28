package it.ginopc.hello;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.ginopc.hello.controllers.MainController;

@SpringBootTest
class HelloDataApplicationTests {
	
	@Autowired
	private MainController controller;

	@Test
	void contextLoads() {
		
		//given
		//when
		//then
		assertNotNull(controller);
	}

}
