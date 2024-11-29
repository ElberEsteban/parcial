package com.udea.parcial.service;

import com.udea.parcial.dao.ICiudadDAO;
import com.udea.parcial.exception.CiudadNotFoundException;
import com.udea.parcial.model.Ciudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CiudadService {

    @Autowired
    private ICiudadDAO ciudadDAO;

    // Guardar una nueva ciudad
    public Ciudad save(Ciudad ciudad) {
        return ciudadDAO.save(ciudad);
    }

    // Eliminar una ciudad por ID
    public String delete(Long id) {
        ciudadDAO.deleteById(id);
        return "Ciudad eliminada";
    }

    // Listar todas las ciudades
    public Iterable<Ciudad> list() {
        return ciudadDAO.findAll();
    }

    // Consultar una ciudad por ID
    public Optional<Ciudad> listById(Long id) {
        return ciudadDAO.findById(id);
    }

    // Actualizar una ciudad existente
    public Ciudad update(Ciudad ciudad) {
        Ciudad existingCiudad = ciudadDAO.findById(ciudad.getIdCiudad()).orElse(null);
        if (existingCiudad == null) {
            throw new CiudadNotFoundException("Ciudad no encontrada");
        }

        existingCiudad.setNombre(ciudad.getNombre());
        existingCiudad.setPais(ciudad.getPais());

        return ciudadDAO.save(existingCiudad);
    }

    // Consultar ciudades por país
    public List<Ciudad> findByPais(String pais) {
        List<Ciudad> ciudades = ciudadDAO.findCiudadesByPais(pais);
        if (ciudades.isEmpty()) {
            throw new CiudadNotFoundException("No se encontraron ciudades para el país: " + pais);
        }
        return ciudades;
    }
}