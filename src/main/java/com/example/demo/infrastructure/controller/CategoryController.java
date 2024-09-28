package com.example.demo.infrastructure.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.application.services.ICategoryService;
import com.example.demo.domain.entity.Category;


@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoriImpl;

    @GetMapping
    public List<Category> list() {
        return categoriImpl.findAll();
    }
}
