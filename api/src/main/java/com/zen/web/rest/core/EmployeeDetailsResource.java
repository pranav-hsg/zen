package com.zen.web.rest.core;

import com.zen.services.service.core.EmployeeService;
import com.zen.services.service.core.dto.EmployeeDTO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class EmployeeDetailsResource {


//    @Autowired
//    ECLReportService eclReportService;
    private final Logger logger = LoggerFactory.getLogger(EmployeeDetailsResource.class);
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/employee")
    @ResponseBody
    public List<EmployeeDTO> getAllSimulationModels() {
        logger.info("Employee find all method called");
        List<EmployeeDTO> empDto =  employeeService.findAll();
        return empDto;
    }

//    @PostMapping("/default/simulation-model")
//    @ResponseBody
//    public  String  createDefultSimlationModel() {
//
//        return simulationModelService.createDefaultSimulationModel();
//    }
}
