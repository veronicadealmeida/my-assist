package br.com.fiap.myassist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyAssistApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAssistApplication.class, args);
	}



}
