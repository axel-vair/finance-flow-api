package com.example.financialflowback.web;

import com.example.financialflowback.domain.User;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.financialflowback.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin("*")
@RequestMapping(value = "/api/users", method = {RequestMethod.POST})

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
    private String mail;
    private String password;


    /**
     * Method that get all transactions
     * @return
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    /**
     * Method that get transaction by ID
     * @param id
     * @return
     */
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<User> singleUser(@PathVariable Integer id){
        return userRepository.findById(id);
    }

    /**
     * Method used to create a new transaction
     * @param
     * @return
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    /**
     * Method used to point the user and update it with bolean
     * @param id
     * @param user
     * @return
     */
    @PutMapping(value = "{id}")
   public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user){
        Optional<User> existingUser = userRepository.findById(id);
        if(existingUser.isPresent()){
            User updateUser = existingUser.get();
           updateUser.setMail(user.getMail());

            User savedUser = userRepository.save(updateUser);
            return ResponseEntity.ok(savedUser);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
/**
         * @param mail     The user's mail
            * @param password The user's password
            * @return ResponseEntity indicating success or failure
     */



    /**
     * Method to check if a user with a specific mail and password exists in the database

     * @return ResponseEntity indicating success or failure
     */

    @PostMapping(value = "/checkUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> checkUser(@PathVariable String mail, @RequestBody UserController userController) {
        // Retrieve the user from the database based on the provided mail
        Optional<User> optionalUser = userRepository.findByMail(userController.getMail());

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            // Check if the provided password matches the stored password
            if (user.getPassword().equals(userController.getPassword())) {
                return ResponseEntity.ok("User exists and password matches");
            } else {
                return ResponseEntity.ok("User exists but incorrect password");
            }
        } else {
            return ResponseEntity.ok("User not found");
        }
    }

    private String getMail() {
        return this.mail;
    }

    private String getPassword() {
        return this.password;
    }




        public void setMail(String mail) {
            this.mail = mail;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }




