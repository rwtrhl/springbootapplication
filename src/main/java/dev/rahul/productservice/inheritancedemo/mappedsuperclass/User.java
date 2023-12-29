package dev.rahul.productservice.inheritancedemo.mappedsuperclass;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass

public class User {
    @Id
    private Long id;
    private String name;
    private String email;

}
