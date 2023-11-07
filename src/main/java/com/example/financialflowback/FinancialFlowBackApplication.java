package com.example.financialflowback;

import com.example.financialflowback.domain.Boat;
import com.example.financialflowback.repository.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinancialFlowBackApplication implements CommandLineRunner {

	@Autowired
	private BoatRepository boatRepository;

	public static void main(String[] args) {
		SpringApplication.run(FinancialFlowBackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Boat b1 = new Boat();
		b1.setName("test");
		boatRepository.saveAndFlush(b1); // Use saveAndFlush to save the entity to the database.
	}

}
