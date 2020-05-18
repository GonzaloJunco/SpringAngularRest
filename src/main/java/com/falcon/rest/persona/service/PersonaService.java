package com.falcon.rest.persona.service;

import com.falcon.rest.persona.model.Persona;

import java.util.List;

public interface PersonaService {
    public Persona crear(Persona persona);
    public List<Persona> lista();
    public Persona findById(Long id);
    public void eliminar(Long id);
    public List<Persona> findByNombres(String nombres);
}
