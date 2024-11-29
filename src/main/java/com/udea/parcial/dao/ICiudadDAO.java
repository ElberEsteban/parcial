package com.udea.parcial.dao;

import com.udea.parcial.model.Ciudad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICiudadDAO extends CrudRepository<Ciudad, Long> {

    // Método para buscar ciudades por país
    public List<Ciudad> findCiudadesByPais(String pais);
}