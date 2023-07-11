package com.example.ems_backend2.controller;

import com.example.ems_backend2.Entity.Departement;
import com.example.ems_backend2.Entity.Employee;
import com.example.ems_backend2.Exception.NotFoundException;
import com.example.ems_backend2.dto.DepartementDto.DepartementCreateDto;
import com.example.ems_backend2.dto.DepartementDto.DepartementReadDto;
import com.example.ems_backend2.dto.EmployeeDto.EmployeeCreateDto;
import com.example.ems_backend2.service.DepartementService;
import com.example.ems_backend2.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/departments")
public class DepartementController {
    @Autowired
    private DepartementService departementService;

    @PostMapping("")
    public ResponseEntity<Departement> createDepartement(@RequestBody DepartementCreateDto departementCreateDto) throws NotFoundException {
        return new ResponseEntity<>(departementService.create(departementCreateDto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> UpdateDepartement(@PathVariable int id, @RequestBody DepartementCreateDto departementCreateDto) throws NotFoundException {
        departementCreateDto.setId(id);
        if (departementService.create(departementCreateDto) != null) {
            return new ResponseEntity<>("Departement Update", HttpStatus.OK);
        }
        return new ResponseEntity<>("Error During Updtate", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("")
    public ResponseEntity<List<DepartementReadDto>> getAllDepartement() {
        return new ResponseEntity<>(departementService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartementReadDto> getDepartementById(@PathVariable int id) throws NotFoundException {
        return new ResponseEntity<>(departementService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartement(@PathVariable int id) throws NotFoundException {
        if (departementService.delete(id)) {
            return new ResponseEntity<>("Departement Delete", HttpStatus.OK);
        }
        return new ResponseEntity<>("Error during deletion", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
