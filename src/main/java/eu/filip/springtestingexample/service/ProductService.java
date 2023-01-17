package eu.filip.springtestingexample.service;

import eu.filip.springtestingexample.dto.ProductDto;
import eu.filip.springtestingexample.entity.Product;
import eu.filip.springtestingexample.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    @Override
    public Product save(ProductDto productDto) {
        Product p = new Product();
        p.setCompany(productDto.getCompany());
        p.setName(productDto.getName());
        p.setPrice(productDto.getPrice());

        return productRepository.save(p);
    }

    @Override
    public Product delete(UUID uuid) {
        Product p = getProductById(uuid).get();
        productRepository.deleteById(uuid);
        return p;
    }

    @Override
    public Product delete(Product product) {
        productRepository.delete(product);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(p -> {
            products.add(p);
        });

        return products;
    }

    @Override
    public List<Product> getProductsCheaperOrPricierThan(double price, String condition) {
        if(condition.equals("cheaper")){
            return productRepository.getProductsCheaperThan(price);
        } else if (condition.equals("pricier")){
            return productRepository.getProductsPricierThan(price);
        }
        return null;
    }

    @Override
    public Optional<Product> getProductById(UUID id) {
        return productRepository.findById(id);
    }
}
