package br.edu.univille.microservcontratoprofessor.service.impl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.univille.microservcontratoprofessor.entity.Contrato;
import br.edu.univille.microservcontratoprofessor.repository.ContratoRepository;
import br.edu.univille.microservcontratoprofessor.service.ContratoService;

@Service
public class ContratoServiceImpl implements ContratoService{

    @Autowired
    private ContratoRepository repository;

    @Override
    public List<Contrato> getAll() {

        var interador = repository.findAll();
        List<Contrato> ListaContratos = new ArrayList<>();
        interador.forEach(ListaContratos::add);
        return ListaContratos;
    }

    @Override
    public Contrato getById(String id) {

        var contrato = repository.findById(id);
        if(contrato.isPresent()){
            return contrato.get();
        }
        return null;
    }

    @Override
    public Contrato saveNew(Contrato contrato) {
        contrato.setId(null);
        return repository.save(contrato);
    }

    @Override
    public Contrato update(String id, Contrato contrato) {
        var buscaContratoAntigo = repository.findById(id);
        if (buscaContratoAntigo.isPresent()){
            var contratoAntigo = buscaContratoAntigo.get();

            // Atualiza cada atributo do contrato antigo com os valores do contrato novo
            contratoAntigo.setNumeroContrato(contrato.getNumeroContrato());

            return repository.save(contratoAntigo);
        }
        return null;
    }

    @Override
    public Contrato delete(String id) {
        var buscarContrato = repository.findById(id);
        if (buscarContrato.isPresent()){
            var contrato = buscarContrato.get();
            repository.delete(contrato);
            return contrato;
        }
        return null;
    }
}
