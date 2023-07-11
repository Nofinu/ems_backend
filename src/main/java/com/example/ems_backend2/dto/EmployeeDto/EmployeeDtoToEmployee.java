package com.example.ems_backend2.dto.EmployeeDto;

import com.example.ems_backend2.Entity.Departement;
import com.example.ems_backend2.Entity.Employee;
import com.example.ems_backend2.Exception.NotFoundException;
import com.example.ems_backend2.dto.DepartementDto.DepartementCreateDto;
import com.example.ems_backend2.service.DtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDtoToEmployee {
    @Autowired
    private DtoService dtoService;

    public Employee convert(EmployeeCreateDto employeeCreateDto) throws NotFoundException {
        Employee employee = employeeCreateDto.getId() != null ? dtoService.findEmployeetById(employeeCreateDto.getId()) : new Employee();
        employee.setEmail(employeeCreateDto.getEmail());
        employee.setFirstname(employeeCreateDto.getFirstName());
        employee.setLastname(employeeCreateDto.getLastName());
        employee.setDepartement(dtoService.findDepartById(employeeCreateDto.getDepartmentId()));
        return employee;
    }
}
