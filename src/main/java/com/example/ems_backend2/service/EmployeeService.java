package com.example.ems_backend2.service;

import com.example.ems_backend2.Entity.Employee;
import com.example.ems_backend2.Exception.NotFoundException;
import com.example.ems_backend2.dto.EmployeeDto.EmployeeCreateDto;
import com.example.ems_backend2.dto.EmployeeDto.EmployeeDtoToEmployee;
import com.example.ems_backend2.dto.EmployeeDto.EmployeeReadDto;
import com.example.ems_backend2.dto.EmployeeDto.EmployeeToEmployeeDto;
import com.example.ems_backend2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeDtoToEmployee employeeConverter;
    @Autowired
    private EmployeeToEmployeeDto employeeDtoConverter;

    public Employee create (EmployeeCreateDto employeeCreateDto) throws NotFoundException {
        return employeeRepository.save(employeeConverter.convert(employeeCreateDto));
    }

    public boolean delete (int id) throws NotFoundException {
        Employee employee = findByIdEmployee(id);
        employeeRepository.delete(employee);
        return true;
    }

    public EmployeeReadDto findById(int id) throws NotFoundException {
        return employeeDtoConverter.convert(findByIdEmployee(id));
    }

    public Employee findByIdEmployee(int id) throws NotFoundException {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        throw new NotFoundException();
    }

    public List<EmployeeReadDto> findAll (){
        List<EmployeeReadDto> employeeReadDtos = new ArrayList<>();
        for (Employee employee:employeeRepository.findAll()) {
            employeeReadDtos.add(employeeDtoConverter.convert(employee));
        }
        return employeeReadDtos;
    }
}
