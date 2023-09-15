package com.albert.demotest.controller;

import com.albert.demotest.dto.CreateOrUpdateEmployee;
import com.albert.demotest.dto.EmployeeDTO;
import com.albert.demotest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody CreateOrUpdateEmployee createOrUpdateEmployee) {
        return employeeService.createNewEmployee(createOrUpdateEmployee);
    }

    @PutMapping("/{id}")
    public EmployeeDTO updateEmployeeById(@PathVariable Long id, @RequestBody CreateOrUpdateEmployee createOrUpdateEmployee) {
        return employeeService.updateEmployee(id, createOrUpdateEmployee);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

}
