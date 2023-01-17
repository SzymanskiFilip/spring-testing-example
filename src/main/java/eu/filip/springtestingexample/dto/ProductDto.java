package eu.filip.springtestingexample.dto;

import lombok.Data;

@Data
public class ProductDto {
    private String name;

    private String company;

    private double price;
}
