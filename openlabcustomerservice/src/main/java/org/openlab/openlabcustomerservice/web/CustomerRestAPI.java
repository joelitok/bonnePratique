package org.openlab.openlabcustomerservice.web;

import java.util.List;
import java.util.UUID;

import org.openlab.openlabcustomerservice.dto.CustomerRequestDto;
import org.openlab.openlabcustomerservice.dto.CustomerResponseDto;
import org.openlab.openlabcustomerservice.services.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api")
public class CustomerRestAPI {
   private CustomerService customerService;
    public CustomerRestAPI(CustomerService customerService) {
        this.customerService = customerService;
    }
    
    @GetMapping(path="/customers")
    public List<CustomerResponseDto> allCustomers(){
        return customerService.listCustomers();
    }
    @PostMapping(path="/customers")
    public CustomerResponseDto save(@RequestBody CustomerRequestDto customerRequestDto){
        customerRequestDto.setId(UUID.randomUUID().toString());
        return customerService.save(customerRequestDto);
    }
    @GetMapping(path="/customers/{id}")
    public CustomerResponseDto getCustomer(@PathVariable String id){
        return customerService.getCustomer(id);
    }   
}
