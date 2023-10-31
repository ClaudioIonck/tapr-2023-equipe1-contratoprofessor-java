package br.edu.univille.microservcontratoprofessor.service.impl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.univille.microservcontratoprofessor.entity.Contrato;
import br.edu.univille.microservcontratoprofessor.repositorio.ContratoRepository;
import br.edu.univille.microservcontratoprofessor.service.ContratoService;


@Service
public class ContratoServiveImpl implements ContratoService{

    @Autowired
    private ContratoRepository repository;

    @Override
    public List<Contrato> getAll() {
        var interador = repository.findAll();
        List<Contrato> ListaContratos = new ArrayList<>();

        interador.forEach(ListaContratos::add);

        return ListaContratos;
    }
    
}
