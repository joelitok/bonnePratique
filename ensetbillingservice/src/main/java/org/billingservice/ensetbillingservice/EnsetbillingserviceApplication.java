package org.billingservice.ensetbillingservice;

import java.math.BigDecimal;

import org.billingservice.ensetbillingservice.dto.InvoiceRequestDto;
import org.billingservice.ensetbillingservice.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients //pour l activation de open feign
public class EnsetbillingserviceApplication  implements CommandLineRunner{
	@Autowired
	private InvoiceService invoiceService;

	public static void main(String[] args) {
		SpringApplication.run(EnsetbillingserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	invoiceService.save(new InvoiceRequestDto(BigDecimal.valueOf(98000),"C01"));
	invoiceService.save(new InvoiceRequestDto(BigDecimal.valueOf(54300),"C01"));
	invoiceService.save(new InvoiceRequestDto(BigDecimal.valueOf(12000),"C02"));
			
}

}
