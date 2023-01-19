package eu.filip.springtestingexample.service;

import eu.filip.springtestingexample.dto.ProductDto;
import eu.filip.springtestingexample.entity.Product;
import eu.filip.springtestingexample.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;
    private AutoCloseable autoCloseable;
    private ProductService productService;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        productService = new ProductService(productRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canSaveAProduct() throws Exception {
        //given
        ProductDto productDto = new ProductDto();
        productDto.setCompany("Placeholder");
        productDto.setName("Product");
        productDto.setPrice(20.0);


        //when
        productService.save(productDto);


        //then
        ArgumentCaptor<Product> argumentCaptor = ArgumentCaptor.forClass(Product.class);
        verify(productRepository).save(argumentCaptor.capture());
        Product captured = argumentCaptor.getValue();

        assertThat(captured.getPrice()).isEqualTo(productDto.getPrice());
        assertThat(captured.getName()).isEqualTo(productDto.getName());
        assertThat(captured.getCompany()).isEqualTo(productDto.getCompany());
        assertThat(captured.getId()).isNotNull();
    }

    @Test
    @DisplayName("should throw exception on THROW_EXCEPTION company name")
    void shouldThrowExceptionOnCompanyName() throws Exception {
        //given
        ProductDto productDto = new ProductDto();
        productDto.setCompany("THROW_EXCEPTION");
        productDto.setName("Product");
        productDto.setPrice(20.0);

        //when
        //then
        assertThatThrownBy(() -> productService.save(productDto))
                .isInstanceOf(Exception.class)
                .hasMessageContaining("SHOULD ERROR");

    }
}