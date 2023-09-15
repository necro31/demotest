package com.albert.demotest.dto;

import com.albert.demotest.enums.Grade;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
public class CreateOrUpdateEmployee {
    @NotEmpty
    private String name;
    @NonNull
    private Long salary;
    @NotNull
    private Grade grade;
}
