package eu.filip.springtestingexample.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    private UUID id;

    private String name;

    private String company;

    private double price;

    public Product(UUID id, String name, String company, double price) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.price = price;
    }

    public Product(String name, String company, double price) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.company = company;
        this.price = price;
    }
}
