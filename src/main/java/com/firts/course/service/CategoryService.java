package com.firts.course.service;

import com.firts.course.entity.CategoryEntity;
import com.firts.course.entity.dto.CategoryDto;
import com.firts.course.repository.ICategoryRepository;
import com.firts.course.utils.exeptions.CustomException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService implements  ICategoryService {

    private final ICategoryRepository categoryRepository;


    @Override
    public List<CategoryEntity> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryEntity createCategory(CategoryDto category) {
        CategoryEntity cat = createEntity(category);
        return categoryRepository.save(cat);
    }

    @Override
    public CategoryEntity updateCategory(Integer id, CategoryDto category) {
        categoryRepository.findById(id).orElseThrow(() -> new CustomException("El producto con id:" + id + "no existe",new Date()));
        CategoryEntity cat = createEntity(category);
        cat.setId(cat.getId());
        return categoryRepository.save(cat);
    }

    @Override
    public void deleteCategory(int id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id).orElseThrow(() -> new CustomException("El producto con id:" + id + "no existe",new Date()));
        categoryRepository.delete(categoryEntity);
    }

    public CategoryEntity createEntity(CategoryDto categoryDto) {
        CategoryEntity cat = new CategoryEntity();
        cat.setName(categoryDto.getName());
        cat.setDescription(categoryDto.getDescription());
        return cat;
    }
}