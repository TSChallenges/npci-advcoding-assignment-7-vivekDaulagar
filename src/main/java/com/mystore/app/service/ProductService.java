package com.mystore.app.service;

import com.mystore.app.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    private Integer currentId = 1;

    private List<Product> products = new ArrayList<>(
            Arrays.asList(
                    new Product(currentId++, "Smartphone", "Electronics", 40000.00, 50),
                    new Product(currentId++, "Laptop", "Electronics", 50000.00, 30),
                    new Product(currentId++, "Wireless Headphones", "Electronics", 6000.00, 100),
                    new Product(currentId++, "T-shirt", "Clothing", 999.00, 200),
                    new Product(currentId++, "Jeans", "Clothing", 1499.00, 150),
                    new Product(currentId++, "Leather Jacket", "Clothing", 3000.00, 75),
                    new Product(currentId++, "Running Shoes", "Footwear", 499.00, 120),
                    new Product(currentId++, "Sneakers", "Footwear", 599.00, 200),
                    new Product(currentId++, "Office Chair", "Furniture", 2900.00, 40),
                    new Product(currentId++, "Desk", "Furniture", 4000.00, 60),
                    new Product(currentId++, "Blender", "Appliances", 200.00, 80),
                    new Product(currentId++, "Microwave Oven", "Appliances", 4999.00, 50),
                    new Product(currentId++, "Coffee Maker", "Appliances", 1399.00, 90),
                    new Product(currentId++, "Smart Watch", "Electronics", 999.00, 150),
                    new Product(currentId++, "Bluetooth Speaker", "Electronics", 2499.00, 250)
            )
    );

    public Product addProduct(Product product) {
        product.setId(currentId++);
        products.add(product);
        return product;
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProduct(Integer id) {
        return findProductById(id);
    }

    public Product updateProduct(Integer id, Product product) {
        Product p = findProductById(id);
        if (p == null) return null;
        p.setName(product.getName());
        p.setPrice(product.getPrice());
        p.setCategory(product.getCategory());
        p.setStockQuantity(product.getStockQuantity());
        return p;
    }

    public String deleteProduct(Integer id) {
        Product p = findProductById(id);
        if (p == null) return "Product Not Found";
        products.remove(p);
        return "Product Deleted Successfully";
    }

    private Product findProductById(Integer id) {
        for (Product p: products) {
            if (p.getId().intValue() == id.intValue()) {
                return p;
            }
        }
        return null;
    }

	public List<Product> getProductByName(String name) {
		
		List<Product> list =new ArrayList<Product>(); 
		// TODO Auto-generated method stub
		for(Product p: products) {
			if(p.getName().equalsIgnoreCase(name)) {
				list.add(p);
			}
		}
		return list;
	}
	
	public List<Product> getProductByCategory(String category) {
		// TODO Auto-generated method stub
		List<Product> list =new ArrayList<Product>(); 
		
		for(Product p: products) {
			if(p.getCategory().equalsIgnoreCase(category)) {
				list.add(p);
			}
		}
		return list;
	}
	

	public List<Product> getProductsByPriceRange(double minPrice, double maxPrice) {
		// TODO Auto-generated method stub
		List<Product> list =new ArrayList<Product>(); 
		for(Product p: products) {
			if(p.getPrice()>=minPrice && p.getPrice()<=maxPrice) {
				list.add(p);
			}
		}
		return list;
	}

	public List<Product> getProductsByStockQuantityRange(int minStock, int maxStock) {
		// TODO Auto-generated method stub
		List<Product> list =new ArrayList<Product>(); 
		for(Product p: products) {
			if(p.getStockQuantity()>=minStock && p.getStockQuantity()<=maxStock) {
				list.add(p);
			}
		}
		return list;
	}

    // TODO: Method to search products by name


    // TODO: Method to filter products by category


    // TODO: Method to filter products by price range


    // TODO: Method to filter products by stock quantity range

    
}