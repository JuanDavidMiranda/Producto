package com.firts.course.controller;

import com.firts.course.entity.CategoryEntity;
import com.firts.course.entity.dto.CategoryDto;
import com.firts.course.service.ICategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/categorias")
@Tag(name = "Categorias", description = "API para gestión de categorias")
public class CategoryController {

    private final ICategoryService iCategoryService;

    @GetMapping
    @Operation(summary = "Obtener todos las categorias", description = "Retorna una lista con todos las categorias disponibles")
    public List<CategoryEntity> findall(){
        return iCategoryService.findAll();
    }

    @PostMapping
    @Operation(summary = "Crear una categoria", description = "Metodo para crear una categoria")
    public CategoryEntity createCategory(@Valid @RequestBody CategoryDto categoryDto) {
        return iCategoryService.createCategory(categoryDto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una categoria", description = "Metodo para actualizar una categoria")
    public CategoryEntity updateCategory(@PathVariable Integer id,@Valid @RequestBody CategoryDto categoryDto) {
        return iCategoryService.updateCategory(id, categoryDto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una categoria", description = "Metodo para eliminar una categoria")
    void  deleteCategory(@PathVariable Integer id) {
        iCategoryService.deleteCategory(id);
    }
}