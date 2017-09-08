package com.thoughtclan.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.thoughtclan.entites.*;

//@SpringBootApplication(scanBasePackages="com.thoughtclan")
@Configuration
public class DirectoryDAO {

	private static final Logger log = LoggerFactory.getLogger(DirectoryDAO.class);

	public static void main(String[] args) {
		//SpringApplication.run(DirectoryDAO.class, args);
	}


}
