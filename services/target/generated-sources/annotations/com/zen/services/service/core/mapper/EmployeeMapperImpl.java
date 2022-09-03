package com.zen.services.service.core.mapper;

import com.zen.services.domain.core.Employee;
import com.zen.services.domain.core.Employee.EmployeeBuilder;
import com.zen.services.service.core.dto.EmployeeDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-04T00:57:22+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public Employee toEntity(EmployeeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        EmployeeBuilder employee = Employee.builder();

        employee.id( dto.getId() );
        employee.version( dto.getVersion() );
        employee.employeeId( dto.getEmployeeId() );
        employee.employeeName( dto.getEmployeeName() );
        employee.employeePhone( dto.getEmployeePhone() );
        employee.employeeAddress( dto.getEmployeeAddress() );

        return employee.build();
    }

    @Override
    public EmployeeDTO toDto(Employee entity) {
        if ( entity == null ) {
            return null;
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setId( entity.getId() );
        employeeDTO.setVersion( entity.getVersion() );
        employeeDTO.setEmployeeId( entity.getEmployeeId() );
        employeeDTO.setEmployeeName( entity.getEmployeeName() );
        employeeDTO.setEmployeePhone( entity.getEmployeePhone() );
        employeeDTO.setEmployeeAddress( entity.getEmployeeAddress() );

        return employeeDTO;
    }

    @Override
    public List<Employee> toEntity(List<EmployeeDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Employee> list = new ArrayList<Employee>( dtoList.size() );
        for ( EmployeeDTO employeeDTO : dtoList ) {
            list.add( toEntity( employeeDTO ) );
        }

        return list;
    }

    @Override
    public List<EmployeeDTO> toDto(List<Employee> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EmployeeDTO> list = new ArrayList<EmployeeDTO>( entityList.size() );
        for ( Employee employee : entityList ) {
            list.add( toDto( employee ) );
        }

        return list;
    }
}
