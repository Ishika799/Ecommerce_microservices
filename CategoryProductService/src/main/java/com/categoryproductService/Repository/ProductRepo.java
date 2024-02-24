package com.categoryproductService.Repository;

import com.categoryproductService.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Integer> {

    @Query(value = "SELECT p FROM Product p WHERE p.product_id = :id")
    List<Product> productById(@Param("id") int id);

    @Query(value = "SELECT p FROM Product p WHERE p.product_name = :name")
    List<Product>productByName(@Param("name") String name);

    @Query(value = "SELECT p FROM Product p WHERE p.description = :description")
    List<Product>productByDesc(@Param("description") String description);

    @Query(value = "SELECT p FROM Product p WHERE p.price = :price")
    List<Product>productByPrice(@Param("price") int price);
}
