package com.categoryproductService.Controllers;

import com.categoryproductService.ExceptionHandling.BadRequestException;
import com.categoryproductService.ExceptionHandling.EntityNotFoundException;
import com.categoryproductService.Model.Category;
import com.categoryproductService.Model.Product;
import com.categoryproductService.Services.CategoryService;
import com.categoryproductService.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    // add product
    @PostMapping("/add-product")
    public Product addProduct(@RequestBody Product product) throws BadRequestException {
        if(!productService.getProductByName(product.getProduct_name()).isEmpty()) throw new BadRequestException("Product with this name is already present!!!");
        return productService.createProduct(product);
    }

    // update product by id
    @PostMapping("/update/{id}")
    public Product updateProduct(@RequestBody Product product,@PathVariable("id") int id) throws EntityNotFoundException,BadRequestException {
        if(!productService.existsById(id)) throw new EntityNotFoundException("Product with this id NOT FOUND");
        return productService.updateProduct(id,product);
    }

    // delete product by id
    @PostMapping("/delete/{id}")
    public void deleteProduct(@PathVariable("id") int id) throws EntityNotFoundException{
        if(!productService.existsById(id)) throw new EntityNotFoundException("Product with this id NOT FOUND");
        productService.deleteProduct(id);
    }

    // adding category
    @PostMapping("/product-with-category/add/{product_id}/{category_id}")
    public Product addCategory(@PathVariable("product_id") int product_id,@PathVariable("category_id") int category_id) throws EntityNotFoundException{
        if(!productService.existsById(product_id)) throw new EntityNotFoundException("Product with this ID Doesn't Exists !!");
        Category category=categoryService.getCategoryById(category_id);
        if(category==null) throw new EntityNotFoundException("Category with this Id Doesn't Exist!! Cannot Assign to Product!!");
        return productService.addCategory(product_id,category);
    }

    // removing category
    @PostMapping("/product-with-category/remove/{product_id}/{category_id}")
    public Product removeCategory(@PathVariable("product_id") int product_id,@PathVariable("category_id") int category_id) throws EntityNotFoundException{
        if(!productService.existsById(product_id)) throw new EntityNotFoundException("Product with this ID Doesn't Exists !!");
        Category category=categoryService.getCategoryById(category_id);
        if(category==null) throw new EntityNotFoundException("Category with this Id Doesn't Exist!! Cannot Assign to Product!!");
        return productService.removeCategory(product_id,category);
    }


    // get all product
    @GetMapping("/getallproducts")
    public List<Product>getAllProduct(){
        return productService.getAllProduct();
    }

    // get product by id
    @GetMapping("/getproductbyid/{id}")
    public List<Product>getProductById(@PathVariable("id") int id) throws EntityNotFoundException{
        if(!productService.existsById(id)) throw new EntityNotFoundException("Product with this ID Doesn't Exists !!");
        return productService.getProductById(id);
    }

    // get product by name
    @GetMapping("/getproductbyname/{name}")
    public List<Product>getProductByName(@PathVariable("name") String name) throws EntityNotFoundException{
        if(productService.getProductByName(name).isEmpty()) throw new EntityNotFoundException("Product with this name Doesn't Exists !!");
        return productService.getProductByName(name);
    }

    // get product by desc
    @GetMapping("/getproductbydesc/{desc}")
    public List<Product>getProductByDesc(@PathVariable("desc") String desc) throws EntityNotFoundException{
        if(productService.getProductByDesc(desc).isEmpty()) throw new EntityNotFoundException("Product with this desc Doesn't Exists !!");
        return productService.getProductByDesc(desc);
    }

    //get product by price
    @GetMapping("/getproductbyprice/{price}")
    public List<Product>getProductByPrice(@PathVariable("price") int price) throws EntityNotFoundException{
        if(productService.getProductByPrice(price).isEmpty()) throw new EntityNotFoundException("Product with this price Doesn't Exists !!");
        return productService.getProductByPrice(price);
    }
}
