package br.edu.univille.microservcontratoprofessor.controller;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import br.edu.univille.microservcontratoprofessor.entity.Contrato;
import br.edu.univille.microservcontratoprofessor.service.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1/contratos")
public class ContratoAPIController {
    @Autowired
    private ContratoService service;

    @GetMapping
    public ResponseEntity<List<Contrato>> listarContratos() {

        var listaContratos = service.getAll();
      
        return new ResponseEntity<List<Contrato>>(listaContratos, HttpStatus.OK);
    }
}
