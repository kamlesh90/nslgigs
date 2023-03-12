package com.few.more.java.productservice.service;

import com.few.more.java.productservice.dto.ProductRequest;
import com.few.more.java.productservice.dto.ProductResponse;
import com.few.more.java.productservice.model.Product;
import com.few.more.java.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("product {} is saved", product.getId());
    }

    public List<ProductResponse> getAllProducts(){
        List<Product> products =  productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
            ProductResponse productResponse = ProductResponse.builder()
                    .id(product.getId())
                            .name(product.getName())
                                      .description(product.getDescription())
                                            .price(product.getPrice())
                    .build();

        return productResponse;
    }
}
