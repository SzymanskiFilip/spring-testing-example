package eu.filip.springtestingexample.repository;

import eu.filip.springtestingexample.entity.Product;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;


    @Test
    @DisplayName("The saved Entity should be found in the Database by the set UUID")
    void itShouldFindByID(){
        //given
        UUID id = UUID.randomUUID();
        Product product = new Product();
        product.setPrice(20.0);
        product.setCompany("Kelloggs");
        product.setName("Corn Flakes");
        product.setId(id);
        productRepository.save(product);

        //when
        boolean expected = false;
        if(productRepository.findById(id).isPresent()){
            expected = true;
        }

        //then
        assertThat(expected).isTrue();
    }

    @ParameterizedTest
    @DisplayName("The Database should return only values that are smaller or equal to the given number")
    @ValueSource(doubles = {1.0, 5.0, 10.0, Double.MAX_VALUE})
    void itShouldBeSmallerThanInput(double price){
        //given
        //Double price = 6.0;
        Product p1 = new Product(UUID.randomUUID(), "First", "TEST", 10.0);
        Product p2 = new Product(UUID.randomUUID(), "Second", "TEST", 1.0);
        Product p3 = new Product(UUID.randomUUID(), "THIRD", "TEST", 5.0);

        productRepository.save(p1);
        productRepository.save(p2);
        productRepository.save(p3);

        //when
        List<Product> products = productRepository.getProductsCheaperThan(price);

        //then
        products.forEach(p -> {
            assertThat(p.getPrice()).isLessThanOrEqualTo(price);
        });
    }

    @ParameterizedTest
    @DisplayName("The Database should return only values that are larger or equal to the given number")
    @ValueSource(doubles = {1.0, 3.0, 4.0, 5.0, 6.0, 10.0, Double.MAX_VALUE})
    void itShouldBeLargerThanInput(double givenPrice){
        //given
        Product p1 = new Product(UUID.randomUUID(), "1", "2", 1.0);
        Product p2 = new Product(UUID.randomUUID(), "1", "2", 2.0);
        Product p3 = new Product(UUID.randomUUID(), "1", "2", 4.0);
        Product p4 = new Product(UUID.randomUUID(), "1", "2", 6.0);
        Product p5 = new Product(UUID.randomUUID(), "1", "2", 20.0);
        Product p6 = new Product(UUID.randomUUID(), "1", "2", 30.0);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));

        //when
        List<Product> products = productRepository.getProductsPricierThan(givenPrice);

        //then
        products.forEach(p -> {
            assertThat(p.getPrice()).isGreaterThanOrEqualTo(givenPrice);
        });

    }

}