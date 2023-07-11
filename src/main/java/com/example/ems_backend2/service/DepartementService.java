package com.example.ems_backend2.service;

import com.example.ems_backend2.Entity.Departement;
import com.example.ems_backend2.Exception.NotFoundException;
import com.example.ems_backend2.dto.DepartementDto.DepartementCreateDto;
import com.example.ems_backend2.dto.DepartementDto.DepartementDtoToDepartement;
import com.example.ems_backend2.dto.DepartementDto.DepartementReadDto;
import com.example.ems_backend2.dto.DepartementDto.DepartementToDepartementDto;
import com.example.ems_backend2.repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartementService {
    @Autowired
    private DepartementRepository departementRepository;
    @Autowired
    private DepartementDtoToDepartement departementConverter;
    @Autowired
    private DepartementToDepartementDto departementDtoConverter;

    public Departement create (DepartementCreateDto departementCreateDto) throws NotFoundException {
        return departementRepository.save(departementConverter.convert(departementCreateDto));
    }

    public boolean delete (int id) throws NotFoundException {
        Optional<Departement> departement = departementRepository.findById(id);
        if(departement.isPresent()){
            departementRepository.delete(departement.get());
            return true;
        }
        throw new NotFoundException();
    }

    public List<DepartementReadDto> getAll (){
        List<DepartementReadDto> departementReadDtos = new ArrayList<>();
        for (Departement d:departementRepository.findAll()) {
            departementReadDtos.add(departementDtoConverter.converte(d));
        }
        return departementReadDtos;
    }

    public DepartementReadDto findById(int id) throws NotFoundException {
        Optional<Departement> departement = departementRepository.findById(id);
        if(departement.isPresent()){
            return departementDtoConverter.converte(departement.get());
        }
        throw new NotFoundException();
    }


}
