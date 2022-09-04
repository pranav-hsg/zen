package com.zen.services.domain.core;



import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="employee_details")
public class Employee extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(strategy
            = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Integer version;

    @Column(name="employee_id")
    private String employeeId;

    @Column(name="employee_name")
    private String employeeName;

    @Column(name="employee_phone")
    private Integer employeePhone;

    @Column(name="employee_address")
    private String employeeAddress;


}

