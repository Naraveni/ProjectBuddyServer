//package com.example.repositorytest;
//
//import com.example.model.Customer;
//import com.example.repository.CustomerRepository;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@DataJpaTest
//public class CustomerRepositoryTest {
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    private Customer testCustomer;
//
//    @BeforeEach
//    public void setUp() {
//        testCustomer = new Customer();
//        testCustomer.setEmail("test@example.com");
//        testCustomer.setName("John");
//      //  testCustomer.setLastName("Doe");
//        customerRepository.save(testCustomer);
//    }
//
//    @Test
//    public void testFindByEmail() {
//        // Act
//        Customer foundCustomer = customerRepository.findByEmail("test@example.com");
//
//        // Assert
//        assertThat(foundCustomer).isNotNull();
//        assertThat(foundCustomer.getEmail()).isEqualTo("test@example.com");
//       assertThat(foundCustomer.getName()).isEqualTo("John");
//        //assertThat(foundCustomer.getLastName()).isEqualTo("Doe");
//    }
//
//    @Test
//    public void testFindByEmailNotFound() {
//        // Act
//        Customer foundCustomer = customerRepository.findByEmail("nonexistent@example.com");
//
//        // Assert
//        assertThat(foundCustomer).isNull();
//    }
//}
