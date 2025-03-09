package com.mystore.app.rest;

import com.mystore.app.entity.Product;

import com.mystore.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product p = productService.addProduct(product);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        if (products.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Integer id) {
        Product p = productService.getProduct(id);
        if (p != null) {
            return new ResponseEntity<>(p, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
        Product p = productService.updateProduct(id, product);
        if (p != null) {
            return new ResponseEntity<>(p, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Integer id) {
        String message = productService.deleteProduct(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
   
    @GetMapping("/search")
    public ResponseEntity<List<Product>> getProductByName(@RequestParam("name") String name){
    	List<Product> products = productService.getProductByName(name);
    	if(products.isEmpty()) {
    		return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    	}
    	return new ResponseEntity<>(products, HttpStatus.OK);
    }


    // TODO: API to filter products by category
    @GetMapping("/filter/category")
    public ResponseEntity<List<Product>> getProductsByCategory(@RequestParam("category") String category){
    	List<Product> products = productService.getProductByCategory(category);
    	
    	if(products.isEmpty()) {
    		return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    	}
    	return new ResponseEntity<>(products, HttpStatus.OK);
    	
    }


    // TODO: API to filter products by price range
    @GetMapping("/filter/price")
    public List<Product> getProductsByPriceRange(
           @RequestParam("minPrice") double minPrice,
            @RequestParam("maxPrice") double maxPrice) {
        // Handle cases where minPrice might be greater than maxPrice
        if (minPrice > maxPrice) {
            throw new IllegalArgumentException("Min price cannot be greater than max price.");
        }
        return productService.getProductsByPriceRange(minPrice, maxPrice);
    }


    // TODO: API to filter products by stock quantity range
    @GetMapping("/filter/stock")
    public List<Product> getProductsByStockQuantity(
            @RequestParam("minStock") int minStock,
            @RequestParam("maxStock") int maxStock) {
    	 if (minStock > maxStock) {
             throw new IllegalArgumentException("Min stock cannot be greater than max stock.");
         }
        return productService.getProductsByStockQuantityRange(minStock, maxStock);
    }

}