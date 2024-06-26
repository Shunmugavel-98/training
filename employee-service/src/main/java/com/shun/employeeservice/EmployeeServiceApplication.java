package com.shun.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

/**
 * <p>
 * Main class for the Employee Service Application.
 * </p>
 *
 * @author Shunmugavel - created on April 09, 2024
 */
@SpringBootApplication
@EnableKafka
public class EmployeeServiceApplication {

	/**
	 * <p>
	 * Main method to run the Employee Service Application.
	 * </p>
	 *
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
