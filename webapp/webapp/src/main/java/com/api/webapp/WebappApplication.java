package com.api.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import com.api.webapp.CustomPropreties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.Data;
@Data
@SpringBootApplication

public class WebappApplication implements CommandLineRunner {
	
	@Autowired

	private CustomPropreties props;
	
	
	public static void main(String[] args) {
		SpringApplication.run(WebappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
        System.out.println(props.getApiUrl());
	}

}
