package com.zen.services.service.core.impl;

import com.zen.services.domain.core.Employee;
import com.zen.services.repository.EmployeeRepository;
import com.zen.services.service.core.EmployeeService;
import com.zen.services.service.core.dto.EmployeeDTO;
import com.zen.services.service.core.mapper.EmployeeMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeMapper employeeMapper;
    @Override
    public List<EmployeeDTO> findAll() {
        List<Employee> result = employeeRepository.findAll();
//        System.out.println(result.forEach(););
        return result.stream().map(employee -> employeeMapper.toDto(employee)).collect(Collectors.toList());
    }
}
