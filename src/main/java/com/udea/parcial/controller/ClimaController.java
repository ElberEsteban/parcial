package com.udea.parcial.controller;

import com.udea.parcial.model.Clima;
import com.udea.parcial.service.ClimaService;
import com.udea.parcial.exception.ClimaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clima")
@CrossOrigin("*")
public class ClimaController {

    @Autowired
    private ClimaService climaService;

    // Método POST para guardar un clima
    @PostMapping("/save")
    public long save(@RequestBody Clima clima) {
        climaService.save(clima);
        return clima.getIdClima();
    }

    // Método GET para obtener todos los climas
    @GetMapping("/listAll")
    public Iterable<Clima> listAllClimas() {
        return climaService.listAll();
    }

    // Método GET para obtener un clima por ID
    @GetMapping("/list/{id}")
    public Clima listClimaById(@PathVariable long id) {
        return climaService.findById(id);
    }

    // Método GET para obtener climas por rating
    @GetMapping("/climasByRating/{rating}")
    public List<Clima> findClimasByRating(@PathVariable int rating) {
        return climaService.findClimasByRating(rating);
    }

    // Método PUT para actualizar un clima
    @PutMapping("/update")
    public Clima update(@RequestBody Clima clima) {
        return climaService.update(clima);
    }

    // Método DELETE para eliminar un clima por ID
    @DeleteMapping("/delete/{id}")
    public String deleteClima(@PathVariable long id) {
        return climaService.delete(id);
    }
}