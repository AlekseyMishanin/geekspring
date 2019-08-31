package com.geekbrains.controllers;

import com.geekbrains.entities.Product;
import com.geekbrains.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/showProduct")
    public String getProductForm (Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "product-form";
    }

    @RequestMapping("/addProduct")
    public String processForm(@ModelAttribute("product") Product product, Model model){
        productService.saveProduct(product);
        model.addAttribute("products", productService.getAllProduct());
        return "list-product";
    }

    @RequestMapping("/allProduct")
    public String getAllProduct(Model model){
        model.addAttribute("products", productService.getAllProduct());
        return "list-product";
    }
}
