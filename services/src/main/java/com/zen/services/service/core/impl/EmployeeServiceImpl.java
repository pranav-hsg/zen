package com.zen.services.service.core.impl;

import com.zen.services.domain.core.Employee;
import com.zen.services.repository.EmployeeRepository;
import com.zen.services.service.core.EmployeeService;
import com.zen.services.service.core.dto.EmployeeDTO;
import com.zen.services.service.core.mapper.EmployeeMapper;
import com.zen.services.service.util.NullAwareBeanUtilsBean;
import com.zen.services.service.util.OptionalHandlingUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    NullAwareBeanUtilsBean nullAwareUtil;

    @Override
    public List<EmployeeDTO> findAll() {
        List<Employee> result = employeeRepository.findAll();
//        System.out.println(result.forEach(););
        return result.stream().map(employee -> employeeMapper.toDto(employee)).collect(Collectors.toList());
    }
    @Override
    public EmployeeDTO create(EmployeeDTO employeeDTO){
        Employee employee = employeeMapper.toEntity(employeeDTO);
        Employee e  = employeeRepository.save(employee);
        return  employeeMapper.toDto(e);
    }
    @Override
    public EmployeeDTO update(EmployeeDTO employeeDTO) throws InvocationTargetException, IllegalAccessException {
        Optional<Employee> optEmployee = employeeRepository.findById(employeeDTO.getId());
        Employee e=null;
        if(optEmployee.isPresent()){
            Employee emp = optEmployee.get();
//            BeanUtilsBean nullAwareUtil=new NullAwareBeanUtilsBean();
            nullAwareUtil.copyProperties(emp, employeeDTO);
            e  = employeeRepository.save(emp);

        }else{
            log.error("No employee found for this id....");
        }
        return  employeeMapper.toDto(e);
    }

    @Override
    public EmployeeDTO find(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return processOptional(employee,()-> employeeMapper.toDto(employee.get()));
    }

    @Override
    public EmployeeDTO delete(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return processOptional(employee,()->{employeeRepository.deleteById(id);return employeeMapper.toDto(employee.get());});
    }
    interface  IfPresentFunc<T> {
        T process();
    }
    public <T,U> U processOptional(Optional<T> opt, IfPresentFunc<U> func){
        U ifNotPresentVal = null;
        if(opt.isPresent()){
            return func.process();
        }else{
            return ifNotPresentVal;
        }

    }
}
