package com.udea.parcial.controller;

import com.udea.parcial.exception.ModelNotFoundException;
import com.udea.parcial.model.Ciudad;
import com.udea.parcial.service.CiudadService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/ciudad")
@CrossOrigin("*")
public class CiudadController {

    @Autowired
    private CiudadService ciudadService;

    @PostMapping("/save")
    public Long save(@RequestBody Ciudad ciudad) {
        ciudadService.save(ciudad);
        return ciudad.getIdCiudad();
    }

    @GetMapping("/listAll")
    public Iterable<Ciudad> listAllCiudades() {
        return ciudadService.list();
    }

    @GetMapping("/list/{id}")
    public Ciudad listCiudadById(@PathVariable("id") Long id) {
        Optional<Ciudad> ciudad = ciudadService.listById(id);
        if (ciudad.isPresent()) {
            return ciudad.get();
        }
        throw new ModelNotFoundException("Id de ciudad inválido");
    }

    @GetMapping("/byPais/{pais}")
    public List<Ciudad> findCiudadesByPais(@PathVariable("pais") String pais) {
        return ciudadService.findByPais(pais);
    }

    @PutMapping("/update")
    public Ciudad update(@RequestBody Ciudad ciudad) {
        return ciudadService.update(ciudad);
    }

    @DeleteMapping("/{id}")
    public String deleteCiudad(@PathVariable Long id) {
        return ciudadService.delete(id);
    }
}