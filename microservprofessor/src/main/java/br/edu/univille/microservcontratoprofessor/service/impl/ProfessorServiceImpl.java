package br.edu.univille.microservcontratoprofessor.service.impl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.univille.microservcontratoprofessor.entity.Professor;
import br.edu.univille.microservcontratoprofessor.repository.ProfessorRepository;
import br.edu.univille.microservcontratoprofessor.service.ProfessorService;


@Service
public class ProfessorServiceImpl implements ProfessorService{

    @Autowired
    private ProfessorRepository repository;

    @Override
    public List<Professor> getAll() {

        var interador = repository.findAll();
        List<Professor> ListaProfessores = new ArrayList<>();
        interador.forEach(ListaProfessores::add);
        return ListaProfessores;
    }

    @Override
    public Professor getById(String id) {

        var professor = repository.findById(id);
        if(professor.isPresent()){
            return professor.get();
        }
        return null;
    }

    @Override
    public Professor saveNew(Professor professor) {
        professor.setId(null);
        return repository.save(professor);
    }

    @Override
    public Professor update(String id, Professor professor) {
        var buscaProfessorAntigo = repository.findById(id);
        if (buscaProfessorAntigo.isPresent()){
            var professorAntigo = buscaProfessorAntigo.get();

            // Atualiza cada atributo do Professor antigo com os valores do Professor novo
            professorAntigo.setNome(professor.getNome());
            professorAntigo.setCurso(professor.getCurso());
            professorAntigo.setCursoId(professor.getCursoId());
            professorAntigo.setTurma(professor.getTurma());
            professorAntigo.setSexo(professor.getSexo());
            professorAntigo.setTelefone(professor.getTelefone());
            professorAntigo.setIdade(professor.getIdade());

            return repository.save(professorAntigo);
        }
        return null;
    }

    @Override
    public Professor delete(String id) {
        var buscarProfessor = repository.findById(id);
        if (buscarProfessor.isPresent()){
            var professor = buscarProfessor.get();
            repository.delete(professor);
            return professor;
        }
        return null;
    }

    @Override
    public Professor update(Professor professor) {
        return repository.save(professor);
    }
}
