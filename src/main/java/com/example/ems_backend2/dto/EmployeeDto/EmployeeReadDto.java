package com.example.ems_backend2.dto.EmployeeDto;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeReadDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer departmentId;
}
