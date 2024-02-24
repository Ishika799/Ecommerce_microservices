package com.categoryproductService.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "product")
public class Product {

    @Id
    private int product_id;
    private String product_name;
    private int price;
    private String description;

    @ManyToMany
    private List<Category> categories = new ArrayList<>();


    public void addCategory(Category category) {
        categories.add(category);
    }

    public void removeCategory(Category category){
        if(!categories.isEmpty()) categories.remove(category);
    }
}
