package com.example.ems_backend2.dto.DepartementDto;

import com.example.ems_backend2.Entity.Departement;
import org.springframework.stereotype.Component;

@Component
public class DepartementToDepartementDto {

    public DepartementReadDto converte(Departement departement) {
        DepartementReadDto departementReadDto = new DepartementReadDto();
        departementReadDto.setId(departement.getId());
        departementReadDto.setDepartmentName(departement.getName());
        departementReadDto.setDepartmentDescription(departement.getDescription());
        return departementReadDto;
    }
}
