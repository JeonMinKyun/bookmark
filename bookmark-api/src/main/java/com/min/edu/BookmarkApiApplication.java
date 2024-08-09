package com.min.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication
public class BookmarkApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmarkApiApplication.class, args);
	}

}
