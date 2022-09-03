package com.zen.services.service.core;

import com.zen.services.service.core.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> findAll();
}
