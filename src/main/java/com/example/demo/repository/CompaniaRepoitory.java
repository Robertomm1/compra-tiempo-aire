package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Companias;


@Repository
public interface CompaniaRepoitory extends CrudRepository<Companias, String>{

}
