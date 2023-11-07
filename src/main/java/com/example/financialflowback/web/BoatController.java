package com.example.financialflowback.web;
import com.example.financialflowback.domain.Boat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.financialflowback.repository.BoatRepository;

import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "api/boats", method = {RequestMethod.POST})
@RestController
public class BoatController {

    @Autowired
    private BoatRepository boatRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Boat> listBoats(){
        return boatRepository.findAll();
    }
}
