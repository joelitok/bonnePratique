package org.billingservice.ensetbillingservice.mappers;

import org.billingservice.ensetbillingservice.dto.InvoiceRequestDto;
import org.billingservice.ensetbillingservice.dto.InvoiceResponseDto;
import org.billingservice.ensetbillingservice.entities.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    Invoice fromInvoiceRequestDto(InvoiceRequestDto invoiceRequestDto); 
    InvoiceResponseDto fromInvoice(Invoice invoice);
}
