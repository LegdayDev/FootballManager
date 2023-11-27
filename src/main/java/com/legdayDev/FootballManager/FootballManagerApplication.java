package com.legdayDev.FootballManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FootballManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballManagerApplication.class, args);
	}

}
