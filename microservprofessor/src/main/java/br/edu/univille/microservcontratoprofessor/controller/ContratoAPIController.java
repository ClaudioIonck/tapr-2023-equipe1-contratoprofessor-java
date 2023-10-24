package br.edu.univille.microservcontratoprofessor.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import br.edu.univille.microservcontratoprofessor.entity.Contrato;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1/contratos")
public class ContratoAPIController {
    @GetMapping
    public ResponseEntity<List<Contrato>> listarContratos() {
        var listaContratos = new ArrayList<Contrato>();
      
        return new ResponseEntity<List<Contrato>>(listaContratos, HttpStatus.OK);
    }
}
