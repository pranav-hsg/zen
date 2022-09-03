package com.zen.services.service.core.mapper;

import com.zen.services.domain.core.Employee;
import com.zen.services.service.core.dto.EmployeeDTO;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface EmployeeMapper extends EntityMapper<EmployeeDTO, Employee>{
//    default Employee fromId(Long id) {
//        if (id == null) {
//            return null;
//        }
//        Employee employee = new Employee();
//        employee.setId(id);
//        return employee;
//    }
}
