package com.example.demo.infrastructure.repositories.category;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.application.services.ICategoryService;
import com.example.demo.domain.entity.Category;

@Service
public class CategoryImpl implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Category> findAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Transactional
    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Transactional
    @Override
    public Optional<Category> update(Long id, Category category) {
        return categoryRepository.findById(id).map(existingCategory -> {
            existingCategory.setDescripcion(category.getDescripcion());
            existingCategory.setEstado(category.getEstado());
            return categoryRepository.save(existingCategory);
        });
    }

    @Transactional
    @Override
    public Optional<Category> delete(Long id) {
        return categoryRepository.findById(id).map(existingCategory -> {
            categoryRepository.delete(existingCategory);
            return existingCategory;
        });
    }
}
