package org.billingservice.ensetbillingservice.openfeign;

import java.util.List;

import org.billingservice.ensetbillingservice.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {

  @GetMapping(path="/api/customers/{id}")
  Customer getCustomer(@PathVariable(name = "id") String id);
  
  @GetMapping(path = "/api/customers")
  List<Customer> allCustomer();  
}
