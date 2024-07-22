package com.min.edu;

import org.springframework.boot.SpringApplication;

public class TestBookmarkApiApplication {

	public static void main(String[] args) {
		SpringApplication.from(BookmarkApiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
