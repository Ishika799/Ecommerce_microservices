package com.categoryproductService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CategoryProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CategoryProductServiceApplication.class, args);
	}

}
