package com.firts.course.service;

import com.firts.course.entity.CategoryEntity;
import com.firts.course.entity.dto.CategoryDto;
import java.util.List;

public interface ICategoryService {

    List<CategoryEntity> findAll();

    CategoryEntity createCategory(CategoryDto category);

    CategoryEntity updateCategory(Integer id,CategoryDto category);

    void deleteCategory(int id);
}