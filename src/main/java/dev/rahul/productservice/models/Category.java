package dev.rahul.productservice.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Category extends BaseModel {

    @Column
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    // This is the same relation mentioned by category attribute of other  object
    private List<Product> products;

}
