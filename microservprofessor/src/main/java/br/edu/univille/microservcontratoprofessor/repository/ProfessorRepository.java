package br.edu.univille.microservcontratoprofessor.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.univille.microservcontratoprofessor.entity.Professor;

@Repository
public interface ProfessorRepository 
    extends CrudRepository<Professor,String>{
    
}
