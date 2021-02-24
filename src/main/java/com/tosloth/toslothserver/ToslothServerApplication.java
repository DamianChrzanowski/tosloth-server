package com.tosloth.toslothserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToslothServerApplication implements CommandLineRunner {

	@Autowired
	UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ToslothServerApplication.class, args);
	}

	@Override
	public void run(String... args) {
		repository.save(new User("Foczka", "Obiboczka", "foczkaobiboczka@tosloth.com"));
		repository.save(new User("Dziobak", "Dziobakson", "dziobakdziobakson@tosloth.com"));
	}
}
