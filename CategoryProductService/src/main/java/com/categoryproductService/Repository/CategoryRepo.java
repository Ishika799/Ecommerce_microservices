package com.categoryproductService.Repository;

import com.categoryproductService.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepo extends JpaRepository<Category,Integer> {

    @Query(value ="SELECT c FROM Category c WHERE c.category_id = :id")
    Category categoryById(@Param("id") int id);

    @Query(value ="SELECT c FROM Category c WHERE c.category_name = :name")
    Category categoryByName(String name);

    @Query(value ="SELECT c FROM Category c WHERE c.description = :description")
    Category categorybyDesc(String description);
}
