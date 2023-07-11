package com.example.ems_backend2.dto.DepartementDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartementReadDto {
    private Integer id;
    private String departmentName;
    private String departmentDescription;
}
