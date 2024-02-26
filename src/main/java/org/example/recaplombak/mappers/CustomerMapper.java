package org.example.recaplombak.mappers;

import org.example.recaplombak.entities.Customer;
import org.example.recaplombak.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    Customer customerDtoToCustomer(CustomerDTO dto);

    CustomerDTO customertoCustomerDto(Customer customer);
}
