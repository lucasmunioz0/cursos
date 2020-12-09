package com.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.datajpa.services.UploadFileServices;

@SpringBootApplication
public class SpringBootDataJpaApplication implements CommandLineRunner{
	@Autowired
	private UploadFileServices fileServices;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		fileServices.deleteAll();
		fileServices.init();
		
	}

}
