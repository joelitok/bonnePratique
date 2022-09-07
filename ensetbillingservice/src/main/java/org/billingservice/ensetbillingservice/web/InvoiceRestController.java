package org.billingservice.ensetbillingservice.web;

import java.util.List;

import org.billingservice.ensetbillingservice.dto.InvoiceRequestDto;
import org.billingservice.ensetbillingservice.dto.InvoiceResponseDto;
import org.billingservice.ensetbillingservice.services.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/api")
public class InvoiceRestController {
private InvoiceService invoiceService;
   
public InvoiceRestController(InvoiceService invoiceService) {
    this.invoiceService = invoiceService;
}

@GetMapping(path="/invoices/{id}")
public InvoiceResponseDto getInvoice(@PathVariable(name = "id") String id){
    return invoiceService.getInvoice(id);
}

@GetMapping(path="/invoicesByCustomer/{customerId}")
public List<InvoiceResponseDto> getMethodName(@PathVariable String customerId) {
    return invoiceService.invoicesByCustomerId(customerId);
}

@PostMapping(path="/invoices")
public InvoiceResponseDto save(@RequestBody InvoiceRequestDto invoiceRequestDto){
    return invoiceService.save(invoiceRequestDto);
}
@GetMapping(path="/invoices")
public List<InvoiceResponseDto> allInvoices(){
    return invoiceService.allInvoices();
}

@ExceptionHandler(Exception.class)
public ResponseEntity<String> exceptionHandler(Exception e){
    return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
}

}
