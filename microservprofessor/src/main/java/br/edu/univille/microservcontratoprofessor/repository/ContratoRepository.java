package br.edu.univille.microservcontratoprofessor.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.univille.microservcontratoprofessor.entity.Contrato;

@Repository
public interface ContratoRepository 
    extends CrudRepository<Contrato,String>{
    
}
