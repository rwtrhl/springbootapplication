package dev.rahul.productservice.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
public class CategoryDto {
    private UUID id;
    private String name;
}
