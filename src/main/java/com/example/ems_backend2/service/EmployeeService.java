package com.example.ems_backend2.service;

import com.example.ems_backend2.Entity.Employee;
import com.example.ems_backend2.Exception.EmailAlreadyExist;
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
    @Autowired
    private DtoService dtoService;

    public Employee create(EmployeeCreateDto employeeCreateDto) throws NotFoundException, EmailAlreadyExist {
        if(employeeRepository.findByEmail(employeeCreateDto.getEmail()) == null){
            return employeeRepository.save(employeeConverter.convert(employeeCreateDto));
        }
        throw new EmailAlreadyExist();
    }

    public Employee update(EmployeeCreateDto employeeCreateDto) throws NotFoundException, EmailAlreadyExist {
        String employeeEmail = dtoService.findEmployeetById(employeeCreateDto.getId()).getEmail();
        Employee employee = employeeConverter.convert(employeeCreateDto);
        if(employeeRepository.findByEmail(employee.getEmail()) == null || employeeEmail.equals(employee.getEmail())){
            return employeeRepository.save(employee);
        }
        throw new EmailAlreadyExist();
    }

    public boolean delete(int id) throws NotFoundException {
        employeeRepository.delete(dtoService.findEmployeetById(id));
        return true;
    }

    public EmployeeReadDto findById(int id) throws NotFoundException {
        return employeeDtoConverter.convert(dtoService.findEmployeetById(id));
    }

    public List<EmployeeReadDto> findAll() {
        List<EmployeeReadDto> employeeReadDtos = new ArrayList<>();
        for (Employee employee : employeeRepository.findAll()) {
            employeeReadDtos.add(employeeDtoConverter.convert(employee));
        }
        return employeeReadDtos;
    }

}
