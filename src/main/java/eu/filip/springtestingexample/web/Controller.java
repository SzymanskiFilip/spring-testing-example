package eu.filip.springtestingexample.web;

import eu.filip.springtestingexample.dto.ProductDto;
import eu.filip.springtestingexample.entity.Product;
import eu.filip.springtestingexample.service.ProductService;
import jakarta.annotation.Nullable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
public class Controller {

    private final ProductService productService;

    public Controller(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProductsCheaperThan(@RequestParam(name = "condition", required = false) Optional<String> condition, @RequestParam(name = "price", required = false) Optional<String> price){
       if(condition.isPresent() && price.isPresent()){
           return ResponseEntity.ok(productService.getProductsCheaperOrPricierThan(Double.parseDouble(price.get()), condition.get()));
       }
       return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(name = "id")UUID id){
        return ResponseEntity.ok(productService.getProductById(id).get());
    }

    @PostMapping("/products")
    public ResponseEntity<Product> saveProduct(@RequestBody final ProductDto productDto) throws Exception {
        return ResponseEntity.ok(productService.save(productDto));
    }

    @DeleteMapping("/products/{}")
    public ResponseEntity<Product> deleteProduct(@PathVariable final UUID uuid){
        return ResponseEntity.ok(productService.delete(uuid));
    }

    @DeleteMapping("/products")
    public ResponseEntity<Product> deleteByProduct(@RequestBody final Product product){
        return ResponseEntity.ok(productService.delete(product));
    }
}
