package org.billingservice.ensetbillingservice.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.billingservice.ensetbillingservice.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class InvoiceResponseDto {
    private String id;
    private Date date;
    private BigDecimal amount;
    private Customer customer;
}
