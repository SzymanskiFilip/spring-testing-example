package eu.filip.springtestingexample.repository;

import eu.filip.springtestingexample.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends CrudRepository<Product, UUID> {


    /**
     * @param price
     * @return All Products with the price lower than or equal to the passed price.
     */
    @Query(nativeQuery = true, value = "select * from products where products.price <= ?1")
    List<Product> getProductsCheaperThan(double price);

    /**
     * @param price
     * @return All Products with the price higher than or equal to the passed price.
     */
    @Query(nativeQuery = true, value = "select * from products where products.price >= ?1")
    List<Product> getProductsPricierThan(double price);
}
