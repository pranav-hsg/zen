package com.zen.services.service.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO implements Serializable {
    @JsonSerialize(using= ToStringSerializer.class)
    @JsonDeserialize(as = Long.class)
    private Long id;

    private Integer version;

    private String employeeId;

    private String employeeName;

    private Integer employeePhone;

    private String employeeAddress;
}
