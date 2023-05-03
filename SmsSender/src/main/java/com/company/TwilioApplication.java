package com.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.*;

@SpringBootApplication
@EnableWebMvc
public class TwilioApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwilioApplication.class, args);
	}

}
