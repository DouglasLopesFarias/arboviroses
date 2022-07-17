package br.uninga.model;

import java.util.Objects;

public class QuarteiroesVistoria {
    private String id;
    private String localidade;
    private String numero;
    private String id_agente;
    private String id_quarteirao;
    private String observacao;

    public QuarteiroesVistoria() {
    }

    public QuarteiroesVistoria(String id, String localidade, String numero, String id_agente, String id_quarteirao, String observacao) {
        this.id = id;
        this.localidade = localidade;
        this.numero = numero;
        this.id_agente = id_agente;
        this.id_quarteirao = id_quarteirao;
        this.observacao = observacao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getId_agente() {
        return id_agente;
    }

    public void setId_agente(String id_agente) {
        this.id_agente = id_agente;
    }

    public String getId_quarteirao() {
        return id_quarteirao;
    }

    public void setId_quarteirao(String id_quarteirao) {
        this.id_quarteirao = id_quarteirao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return "QuarteiroesVistoria{" +
                "id='" + id + '\'' +
                ", localidade='" + localidade + '\'' +
                ", numero='" + numero + '\'' +
                ", id_agente='" + id_agente + '\'' +
                ", id_quarteirao='" + id_quarteirao + '\'' +
                ", observacao='" + observacao + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuarteiroesVistoria that = (QuarteiroesVistoria) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
