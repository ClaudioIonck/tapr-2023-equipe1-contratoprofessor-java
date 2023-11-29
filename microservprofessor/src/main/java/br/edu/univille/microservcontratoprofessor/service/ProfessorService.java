package br.edu.univille.microservcontratoprofessor.service;
import java.util.List;
import br.edu.univille.microservcontratoprofessor.entity.Professor;

public interface ProfessorService {
    public List<Professor> getAll();
    public Professor getById(String id);
    public Professor saveNew(Professor professor);
    public Professor update(String id, Professor professor);
    public Professor update(Professor professor);
    public Professor delete(String id);
}