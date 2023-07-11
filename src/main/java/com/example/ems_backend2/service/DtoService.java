package com.example.ems_backend2.service;


import com.example.ems_backend2.Entity.Departement;
import com.example.ems_backend2.Entity.Employee;
import com.example.ems_backend2.Exception.NotFoundException;
import com.example.ems_backend2.repository.DepartementRepository;
import com.example.ems_backend2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DtoService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartementRepository departementRepository;

    public Departement findDepartById(int id) throws NotFoundException {
        Optional<Departement> departement = departementRepository.findById(id);
        if (departement.isPresent()) {
            return departement.get();
        }
        throw new NotFoundException();
    }

    public Employee findEmployeetById(int id) throws NotFoundException {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        throw new NotFoundException();
    }
}
