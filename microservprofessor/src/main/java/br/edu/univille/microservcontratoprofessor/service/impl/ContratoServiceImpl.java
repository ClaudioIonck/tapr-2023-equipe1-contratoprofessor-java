package br.edu.univille.microservcontratoprofessor.service.impl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import br.edu.univille.microservcontratoprofessor.entity.Contrato;
import br.edu.univille.microservcontratoprofessor.repository.ContratoRepository;
import br.edu.univille.microservcontratoprofessor.service.ContratoService;
import io.dapr.client.DaprClient;
import io.dapr.client.DaprClientBuilder;

@Service
public class ContratoServiceImpl implements ContratoService{

    @Autowired
    private ContratoRepository repository;

    private DaprClient client = new DaprClientBuilder().build();
    @Value("${app.component.topic.contrato}")
    private String TOPIC_NAME;
    @Value("${app.component.service}")
	private String PUBSUB_NAME;

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
        contrato = repository.save(contrato);
        publicarAtualizacao(contrato);
        return contrato;
    }

    @Override
    public Contrato update(String id, Contrato contrato) {
        var buscaContratoAntigo = repository.findById(id);
        if (buscaContratoAntigo.isPresent()){
            var contratoAntigo = buscaContratoAntigo.get();

            // Atualiza cada atributo do contrato antigo com os valores do contrato novo
            contratoAntigo.setNumeroContrato(contrato.getNumeroContrato());
            contratoAntigo = repository.save(contratoAntigo);
            publicarAtualizacao(contratoAntigo);
            return contratoAntigo;
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

    //método privado para publicar a atualização
    private void publicarAtualizacao(Contrato contrato){
        client.publishEvent(
					PUBSUB_NAME,
					TOPIC_NAME,
					contrato).block();
    }
}
