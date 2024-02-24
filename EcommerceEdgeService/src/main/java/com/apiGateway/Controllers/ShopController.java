package com.apiGateway.Controllers;

import com.apiGateway.Model.Category;
import com.apiGateway.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("shop")
public class ShopController {

    @Autowired
    CategoryController categoryController;
    @Autowired
    ProductController productController;

    // get all category
    @GetMapping("/getallcategories")
    public List<Category>getAllCategories(){
        return categoryController.getAllCategories();
    }

    // get category by id
    @GetMapping("/getcategorybyid/{id}")
    public Category getCategoryById(@PathVariable("id") int id){
        return categoryController.getCategoryById(id);
    }

    // get category by name
    @GetMapping("/getcategorybyname/{name}")
    public Category getCategoryByName(@PathVariable("name") String name){
        return categoryController.getCategoryByName(name);
    }

    // get category by desc
    @GetMapping("/getcategorybydesc/{desc}")
    public Category getCategoryByDesc(@PathVariable("desc") String desc){
        return categoryController.getCategoryByDesc(desc);
    }

    // get all products
    @GetMapping("/getallproducts")
    public List<Product> getAllProduct(){
        return productController.getAllProduct();
    }

    // get product by id
    @GetMapping("/getproductbyid/{id}")
    public List<Product>getProductById(@PathVariable("id") int id){
        return productController.getProductById(id);
    }

    // get product by name
    @GetMapping("/getproductbyname/{name}")
    public List<Product>getProductByName(@PathVariable("name") String name){
        return productController.getProductByName(name);
    }

    // get product by desc
    @GetMapping("/getproductbydesc/{desc}")
    public List<Product>getProductByDesc(@PathVariable("desc") String desc){
        return productController.getProductByDesc(desc);
    }

    // get product by price
    @GetMapping("/getproductbyprice/{price}")
    public List<Product>getProductByPrice(@PathVariable("price") int price){
        return productController.getProductByPrice(price);
    }
}
