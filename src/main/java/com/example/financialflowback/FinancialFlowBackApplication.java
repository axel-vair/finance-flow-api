package com.example.financialflowback;

import com.example.financialflowback.domain.Transaction;
import com.example.financialflowback.repository.TransactionRepository;
import com.example.financialflowback.domain.User;
import com.example.financialflowback.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class FinancialFlowBackApplication implements CommandLineRunner {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private UserRepository userRepository;


	public static void main(String[] args) {
		System.setProperty("file.encoding", "UTF-8");
		SpringApplication.run(FinancialFlowBackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		transactionRepository.deleteAll();
		transactionRepository.flush();
		Transaction t1 = new Transaction();
		t1.setTitle("Première opération");
		t1.setAmount(123.3f);
		t1.setDescription("Ma première opération est géniale youhou");
		t1.setDate(new Date());
		transactionRepository.saveAndFlush(t1);

		Transaction t2 = new Transaction();
		t2.setTitle("Deuxième opération");
		t2.setAmount(40f);
		t2.setDescription("Ma deuxième opération");
		t2.setDate(new Date());
		t2.setPlace("Marseille");
		t2.setPoint(true);
		transactionRepository.saveAndFlush(t2);

		userRepository.deleteAll();
		userRepository.flush();
		User tU= new User();
		tU.setMail("morgane@gmail.com");
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode("hello");
		tU.setPassword(encodedPassword);
		tU.setUsername("momo");
		tU.setRole("user");
		userRepository.saveAndFlush(tU);
	}

}
