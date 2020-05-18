package com.falcon.rest.persona.service;

import com.falcon.rest.persona.model.Persona;
import com.falcon.rest.persona.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaServiceImplement implements PersonaService{
    @Autowired
    private PersonaRepository repository;

    @Override
    @Transactional
    public Persona crear(Persona persona) {
        return repository.save(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Persona> lista() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Persona findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Persona> findByNombres(String nombres) {
        return repository.findByNombres(nombres);
    }
}
