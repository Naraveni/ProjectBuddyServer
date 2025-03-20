package com.example.controllertest;


import com.example.controller.CustomerController;
import com.example.model.Customer;
import com.example.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
 
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
 
@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {
 
    private MockMvc mockMvc;
 
    @Mock
    private CustomerService customerService;
 
    @InjectMocks
    private CustomerController customerController;
 
    private Customer customer;
 
    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
 
        customer = new Customer();
        customer.setName("John Doe");
        customer.setEmail("john.doe@gmail.com");
        customer.setContactNo("9876543210");
        customer.setPassword("Password@123");
    }
 
    @Test
    void registerCustomer() throws Exception {
        // Simulate the service response
        when(customerService.registerCustomer(any(Customer.class))).thenReturn(customer);
 
        // Perform a POST request and validate the response
        mockMvc.perform(post("/api/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"John Doe\", \"email\":\"john.doe@gmail.com\", \"contactNo\":\"9876543210\", \"password\":\"Password@123\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.email").value("john.doe@gmail.com"));
 
        verify(customerService, times(1)).registerCustomer(any(Customer.class));  // Verify service interaction
    }
}
 
 