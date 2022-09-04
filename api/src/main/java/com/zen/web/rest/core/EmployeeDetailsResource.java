package com.zen.web.rest.core;

import com.zen.services.service.core.EmployeeService;
import com.zen.services.service.core.dto.EmployeeDTO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
public class EmployeeDetailsResource {


//    @Autowired
//    ECLReportService eclReportService;
    private final Logger logger = LoggerFactory.getLogger(EmployeeDetailsResource.class);
    @Autowired
    EmployeeService employeeService;
    @GetMapping
    public List<EmployeeDTO> getAllEmployee() {
        logger.info("Employee find all method called");
        List<EmployeeDTO> empDto =  employeeService.findAll();
        return empDto;
    }
    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody  EmployeeDTO employeeDTO){
        EmployeeDTO empDtoResp =  employeeService.create(employeeDTO);
        return ResponseEntity.ok(empDtoResp);
    }
    @PutMapping
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO) throws InvocationTargetException, IllegalAccessException {
        EmployeeDTO empDtoResp = employeeService.update(employeeDTO);
        return ResponseEntity.ok(empDtoResp);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<EmployeeDTO> deleteEmployee( @PathVariable("id") Long id){
        EmployeeDTO empDtoResp= employeeService.delete(id);
        return ResponseEntity.ok(empDtoResp);
    }
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> findEmployee( @PathVariable("id") Long id){
        EmployeeDTO empDtoResp= employeeService.find(id);
        return ResponseEntity.ok(empDtoResp);
    }
//    @PostMapping("/default/simulation-model")
//    @ResponseBody
//    public  String  createDefultSimlationModel() {
//
//        return simulationModelService.createDefaultSimulationModel();
//    }
}
