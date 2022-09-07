package org.openlab.openlabcustomerservice.mappers;

import org.mapstruct.Mapper;
import org.openlab.openlabcustomerservice.dto.CustomerRequestDto;
import org.openlab.openlabcustomerservice.dto.CustomerResponseDto;
import org.openlab.openlabcustomerservice.entities.Customer;

@Mapper(componentModel = "spring")
 public interface CustomerMapper {
CustomerResponseDto customerToCustomerResponseDto(Customer customer);
Customer customerRequestDtoToCustomer(CustomerRequestDto customerRequestDto);

    
}
