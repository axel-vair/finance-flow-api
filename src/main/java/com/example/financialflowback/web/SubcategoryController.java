package com.example.financialflowback.web;

import com.example.financialflowback.domain.Category;
import com.example.financialflowback.domain.Subcategory;
import com.example.financialflowback.repository.CategoryRepository;
import com.example.financialflowback.repository.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/api/subcategory", method = {RequestMethod.POST})
@RestController
public class SubcategoryController {

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Subcategory> listCategories() {
        return subcategoryRepository.findAll();
    }
}
