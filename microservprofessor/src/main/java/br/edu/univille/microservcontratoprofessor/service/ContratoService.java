package br.edu.univille.microservcontratoprofessor.service;
import java.util.List;
import br.edu.univille.microservcontratoprofessor.entity.Contrato;

public interface ContratoService {
    public List<Contrato> getAll();
    public Contrato getById(String id);
    public Contrato saveNew(Contrato contrato);
    public Contrato update(String id, Contrato contrato);
    public Contrato delete(String id);
}