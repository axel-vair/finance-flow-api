package com.example.financialflowback.web;

import com.example.financialflowback.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.financialflowback.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RequestMapping(value = "/api/users", method = {RequestMethod.POST})
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

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

}


