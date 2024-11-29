package com.udea.parcial.service;

import com.udea.parcial.dao.IClimaDAO;
import com.udea.parcial.exception.ClimaNotFoundException;
import com.udea.parcial.model.Clima;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClimaService {

    @Autowired
    private IClimaDAO climaDAO;

    public Clima save(Clima clima) {
        return climaDAO.save(clima);
    }

    public List<Clima> findClimasByRating(int rating) {
        List<Clima> climas = climaDAO.findClimasByRating(rating);
        if (climas.isEmpty()) {
            throw new ClimaNotFoundException("No se encontraron climas con rating mayor o igual a " + rating);
        }
        return climas;
    }

    public Iterable<Clima> listAll() {
        return climaDAO.findAll();
    }

    public Clima update(Clima clima) {
        return climaDAO.save(clima);
    }

    public String delete(long id) {
        climaDAO.deleteById(id);
        return "Clima eliminado";
    }

    public Clima findById(long id) {
        return climaDAO.findById(id).orElseThrow(() -> new ClimaNotFoundException("Clima no encontrado"));
    }
}