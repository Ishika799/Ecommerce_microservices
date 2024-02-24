package com.categoryproductService.Controllers;

import com.categoryproductService.ExceptionHandling.BadRequestException;
import com.categoryproductService.ExceptionHandling.EntityNotFoundException;
import com.categoryproductService.Model.Category;
import com.categoryproductService.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // add category
    @PostMapping("/add-category")
    public Category addCategory(@RequestBody Category category)throws BadRequestException {
        Category category1=categoryService.createCategory(category);
        return category1;
    }

    // update category by id
    @PostMapping("/update/{id}")
    public Optional<Category>updateCategory(@RequestBody Category category, @PathVariable("id") int id) throws EntityNotFoundException,BadRequestException {
        if(!categoryService.existById(id)) throw new EntityNotFoundException("Category with this id NOT FOUND");
        return categoryService.updateCategory(category,id);
    }

    // delete category by id
    @PostMapping("/delete/{id}")
    public void deleteCategory(@PathVariable("id") int id) throws EntityNotFoundException,BadRequestException{
        if(!categoryService.existById(id))  throw new EntityNotFoundException("Category with this id NOT FOUND");

        try{
            categoryService.deleteCategoryById(id);
        }
        catch (Exception e){
            throw new BadRequestException("Category Can't be deleted !! Because it is linked with some Products !!");
        }
    }

    //get all category
    @GetMapping("/getallcategories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    // get category by id
    @GetMapping("/getcategorybyid/{id}")
    public Category getCategoryById(@PathVariable("id") int id) throws EntityNotFoundException,BadRequestException{
        if(!categoryService.existById(id)) throw new EntityNotFoundException("Category with this id NOT FOUND");
        try{
            return categoryService.getCategoryById(id);
        }catch (Exception e){
            throw new BadRequestException("Category can't found");
        }
    }

    // get category by name
    @GetMapping("/getcategorybyname/{name}")
    public Category getCategoryByName(@PathVariable("name") String name){
        return categoryService.getCategoryByName(name);
    }

    //get category by description
    @GetMapping("/getcategorybydesc/{desc}")
    public Category getCategoryByDesc(@PathVariable("desc") String desc){
        return categoryService.getCategoryByDesc(desc);
    }


}
