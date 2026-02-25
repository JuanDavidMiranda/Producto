package com.firts.course.service;

import com.firts.course.entity.ProductEntity;
import com.firts.course.entity.dto.ProductDto;

import java.util.List;

public interface IProductService {

    List<ProductEntity> findAll();

    ProductEntity findById(int id);

    ProductEntity createProduct(ProductDto product);

    ProductEntity updateProduct(Integer id,ProductDto product);

    void deleteProduct(Integer id);
}