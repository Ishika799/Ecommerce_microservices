package com.apiGateway.Controllers;

import com.apiGateway.Model.Category;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@FeignClient("categoryProduct-service/category")
public interface CategoryController {

    // add category
    @PostMapping("/add-category")
    public Category addCategory(@RequestBody Category category);

    // update category by id
    @PostMapping("/update/{id}")
    public Optional<Category> updateCategory(@RequestBody Category category, @PathVariable("id") int id);

    // delete category by id
    @PostMapping("/delete/{id}")
    public void deleteCategory(@PathVariable("id") int id);

    // get all categories
    @GetMapping("/getallcategories")
    public List<Category> getAllCategories();

    // get category by id
    @GetMapping("/getcategorybyid/{id}")
    public Category getCategoryById(@PathVariable("id") int id);

    // get category by name
    @GetMapping("/getcategorybyname/{name}")
    public Category getCategoryByName(@PathVariable("name") String name);

    // get category by desc
    @GetMapping("/getcategorybydesc/{desc}")
    public Category getCategoryByDesc(@PathVariable("desc") String desc);
}
