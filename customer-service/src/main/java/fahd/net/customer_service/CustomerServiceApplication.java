package fahd.net.customer_service;

import fahd.net.customer_service.entities.Customer;
import fahd.net.customer_service.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {

			List<Customer> customerList = List.of(
					Customer.builder()
							.firstName("Fahd")
							.lastName("Ellahia")
							.email("fahdellahia@gmail.com")
							.build(),
					Customer.builder()
							.firstName("Hassan")
							.lastName("Hassona")
							.email("hassanhassona@gmail.com")
							.build(),
					Customer.builder()
							.firstName("Imane")
							.lastName("Amouna")
							.email("imaneamouna@gmail.com")
							.build()
			);

			customerRepository.saveAll(customerList);

		};
	}
}
