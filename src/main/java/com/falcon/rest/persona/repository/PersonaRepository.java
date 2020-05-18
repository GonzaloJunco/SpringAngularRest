package com.falcon.rest.persona.repository;

import com.falcon.rest.persona.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    @Query("select p from Persona p where p.nombres like %?1%")
    public List<Persona> findByNombres(String nombres);
}
