package com.goddmnash.MumbleApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MumbleAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MumbleAppApplication.class, args);
	}

}
