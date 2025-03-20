package com.example.servicetest;


import com.example.model.Customer;
import com.example.repository.CustomerRepository;
import com.example.service.CustomerService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
 
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
 
@ExtendWith(MockitoExtension.class)  // Use Mockito for mocking
class CustomerServiceTest {
 
    @Mock
    private CustomerRepository customerRepository;
 
    @InjectMocks
    private CustomerService customerService;
 
    private Customer customer;
 
    @BeforeEach
    void setUp() {
        customer = new Customer();
        customer.setName("John Doe");
        customer.setEmail("john.doe@gmail.com");
        customer.setContactNo("9876543210");
        customer.setPassword("Password@123");
    }
 
    @Test
    void registerCustomer() {
        // Mocking the repository's save method
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);
 
        // Call the method to be tested
        Customer savedCustomer = customerService.registerCustomer(customer);
 
        assertNotNull(savedCustomer);
        assertEquals("john.doe@gmail.com", savedCustomer.getEmail());
        verify(customerRepository, times(1)).save(any(Customer.class));  // Verifying the interaction with the repository
    }
 
    @Test
    void findByEmail() {
        when(customerRepository.findByEmail("john.doe@gmail.com")).thenReturn(customer);
 
        Customer foundCustomer = customerService.findByEmail("john.doe@gmail.com");
 
        assertNotNull(foundCustomer);
        assertEquals("john.doe@gmail.com", foundCustomer.getEmail());
    }
}
 