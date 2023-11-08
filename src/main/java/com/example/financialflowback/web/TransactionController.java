package com.example.financialflowback.web;

import com.example.financialflowback.domain.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.financialflowback.repository.TransactionRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RequestMapping(value = "/api/transactions", method = {RequestMethod.POST})
@RestController
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    /**
     * Method that get all transactions
     * @return
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Transaction> listTransactions() {

        return transactionRepository.findAll();
    }

    /**
     * Method that get transaction by ID
     * @param id
     * @return
     */
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Transaction> singleTransaction(@PathVariable Integer id){
        return transactionRepository.findById(id);
    }

    /**
     * Method used to create a new transaction
     * @param transaction
     * @return
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Transaction createTransaction(@RequestBody Transaction transaction){
        return transactionRepository.save(transaction);
    }

    /**
     * Method used to point the transaction and update it with bolean
     * @param id
     * @param transaction
     * @return
     */
    @PutMapping(value = "{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable Integer id, @RequestBody Transaction transaction){
        Optional<Transaction> existingTransaction = transactionRepository.findById(id);
        if(existingTransaction.isPresent()){
            Transaction updateTransaction = existingTransaction.get();
            updateTransaction.setAmount(transaction.getAmount());

            Transaction savedTransaction = transactionRepository.save(updateTransaction);
            return ResponseEntity.ok(savedTransaction);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Method used to delete a transaction
     * @param id
     * @return
     */
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Transaction> deleteTransaction(@PathVariable Integer id){
        transactionRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

