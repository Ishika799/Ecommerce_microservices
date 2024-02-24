package com.apiGateway.Model;


import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {


    private int product_id;
    private String product_name;
    private int price;
    private String description;
    private List<Category> categories;
}
