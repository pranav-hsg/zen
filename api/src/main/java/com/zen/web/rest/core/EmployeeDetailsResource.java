package com.zen.web.rest.core;

import com.zen.services.service.core.EmployeeService;
import com.zen.services.service.core.dto.EmployeeDTO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class EmployeeDetailsResource {


//    @Autowired
//    ECLReportService eclReportService;
    @Autowired
    Logger logger;
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
