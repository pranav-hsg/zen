package com.zen.services.service.core;

import com.zen.services.service.core.dto.EmployeeDTO;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> findAll();
    EmployeeDTO create(EmployeeDTO employeeDTO);

    EmployeeDTO update(EmployeeDTO employeeDTO) throws InvocationTargetException, IllegalAccessException;

    EmployeeDTO find(Long id);

    EmployeeDTO delete(Long id);
}
