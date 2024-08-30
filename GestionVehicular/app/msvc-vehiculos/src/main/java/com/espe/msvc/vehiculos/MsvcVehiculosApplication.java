package com.espe.msvc.vehiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsvcVehiculosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcVehiculosApplication.class, args);
	}

}
