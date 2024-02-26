package org.example.recaplombak.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String customerName;
    @Version
    private Integer version;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

    @Override
    public boolean equals(Object obj) {
        Customer targetCustomer = (Customer) obj;
        return  obj != null &&
                obj instanceof Customer &&
                targetCustomer.getId().equals(this.id) &&
                targetCustomer.getCustomerName().equals(this.customerName) &&
                targetCustomer.getVersion().equals(this.version) &&
                targetCustomer.getLastModifiedDate().equals(this.lastModifiedDate) &&
                targetCustomer.getCreatedDate().equals(this.createdDate);
    }
}
