package org.billingservice.ensetbillingservice.repositories;

import java.util.List;

import org.billingservice.ensetbillingservice.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,String> {
    List<Invoice> findByCustomerId(String customerId);
    
}
