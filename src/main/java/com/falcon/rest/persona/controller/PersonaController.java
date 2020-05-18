package com.falcon.rest.persona.controller;

import com.falcon.rest.persona.model.Persona;
import com.falcon.rest.persona.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping(value = "/per")
public class PersonaController {
    @Autowired
    private PersonaService service;

    @GetMapping("/persona")
    public ResponseEntity<?> lista(){
        return new ResponseEntity<List<Persona>>(service.lista(), HttpStatus.OK);
    }

    @GetMapping("/persona/{id}")
    public ResponseEntity<?> buscarId(@PathVariable Long id){
        Persona personaBD = service.findById(id);
        return new ResponseEntity<Persona>(personaBD, HttpStatus.OK);
    }

    @GetMapping("/persona/buscar-nombres/{nombres}")
    public ResponseEntity<?> buscarNombre(@PathVariable String nombres){
        List<Persona> personaBD = service.findByNombres(nombres);
        return new ResponseEntity<List<Persona>>(personaBD, HttpStatus.OK);
    }

    @PostMapping("/persona")
    public ResponseEntity<?> crear(@RequestBody Persona persona){
        Persona personaNew = service.crear(persona);
//        return ResponseEntity.status(HttpStatus.CREATED).body(personaNew);
        return new ResponseEntity<Persona>(personaNew, HttpStatus.CREATED);
    }

    @PutMapping("/persona/{id}")
    public ResponseEntity<?> actualizar(@RequestBody Persona persona, @PathVariable Long id){
        Persona personaBD = service.findById(id);
        personaBD.setNombres(persona.getNombres());
        personaBD.setApellidos(persona.getApellidos());
        Persona personaNew = service.crear(personaBD);
        return new ResponseEntity<Persona>(personaNew, HttpStatus.CREATED);
    }

    @DeleteMapping("/persona/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Map<String, Object> mensaje = new HashMap<>();
        service.eliminar(id);
        mensaje.put("mensaje","Eliminacion Exitosa!");
        return new ResponseEntity<Map<String, Object>>(mensaje, HttpStatus.OK);
    }
}
