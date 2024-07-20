package com.loqo.productServiceTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.loqo.entity.Product;
import com.loqo.productService.ProductService;
import com.loqo.repository.ProductRepository;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductServiceTest {
	@Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetFilteredProducts() {
        List<Product> products = Arrays.asList(
            new Product("Smartphone", "electronics", 299.99, true, 4.5, new Date()),
            new Product("Laptop", "electronics", 899.99, true, 4.7, new Date()),
            new Product("Headphones", "electronics", 99.99, true, 4.3, new Date())
        );
        when(productRepository.findAll()).thenReturn(products);

        List<Product> result = productService.getFilteredProducts("electronics", 100.0, 1000.0, true, "price", "asc");
        assertEquals(2, result.size());
    }
}
