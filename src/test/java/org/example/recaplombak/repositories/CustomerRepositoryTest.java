package org.example.recaplombak.repositories;

import org.example.recaplombak.entities.Customer;
import org.example.recaplombak.model.CustomerDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerRepositoryTest {
    private final LocalDateTime CURRENT_TIME = LocalDateTime.now();
    @Autowired
    CustomerRepository customerRepository;

    @Captor
    ArgumentCaptor<UUID> uuidArgumentCaptor;

    @BeforeEach
    void setUp (){
        customerRepository.save(Customer.builder()
                .id(1L)
                .version(1)
                .customerName("Sharukh Khan")
                .createdDate(CURRENT_TIME)
                .lastModifiedDate(CURRENT_TIME)
                .build());

    }
    @Test
    void testSaveCustomer() {
        Customer savedCustomer = customerRepository.save(
                Customer.builder()
                        .customerName("MY Customer")
                        .build()
        );

        assertThat(savedCustomer).isNotNull();
        assertThat(savedCustomer.getId()).isNotNull();
    }
    @Test
    void testCustomerFindById() {
        Customer actualCustomer = customerRepository.findById(1L).get();
        Customer expectedCustomer = Customer.builder()
                .id(1L)
                .version(1)
                .customerName("Sharukh Khan")
                .createdDate(CURRENT_TIME)
                .lastModifiedDate(CURRENT_TIME)
                .build();
        assertThat(actualCustomer).isEqualTo(expectedCustomer);

    }
}