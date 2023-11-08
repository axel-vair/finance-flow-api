package com.example.financialflowback.web;
import com.example.financialflowback.domain.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.financialflowback.repository.TransactionRepository;

import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/api/transactions", method = {RequestMethod.POST})
@RestController
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Transaction> listBoats(){
        return transactionRepository.findAll();
    }
}
