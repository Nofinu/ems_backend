package com.example.ems_backend2.repository;

import com.example.ems_backend2.Entity.Departement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository extends CrudRepository<Departement,Integer> {
}
