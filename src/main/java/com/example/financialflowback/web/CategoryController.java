package com.example.financialflowback.web;

import com.example.financialflowback.domain.Category;
import com.example.financialflowback.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/api/categories", method = {RequestMethod.POST})
@RestController
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }
}
