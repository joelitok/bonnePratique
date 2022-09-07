package org.openlab.openlabcustomerservice.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.openlab.openlabcustomerservice.dto.CustomerRequestDto;
import org.openlab.openlabcustomerservice.dto.CustomerResponseDto;
import org.openlab.openlabcustomerservice.entities.Customer;
import org.openlab.openlabcustomerservice.mappers.CustomerMapper;
import org.openlab.openlabcustomerservice.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(
            CustomerRepository customerRepository,
            CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponseDto save(CustomerRequestDto customerRequestDto) {
        /*
         * // Mapping Object Object
         * Customer customer = new Customer();
         * customer.setId(customerRequestDto.getId());
         * customer.setName(customerRequestDto.getName());
         * customer.setEmail(customerRequestDto.getEmail());
         * 
         * Customer customer =
         * customerMapper.customerRequestDtoToCustomer(customerRequestDto);
         * Customer saveCustomer=customerRepository.save(customer);
         * // Mapping Object Object
         * CustomerResponseDto customerResponseDto = new CustomerResponseDto();
         * customerResponseDto.setId(saveCustomer.getId());
         * customerResponseDto.setName(saveCustomer.getName());
         * customerResponseDto.setEmail(saveCustomer.getEmail());
         */

        Customer customer = customerMapper.customerRequestDtoToCustomer(customerRequestDto);
        Customer saveCustomer = customerRepository.save(customer);
        CustomerResponseDto customerResponseDto = customerMapper.customerToCustomerResponseDto(saveCustomer);
        return customerResponseDto;

    }

    @Override
    public CustomerResponseDto getCustomer(String id) {

        if (customerRepository.findById(id).isPresent()) {
            Customer customer = customerRepository.findById(id).get();
            return customerMapper.customerToCustomerResponseDto(customer);
        }
        return null;
    }

    @Override
    public CustomerResponseDto update(CustomerRequestDto customerRequestDto) {
        Customer customer = customerMapper.customerRequestDtoToCustomer(customerRequestDto);
        Customer updatedCustomer = customerRepository.save(customer);
        return customerMapper.customerToCustomerResponseDto(updatedCustomer);
    }

    @Override
    public List<CustomerResponseDto> listCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponseDto> customerResponseDtos = customers.stream().map(
                cust -> customerMapper.customerToCustomerResponseDto(cust)).collect(Collectors.toList());
        return customerResponseDtos;
    }

}
