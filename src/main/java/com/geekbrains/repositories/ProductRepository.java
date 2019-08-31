package com.geekbrains.repositories;

import com.geekbrains.entities.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> products = new ArrayList<>();

    @PostConstruct
    public void init() {
        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setId(i);
            product.setCost(100*i);
            product.setTitle("test " + i);
            products.add(product);
        }
    }

    public Product findById(int id){
        return products.get(id);
    }

    public List<Product> findAll(){
        return products;
    }

    public void save(Product product){
        products.add(product);
    }
}
