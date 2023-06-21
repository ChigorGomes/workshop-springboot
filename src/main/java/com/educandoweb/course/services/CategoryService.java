package com.educandoweb.course.services;

import com.educandoweb.course.dto.CategoryDTO;
import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepositories;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findByAll() {
        return categoryRepositories.findAll().stream().map(CategoryDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public CategoryDTO findById(Long categoryId) {
        Category category = categoryRepositories.findById(categoryId).get();
        return new CategoryDTO(category);
    }


}
