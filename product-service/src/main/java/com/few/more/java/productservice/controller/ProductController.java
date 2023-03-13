package com.few.more.java.productservice.controller;

import com.few.more.java.productservice.dto.ProductRequest;
import com.few.more.java.productservice.dto.ProductResponse;
import com.few.more.java.productservice.model.Product;
import com.few.more.java.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);

    }
    @GetMapping("/allProduct")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
         List<ProductResponse> products = productService.getAllProducts();

        return products;
    }
}
