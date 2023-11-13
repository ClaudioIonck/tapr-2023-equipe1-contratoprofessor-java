package br.edu.univille.microservcontratoprofessor.entity;
import java.sql.Date;
import org.springframework.data.annotation.Id;
import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

@Container(containerName = "Contrato")

public class Contrato {
    @Id
    @GeneratedValue
    public String id;
    @PartitionKey
    public int numeroContrato;
    
    public Date dataInicio;
    public Date dataValidade;
    public int valor;
    public String contratante;
    public String contratado;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getNumeroContrato() {
        return numeroContrato;
    }
    public void setNumeroContrato(int numeroContrato) {
        this.numeroContrato = numeroContrato;
    }
    public Date getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }
        public Date getDataValidade() {
        return dataValidade;
    }
    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }
        public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
        public String getContratante() {
        return contratante;
    }
    public void setContratante(String contratante) {
        this.contratante = contratante;
    }

    public String getContratado() {
        return contratado;
    }
    public void setContratado(String contratado) {
        this.contratado = contratado;
    }

}