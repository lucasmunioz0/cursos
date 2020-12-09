package com.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.datajpa.services.UploadFileServices;

@SpringBootApplication
public class SpringBootDataJpaApplication implements CommandLineRunner{
	@Autowired
	private UploadFileServices fileServices;
	@Autowired
	private PasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		fileServices.deleteAll();
		fileServices.init();
		
		String password = "12345";
		for( int i = 0; i < 3; i++) {
			String passw = encoder.encode(password);
			System.out.println(passw);
		}
	}

}
