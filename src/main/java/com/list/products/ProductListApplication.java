package com.list.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class ProductListApplication {
	Dotenv dotenv = Dotenv.load();

	public static void main(String[] args) {
		SpringApplication.run(ProductListApplication.class, args);
	}

}
