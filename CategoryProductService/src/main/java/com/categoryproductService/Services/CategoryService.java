package com.categoryproductService.Services;

import com.categoryproductService.Model.Category;
import com.categoryproductService.Repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    //add category
    public Category createCategory(Category category){
        Category category1= categoryRepo.save(category);
        return category1;
    }

    //check category by id
    public boolean existById(int id) {
        boolean existornot = categoryRepo.existsById(id);
        return existornot;
    }
    //update category by id
    public Optional<Category> updateCategory(Category category, int id) {
        Optional<Category>updatecategory = Optional.of(categoryRepo.saveAndFlush(category));
        int Id = category.getCategory_id();
        if(existById(Id)) return updatecategory;
        return null;
    }

    // delete category by id
    public void deleteCategoryById(int id) {
        categoryRepo.deleteById(id);
    }

    // get all category
    public List<Category> getAllCategories(){
        return categoryRepo.findAll();
    }

    // get category by id
    public Category getCategoryById(int id){
        return categoryRepo.categoryById(id);
    }

    // get category by name
    public Category getCategoryByName(String name){
        return categoryRepo.categoryByName(name);
    }

    // get category by description
    public Category getCategoryByDesc(String desc){
        return categoryRepo.categorybyDesc(desc);
    }
}
