package org.billingservice.ensetbillingservice.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.billingservice.ensetbillingservice.dto.InvoiceRequestDto;
import org.billingservice.ensetbillingservice.dto.InvoiceResponseDto;
import org.billingservice.ensetbillingservice.entities.Customer;
import org.billingservice.ensetbillingservice.entities.Invoice;
import org.billingservice.ensetbillingservice.exception.CustomerNotFoundException;
import org.billingservice.ensetbillingservice.mappers.InvoiceMapper;
import org.billingservice.ensetbillingservice.openfeign.CustomerRestClient;
import org.billingservice.ensetbillingservice.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

private InvoiceRepository invoiceRepository;
private InvoiceMapper invoiceMapper;
private CustomerRestClient customerRestClient;

public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper, CustomerRestClient customerRestClient) {
this.invoiceRepository = invoiceRepository;
this.invoiceMapper = invoiceMapper;
this.customerRestClient = customerRestClient;
}
    @Override
    public InvoiceResponseDto save(InvoiceRequestDto invoiceRequestDto) {
        Customer customer=null;
        try {
          customer = customerRestClient.getCustomer(invoiceRequestDto.getCustomerId());   
        } catch (Exception e) {
           throw new CustomerNotFoundException("Customer not found");
        }
        Invoice invoice = invoiceMapper.fromInvoiceRequestDto(invoiceRequestDto);
        invoice.setId(UUID.randomUUID().toString());
        invoice.setDate(new Date());
        /*
         * verification de l integrite referentielle invoice/customer
         */
        Invoice saveInvoice = invoiceRepository.save(invoice);
        saveInvoice.setCustomer(customer);
        return invoiceMapper.fromInvoice(saveInvoice);
    }

    @Override
    public InvoiceResponseDto getInvoice(String invoiceId) {
        Invoice invoice = invoiceRepository.findById(invoiceId).get();
        Customer customer = customerRestClient.getCustomer(invoice.getCustomerId());
        invoice.setCustomer(customer);
        return invoiceMapper.fromInvoice(invoice);
    }

    @Override
    public List<InvoiceResponseDto> invoicesByCustomerId(String customerId) {
    List<Invoice> invoices = invoiceRepository.findByCustomerId(customerId); 
    for(Invoice invoice:invoices){
        Customer customer =customerRestClient.getCustomer(invoice.getCustomerId());
        invoice.setCustomer(customer);    
    }
    return invoices.stream().map(invoice->invoiceMapper.fromInvoice(invoice)).collect(Collectors.toList());
    }
    @Override
    public List<InvoiceResponseDto> allInvoices() {
        List<Invoice> invoices =invoiceRepository.findAll();
        for(Invoice invoice:invoices){
        Customer customer =customerRestClient.getCustomer(invoice.getCustomerId());
        invoice.setCustomer(customer);    
    }
        return invoices.stream().map(inv->invoiceMapper.fromInvoice(inv)).collect(Collectors.toList());
    }
    
}
