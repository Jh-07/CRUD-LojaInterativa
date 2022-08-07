package com.example.demo;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductResource {
    private ProductService productService;
    
    
    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        this.productService.addProduct(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
    
    
    @GetMapping("/list")
    public  ResponseEntity<List<Product>> getProducts(){
        List<Product> products = productService.getAllProduct();
        return new ResponseEntity<>(products, HttpStatus.OK);

    }
    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        Product updatedProduct = productService.addProduct(product); 
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
    }
    
}
