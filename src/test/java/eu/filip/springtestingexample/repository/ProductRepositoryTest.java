package eu.filip.springtestingexample.repository;

import eu.filip.springtestingexample.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;


    @Test
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

}