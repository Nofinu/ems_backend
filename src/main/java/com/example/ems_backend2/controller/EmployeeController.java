package com.example.ems_backend2.controller;

import com.example.ems_backend2.Entity.Employee;
import com.example.ems_backend2.Exception.EmailAlreadyExist;
import com.example.ems_backend2.Exception.NotFoundException;
import com.example.ems_backend2.dto.EmployeeDto.EmployeeCreateDto;
import com.example.ems_backend2.dto.EmployeeDto.EmployeeReadDto;
import com.example.ems_backend2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("")
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeCreateDto employeeCreateDto) throws NotFoundException, EmailAlreadyExist {
        return new ResponseEntity<>(employeeService.create(employeeCreateDto), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<EmployeeReadDto>> allEmployee() {
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeReadDto> findByIdEmployee(@PathVariable int id) throws NotFoundException {
        return new ResponseEntity<>(employeeService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) throws NotFoundException {
        if (employeeService.delete(id)) {
            return new ResponseEntity<>("Employee Delete", HttpStatus.OK);
        }
        return new ResponseEntity<>("Error During Deletion", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable int id, @RequestBody EmployeeCreateDto employeeCreateDto) throws NotFoundException, EmailAlreadyExist {
        employeeCreateDto.setId(id);
        if (employeeService.update(employeeCreateDto) != null) {
            return new ResponseEntity<>("Employee Update", HttpStatus.OK);
        }
        return new ResponseEntity<>("Error During Update", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
