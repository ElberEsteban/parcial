package com.udea.parcial.dao;

import com.udea.parcial.model.Ciudad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICiudadDAO extends CrudRepository<Ciudad, Long> {
    Optional<Ciudad> findByPaisAndCiudad(String pais, String ciudad);
}