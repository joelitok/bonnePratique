package org.billingservice.ensetbillingservice.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class InvoiceRequestDto {
    private BigDecimal amount;
    private String customerId;
}
