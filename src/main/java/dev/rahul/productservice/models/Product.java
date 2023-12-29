package dev.rahul.productservice.models;


import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;
    private String description;
    private String image;
//    @OneToOne(cascade={CascadeType.PERSIST})
//    private Price price;
    @ManyToOne(cascade={CascadeType.PERSIST})
    private Category category;
}
