package com.example.ems_backend2.dto.DepartementDto;

import com.example.ems_backend2.Entity.Departement;
import com.example.ems_backend2.Exception.NotFoundException;
import com.example.ems_backend2.service.DtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepartementDtoToDepartement {
    @Autowired
    private DtoService dtoService;

    public Departement convert(DepartementCreateDto departementCreateDto) throws NotFoundException {
        Departement departement = departementCreateDto.getId() != null ? dtoService.findDepartById(departementCreateDto.getId()) : new Departement();
        departement.setDescription(departementCreateDto.getDepartmentDescription());
        departement.setName(departementCreateDto.getDepartmentName());
        return departement;
    }
}
