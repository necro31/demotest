package com.albert.demotest.dto;

import com.albert.demotest.enums.Grade;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class EmployeeDTO {
    private Long id;
    private String createdAt;
    private String updatedAt;
    private String name;
    private Long salary;
    private Grade grade;
    private Long salaryWithBonus;
}
