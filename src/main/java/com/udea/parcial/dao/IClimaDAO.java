package com.udea.parcial.dao;

import com.udea.parcial.model.Clima;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClimaDAO extends CrudRepository<Clima, Long> {

    @Query("from Clima c where c.rating >= :rating")
    List<Clima> findClimasByRating(int rating);
}