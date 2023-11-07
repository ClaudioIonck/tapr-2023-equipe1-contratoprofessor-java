package br.edu.univille.microservcontratoprofessor.service;

import java.util.List;

import br.edu.univille.microservcontratoprofessor.entity.Contrato;

public interface ContratoService {
    public List<Contrato> getAll();
    public Contrato save(Contrato contrato);
    public void delete(Contrato contrato);
    public Contrato update(Contrato contrato);
}