package com.apiGateway.Controllers;

import com.apiGateway.Model.Category;
import com.apiGateway.Model.Product;
import com.apiGateway.Model.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consumer")
public class ApiController {

    @Autowired
    UserController userController;
    @Autowired
    CategoryController categoryController;
    @Autowired
    ProductController productController;
    @Autowired
    TokenController tokenController;

    // **************************************token service*****************************//

    // create token
    @GetMapping("/get-token/{id}")
    public String createToken(@PathVariable("id") ObjectId userId){
        return tokenController.createToken(userId);
    }

    // get userId from token
    @GetMapping("/get-userId-from-token/{token}")
    public String getUserIdFromToken(@PathVariable("token") String token){
        return tokenController.getUserIdFromToken(token);
    }

    // ***************************************user service**************************//

    // get all users
    @GetMapping("/getallusers")
    public List<User> getAllUser(){
        return userController.getAllUser();
    }

    //register user
    @PostMapping("/registration")
    public User createUser(@RequestBody User user){
        return userController.createUser(user);
    }

    // login user
    @PostMapping("/login")
    public String login(@RequestBody User user){
        return userController.login(user);

    }

    //******************************category service****************************//

    // add category
    @PostMapping("/shop-management/add-category")
    public Category addCategory(@RequestBody Category category){
        return categoryController.addCategory(category);
    }

    // update category by id
    @PostMapping("/shop-management/updateCategory/{id}")
    public Optional<Category> updateCategory(@RequestBody Category category, @PathVariable("id") int id){
        return categoryController.updateCategory(category, id);
    }

    // delete category by id
    @PostMapping("/shop-management/deleteCategory/{id}")
    public void deleteCategory(@PathVariable("id") int id){
        categoryController.deleteCategory(id);
    }

    // get all categories
//    @GetMapping("/shop-management/getallcategories")
//    public List<Category> getAllCategories(){
//        return categoryController.getAllCategories();
//    }

    // ****************************************product service*****************************//

    // add product
    @PostMapping("/shop-management/add-product")
    public Product addProduct(@RequestBody Product product){
        return productController.addProduct(product);
    }

    // update product by id
    @PostMapping("/shop-management/updateProduct/{id}")
    public Product updateProduct(@RequestBody Product product,@PathVariable("id") int id){
        return productController.updateProduct(product, id);
    }

    // delete product by id
    @PostMapping("/shop-management/deleteProduct/{id}")
    public void deleteProduct(@PathVariable("id") int id){
         productController.deleteProduct(id);
    }

    // add category
    @PostMapping("/shop-management/product-with-category/add/{product_id}/{category_id}")
    public Product addCategory(@PathVariable("product_id") int product_id,@PathVariable("category_id") int category_id){
        return productController.addCategory(product_id,category_id);
    }
    // get all products
//    @GetMapping("/shop-management/getallproducts")
//    public List<Product> getAllProduct(){
//        return productController.getAllProduct();
//    }
}
