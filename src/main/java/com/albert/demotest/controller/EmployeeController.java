package com.albert.demotest.controller;

import com.albert.demotest.dto.CreateOrUpdateEmployee;
import com.albert.demotest.dto.EmployeeDTO;
import com.albert.demotest.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gradle/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

//    @Autowired
//    public EmployeeController(EmployeeService employeeService) {
//        this.employeeService = employeeService;
//    }

    @PostMapping("/create")
    public EmployeeDTO createNewEmployee(@RequestBody CreateOrUpdateEmployee createOrUpdateEmployee) {
        return employeeService.createNewEmployee(createOrUpdateEmployee);
    }

    @PutMapping("/update/{id}")
    public EmployeeDTO updateEmployeeById(@PathVariable Long id, @RequestBody CreateOrUpdateEmployee createOrUpdateEmployee) {
        return employeeService.updateEmployee(id, createOrUpdateEmployee);
    }

    @GetMapping("/get-all")
    public List<EmployeeDTO> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @DeleteMapping("/delete-bulk")
    public void deleteBulkData (@RequestBody List<Long> ids )
    {
        employeeService.deleteBulkData(ids);
    }


}
