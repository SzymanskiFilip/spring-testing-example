package eu.filip.springtestingexample.service;

import eu.filip.springtestingexample.dto.ProductDto;
import eu.filip.springtestingexample.entity.Product;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IProductService {
    Product save(ProductDto productDto);
    Product delete(UUID uuid);
    Product delete(Product product);
    List<Product> getAllProducts();
    List<Product> getProductsCheaperOrPricierThan(double price, String condition);
    Optional<Product> getProductById(UUID id);
}
