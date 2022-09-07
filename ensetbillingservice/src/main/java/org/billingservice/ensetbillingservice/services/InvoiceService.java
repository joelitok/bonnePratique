package org.billingservice.ensetbillingservice.services;

import java.util.List;

import org.billingservice.ensetbillingservice.dto.InvoiceRequestDto;
import org.billingservice.ensetbillingservice.dto.InvoiceResponseDto;

public interface InvoiceService {
    InvoiceResponseDto save(InvoiceRequestDto invoiceRequestDto);
    InvoiceResponseDto getInvoice(String invoiceId);
    List<InvoiceResponseDto> invoicesByCustomerId(String customerId);
    List<InvoiceResponseDto> allInvoices();
}
