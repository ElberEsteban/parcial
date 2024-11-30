package com.udea.parcial.controller;

import com.udea.parcial.exception.ModelNotFoundException;
import com.udea.parcial.model.Ciudad;
import com.udea.parcial.service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ciudad")
@CrossOrigin("*")
public class CiudadController {
    @Autowired
    private CiudadService ciudadService;

    @PostMapping("/save")
    public ResponseEntity<Ciudad> save(@RequestBody Ciudad ciudad) {
        Ciudad savedCiudad = ciudadService.save(ciudad);
        return new ResponseEntity<>(savedCiudad, HttpStatus.CREATED);
    }

    @GetMapping("/find")
    public ResponseEntity<Ciudad> findByPaisAndCiudad(@RequestParam String pais, @RequestParam String nombreCiudad) {
        return ciudadService.findByPaisAndCiudad(pais, nombreCiudad)
                .map(ciudad -> new ResponseEntity<>(ciudad, HttpStatus.OK))
                .orElseThrow(() -> new ModelNotFoundException("Ciudad no encontrada para el país: " + pais + " y ciudad: " + nombreCiudad));
    }
}