package com.example.financialflowback;

import com.example.financialflowback.domain.Category;
import com.example.financialflowback.domain.Subcategory;
import com.example.financialflowback.domain.Transaction;
import com.example.financialflowback.repository.CategoryRepository;
import com.example.financialflowback.repository.SubcategoryRepository;
import com.example.financialflowback.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Date;

@SpringBootApplication
public class FinancialFlowBackApplication implements CommandLineRunner {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired SubcategoryRepository subcategoryRepository;

	public static void main(String[] args) {
		System.setProperty("file.encoding", "UTF-8");
		SpringApplication.run(FinancialFlowBackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		transactionRepository.deleteAll();
		transactionRepository.flush();
		categoryRepository.deleteAll();
		categoryRepository.flush();
		subcategoryRepository.deleteAll();
		subcategoryRepository.flush();

		Category c1 = new Category();
		c1.setName("Débit");
		categoryRepository.saveAndFlush(c1);
		Category c2 = new Category();
		c2.setName("Crédit");
		categoryRepository.saveAndFlush(c2);

		Subcategory s1 = new Subcategory();
		s1.setName("Loyer");
		subcategoryRepository.saveAndFlush(s1);

		Subcategory s2 = new Subcategory();
		s2.setName("Travail");
		subcategoryRepository.saveAndFlush(s2);

		Subcategory s3 = new Subcategory();
		s3.setName("Loisir");
		subcategoryRepository.saveAndFlush(s3);

		Subcategory s4 = new Subcategory();
		s4.setName("Autre");
		subcategoryRepository.saveAndFlush(s4);

		Transaction t1 = new Transaction();
		t1.setTitle("Première opération");
		t1.setAmount(123.3f);
		t1.setDescription("Ma première opération est géniale youhou");
		t1.setDate(new Date());
		t1.setCategory(c1);
		t1.setSubcategory(s1);

		transactionRepository.saveAndFlush(t1);

		Transaction t2 = new Transaction();
		t2.setTitle("Deuxième opération");
		t2.setAmount(40f);
		t2.setDescription("Ma deuxième opération");
		t2.setDate(new Date());
		t2.setPlace("Marseille");
		t2.setPoint(true);
		t2.setCategory(c2);
		t2.setSubcategory(s2);
		transactionRepository.saveAndFlush(t2);
	}

}
