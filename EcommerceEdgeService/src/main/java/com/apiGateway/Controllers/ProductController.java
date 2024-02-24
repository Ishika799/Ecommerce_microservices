package com.apiGateway.Controllers;

import com.apiGateway.Model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("categoryProduct-service/product")
public interface ProductController {

    // add product
    @PostMapping("/add-product")
    public Product addProduct(@RequestBody Product product);

    // update product by id
    @PostMapping("/update/{id}")
    public Product updateProduct(@RequestBody Product product,@PathVariable("id") int id);

    // delete product by id
    @PostMapping("/delete/{id}")
    public void deleteProduct(@PathVariable("id") int id);

    // add category
    @PostMapping("/product-with-category/add/{product_id}/{category_id}")
    public Product addCategory(@PathVariable("product_id") int product_id,@PathVariable("category_id") int category_id);

    // get all products
    @GetMapping("/getallproducts")
    public List<Product> getAllProduct();

    // get product by id
    @GetMapping("/getproductbyid/{id}")
    public List<Product>getProductById(@PathVariable("id") int id);

    // get product by name
    @GetMapping("/getproductbyname/{name}")
    public List<Product>getProductByName(@PathVariable("name") String name);

    // get product by desc
    @GetMapping("/getproductbydesc/{desc}")
    public List<Product>getProductByDesc(@PathVariable("desc") String desc);

    // get product by price
    @GetMapping("/getproductbyprice/{price}")
    public List<Product>getProductByPrice(@PathVariable("price") int price);
}
