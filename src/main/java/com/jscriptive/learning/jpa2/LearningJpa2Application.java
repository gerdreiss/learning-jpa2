package com.jscriptive.learning.jpa2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
@EnableJpaAuditing
public class LearningJpa2Application {

	public static void main(String[] args) {
		SpringApplication.run(LearningJpa2Application.class, args);
	}
}
