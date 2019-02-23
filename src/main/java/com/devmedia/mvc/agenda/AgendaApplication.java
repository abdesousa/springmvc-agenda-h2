package com.devmedia.mvc.agenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "com.devmedia.mvc.agenda.entity" })
@EnableJpaRepositories(basePackages = { "com.devmedia.mvc.agenda.repository" })
@ComponentScan(basePackages = { "com.devmedia.mvc.agenda.controller" })
public class AgendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaApplication.class, args);
	}

}
