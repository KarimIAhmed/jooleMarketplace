package com.example.joole.service;

import com.example.joole.model.Product;
import com.example.joole.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public String deleteProduct(long id){
        productRepository.deleteById(id);
        return "product " + id + " has been removed";
    }



//////////////////////////////////////////////////////////////////////////////

    private List<Product> products;

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProduct(long id){
        return products.stream().filter(c-> c.getId() == id).findFirst().get();
    }


}
