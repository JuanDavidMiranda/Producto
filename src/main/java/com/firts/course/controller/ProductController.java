package com.firts.course.controller;


import com.firts.course.entity.dto.ProductDto;
import com.firts.course.entity.ProductEntity;
import com.firts.course.service.IProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/productos")
@Tag(name = "Productos", description = "API para gestión de productos")
@SecurityRequirement(name = "token")
public class ProductController {

    private final IProductService iProductService;

    @GetMapping
    @Operation(summary = "Obtener todos los productos", description = "Retorna una lista con todos los productos disponibles")
    public List<ProductEntity> findAll() {
        return iProductService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener producto por id", description = "Retorna el producto buscado por id")
    public ProductEntity findById(@PathVariable int id) {
        return iProductService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Crear un producto", description = "Metodo para crear un producto")
    public ProductEntity createProduct(@Valid @RequestBody ProductDto product){
        return iProductService.createProduct(product);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un producto", description = "Metodo para actualizar un producto")
    public ProductEntity updateProduct(@PathVariable Integer id,@Valid @RequestBody ProductDto product){
        return iProductService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un producto", description = "Metodo para eliminar un producto")
    public void deleteProduct(@PathVariable Integer id){
        iProductService.deleteProduct(id);
    }
}