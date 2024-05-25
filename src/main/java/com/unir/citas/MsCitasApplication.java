package com.unir.citas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsCitasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCitasApplication.class, args);
	}

}
