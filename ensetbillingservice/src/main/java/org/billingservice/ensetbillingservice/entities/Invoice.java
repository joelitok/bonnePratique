package org.billingservice.ensetbillingservice.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Invoice {
  
  @Id
  private String id;
  private Date date;
  private BigDecimal amount;
  private String customerId;
  @Transient
  private Customer customer;  
}
