package org.openlab.openlabcustomerservice.services;

import java.util.List;

import org.openlab.openlabcustomerservice.dto.CustomerRequestDto;
import org.openlab.openlabcustomerservice.dto.CustomerResponseDto;

public interface CustomerService {
    CustomerResponseDto save(CustomerRequestDto customerRequestDto);
    CustomerResponseDto getCustomer(String id);
    CustomerResponseDto update(CustomerRequestDto customerRequestDto);
    List<CustomerResponseDto> listCustomers();
}
