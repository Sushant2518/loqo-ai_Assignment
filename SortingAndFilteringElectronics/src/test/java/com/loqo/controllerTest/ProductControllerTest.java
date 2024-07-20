package com.loqo.controllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loqo.controller.ProductController;
import com.loqo.entity.Product;
import com.loqo.productService.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testGetProducts() throws Exception {
        List<Product> products = Arrays.asList(
            new Product("Smartphone", "electronics", 299.99, true, 4.5, new Date()),
            new Product("Laptop", "electronics", 899.99, true, 4.7, new Date()),
            new Product("Headphones", "electronics", 99.99, true, 4.3, new Date())
        );
        when(productService.getFilteredProducts("electronics", 100.0, 1000.0, true, "price", "asc")).thenReturn(products);

        mockMvc.perform(get("/products")
            .param("category", "electronics")
            .param("minPrice", "100")
            .param("maxPrice", "1000")
            .param("inStock", "true")
            .param("sortField", "price")
            .param("sortOrder", "asc"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(3)))
            .andExpect(jsonPath("$[0].name", is("Smartphone")))
            .andExpect(jsonPath("$[1].name", is("Laptop")))
            .andExpect(jsonPath("$[2].name", is("Headphones")));
    }
}
