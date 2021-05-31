package com.example.demo.todomongo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
@EnableMongoRepositories
public class TodoMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoMongoApplication.class, args);
	}

	@Bean
	public ApplicationRunner applicationRunner() {
		return args -> {
			System.out.println("Hello, World!");
		};
	}
}
