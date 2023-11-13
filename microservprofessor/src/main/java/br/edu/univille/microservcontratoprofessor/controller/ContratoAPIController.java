package br.edu.univille.microservcontratoprofessor.controller;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import br.edu.univille.microservcontratoprofessor.entity.Contrato;
import br.edu.univille.microservcontratoprofessor.service.ContratoService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/api/v1/contratos")
// Test CORS
@CrossOrigin(origins = "*", allowedHeaders = {"Content-Type", "Authorization"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ContratoAPIController {

    @Autowired
    private ContratoService service;

    @GetMapping
    public ResponseEntity<List<Contrato>> listarContratos() {

        var listaContratos = service.getAll();
      
        return new ResponseEntity<List<Contrato>>(listaContratos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrato> buscarContrato(@PathVariable("id") String id) {
        var contrato = service.getById(id);
        if(contrato == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    return new ResponseEntity<Contrato>(contrato, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Contrato> inserirContrato(@RequestBody Contrato contrato){
        if(contrato == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        contrato = service.saveNew(contrato);
        return new ResponseEntity<Contrato>(contrato, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contrato> atualizarContrato(@PathVariable("id") String id, @RequestBody Contrato contrato){
        if(contrato == null || id == "" || id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }    

        contrato = service.update(id, contrato);
        return new ResponseEntity<Contrato>(contrato, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Contrato> removerContrato(@PathVariable("id") String id){
        if(id == "" || id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        var contrato = service.delete(id);
        if(contrato == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Contrato>(contrato, HttpStatus.OK);
    }
    
}
