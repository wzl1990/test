package com.opc.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.codecentric.boot.admin.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class ApplicationConsole {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationConsole.class, args);
	}

	@RequestMapping(value = "/k8s/checkHealth")
	public String checkHealth() {
		return "ok";
	}

}
