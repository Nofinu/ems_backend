package com.example.ems_backend2.dto.EmployeeDto;

import com.example.ems_backend2.Entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeToEmployeeDto {
    public EmployeeReadDto convert(Employee employee) {
        EmployeeReadDto employeeReadDto = new EmployeeReadDto();
        employeeReadDto.setId(employee.getId());
        employeeReadDto.setEmail(employee.getEmail());
        employeeReadDto.setLastName(employee.getLastname());
        employeeReadDto.setFirstName(employee.getFirstname());
        employeeReadDto.setDepartmentId(employee.getDepartement().getId());
        return employeeReadDto;
    }
}
