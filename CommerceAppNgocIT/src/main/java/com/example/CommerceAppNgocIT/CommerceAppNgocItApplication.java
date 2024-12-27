package com.example.CommerceAppNgocIT;

import com.example.CommerceAppNgocIT.services.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CommerceAppNgocItApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommerceAppNgocItApplication.class, args);
	}
@Bean
	CommandLineRunner init(StorageService storageService) {
		return args -> {
			storageService.init();
		};
}
}

