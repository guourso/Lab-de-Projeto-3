package com.lab.projeto3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Projeto3Application {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Projeto3Application.class);
		application.setAllowBeanDefinitionOverriding(true);
		application.run(args);
	}

}
