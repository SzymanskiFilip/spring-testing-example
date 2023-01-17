package eu.filip.springtestingexample.service;

import eu.filip.springtestingexample.dto.ProductDto;
import eu.filip.springtestingexample.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProductService implements IProductService {
    @Override
    public Product save(ProductDto productDto) {
        return null;
    }

    @Override
    public Product delete(UUID uuid) {
        return null;
    }

    @Override
    public Product delete(Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public List<Product> getProductsCheaperThan(double maxPrice) {
        return null;
    }

    @Override
    public Optional<Product> getProductById(UUID id) {
        return Optional.empty();
    }
}
