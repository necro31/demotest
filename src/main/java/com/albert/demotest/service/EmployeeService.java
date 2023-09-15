package com.albert.demotest.service;

import com.albert.demotest.dto.CreateOrUpdateEmployee;
import com.albert.demotest.dto.EmployeeDTO;
import com.albert.demotest.entity.MsEmployee;
import com.albert.demotest.enums.Grade;
import com.albert.demotest.repository.MsEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final MsEmployeeRepository msEmployeeRepository;

    // Dependency Injection
    @Autowired
    public EmployeeService(MsEmployeeRepository msEmployeeRepository) {
        this.msEmployeeRepository = msEmployeeRepository;
    }

    public EmployeeDTO createNewEmployee(CreateOrUpdateEmployee createOrUpdateEmployee) {
        // asumsi nama employee boleh duplicate

        final MsEmployee newEmployee = msEmployeeRepository.save(
                new MsEmployee()
                        .setName(createOrUpdateEmployee.getName())
                        .setSalary(createOrUpdateEmployee.getSalary())
                        .setGrade(createOrUpdateEmployee.getGrade())
        );

        return buildData(newEmployee);
    }

    public EmployeeDTO updateEmployee(Long id, CreateOrUpdateEmployee createOrUpdateEmployee) {
        final MsEmployee existingEmployee = msEmployeeRepository.findByDeletedAtIsNullAndId(id)
                .orElseThrow(() -> new RuntimeException("The id was not found"));

        msEmployeeRepository.save(
                existingEmployee
                        .setName(createOrUpdateEmployee.getName())
                        .setSalary(createOrUpdateEmployee.getSalary())
                        .setGrade(createOrUpdateEmployee.getGrade())
        );

        return buildData(existingEmployee);
    }

    public List<EmployeeDTO> getAllEmployee() {
        final List<MsEmployee> allEmployee = msEmployeeRepository.findAllByDeletedAtIsNull();

        return allEmployee.stream().map(this::buildData).collect(Collectors.toList());
    }

    private EmployeeDTO buildData(MsEmployee msEmployee) {
        return new EmployeeDTO()
                .setId(msEmployee.getId())
                .setCreatedAt(msEmployee.getCreatedAt().toString())
                .setUpdatedAt(msEmployee.getUpdatedAt().toString())
                .setName(msEmployee.getName())
                .setSalary(msEmployee.getSalary())
                .setGrade(msEmployee.getGrade())
                .setSalaryWithBonus(Grade.calculateSalaryWithBonusByGrade(msEmployee.getGrade(), msEmployee.getSalary()));
    }
}
