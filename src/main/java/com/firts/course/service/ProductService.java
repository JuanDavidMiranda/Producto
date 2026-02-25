package com.firts.course.service;

import com.firts.course.entity.dto.ProductDto;
import com.firts.course.entity.ProductEntity;
import com.firts.course.repository.IProductRepository;
import com.firts.course.utils.exeptions.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final IProductRepository productRepository;

    public List<ProductEntity> findAll(){
        return productRepository.findAll();
    }

    public ProductEntity findById(int id){
        return productRepository.findById(id).get();
    }

    public ProductEntity createProduct(ProductDto product){
        ProductEntity prod = createEntity(product);
        return productRepository.save(prod);
    }

    public ProductEntity updateProduct(Integer id,ProductDto product){
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(() -> new CustomException("El producto con id:" + id + "no existe",new Date()));
        ProductEntity prod = createEntity(product);
        prod.setId(productEntity.getId());
        return productRepository.save(prod);
    }

    public void deleteProduct(Integer id){
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(() -> new CustomException("El producto con id:" + id + "no existe",new Date()));
        productRepository.deleteById(id);
    }

    public ProductEntity createEntity(ProductDto productDto){
        ProductEntity prod = new ProductEntity();
        prod.setName(productDto.getName());
        prod.setQuantity(productDto.getQuantity());
        prod.setPrice(productDto.getPrice());
        prod.setAvailable(productDto.isAvailable());
        return prod;
    }
}