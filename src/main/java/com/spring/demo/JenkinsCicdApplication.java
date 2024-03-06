package com.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class JenkinsCicdApplication {

	@GetMapping("/greetings/{name}")
	public String greeting(@PathVariable String name){
		return "Hello "+name+"Congratulations you have completed the Jenkins CI CD";
	}

	public static void main(String[] args) {
		SpringApplication.run(JenkinsCicdApplication.class, args);
	}

}
