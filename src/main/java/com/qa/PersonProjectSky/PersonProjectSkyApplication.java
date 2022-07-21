package com.qa.PersonProjectSky;

import com.qa.PersonProjectSky.entities.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PersonProjectSkyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonProjectSkyApplication.class, args);
	}

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World!";
	}

	@GetMapping("/bye")
	public String sayBye(@RequestParam(name = "name", defaultValue = "dont care") String name) {
		return "Bye bye " + name;
	}

}
