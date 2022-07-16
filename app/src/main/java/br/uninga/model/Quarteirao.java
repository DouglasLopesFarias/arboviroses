package br.uninga.model;

import java.util.Objects;

public class Quarteirao {

    private String id;
    private String localidade;
    private String numero;
    private String observacao;

    public Quarteirao() {
    }

    public Quarteirao(String id, String localidade, String numero, String observacao) {
        this.id = id;
        this.localidade = localidade;
        this.numero = numero;
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return "Quarteirao{" +
                "id='" + id + '\'' +
                ", localidade='" + localidade + '\'' +
                ", numero='" + numero + '\'' +
                ", observacao='" + observacao + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quarteirao that = (Quarteirao) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
