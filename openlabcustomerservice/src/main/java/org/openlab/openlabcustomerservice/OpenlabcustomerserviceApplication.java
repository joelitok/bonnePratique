package org.openlab.openlabcustomerservice;

import org.openlab.openlabcustomerservice.dto.CustomerRequestDto;
import org.openlab.openlabcustomerservice.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OpenlabcustomerserviceApplication implements CommandLineRunner{
	
	@Autowired
	private CustomerService customerService;
	public static void main(String[] args) {
		SpringApplication.run(OpenlabcustomerserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerService.save(new CustomerRequestDto("C01","Adria","Adri@adria.com"));
		customerService.save(new CustomerRequestDto("C02","OpenLab","Open@OpenLab.com")); 
		
		}

}
