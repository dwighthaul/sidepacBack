package com.hubertpa.sidepa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hubertpa.sidepa.controller.initialize.DataInitializer;

@SpringBootApplication
public class SidepaApplication implements CommandLineRunner {

	@Autowired
	DataInitializer dataInitializer;

	public static void main(String[] args) {
		SpringApplication.run(SidepaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dataInitializer.createData();
	}

}
