package org.billingservice.ensetbillingservice.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Customer {
    private String id;
    private String name;
    private String email;

}
