package com.udea.parcial.service;

import com.udea.parcial.dao.ICiudadDAO;
import com.udea.parcial.model.Ciudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CiudadService {
    @Autowired
    private ICiudadDAO dao;

    public Ciudad save(Ciudad ciudad) {
        return dao.save(ciudad);
    }

    public Optional<Ciudad> findByPaisAndCiudad(String pais, String ciudad) {
        return dao.findByPaisAndCiudad(pais, ciudad);
    }
}