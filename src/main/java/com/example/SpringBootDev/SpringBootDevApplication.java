package com.example.SpringBootDev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDevApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDevApplication.class, args);
	}

	// @Bean
	// public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
	// 	return runner -> {
	// 	};
	// }
}
