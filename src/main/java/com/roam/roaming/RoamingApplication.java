package com.roam.roaming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@SpringBootApplication
@EntityScan(basePackageClasses = {RoamingApplication.class})
public class RoamingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoamingApplication.class, args);
	}

}
