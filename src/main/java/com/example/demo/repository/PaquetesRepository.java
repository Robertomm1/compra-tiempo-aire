package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Paquetes;



@Repository
public interface PaquetesRepository extends CrudRepository<Paquetes, String>{

}
