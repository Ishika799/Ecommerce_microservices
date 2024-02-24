package com.apiGateway.Model;



import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Category {


    private int category_id;
    private String category_name;
    private String description;
}
