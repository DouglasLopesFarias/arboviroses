package br.uninga.model;

import java.util.Objects;

public class TipoDeImovel {

    private String id;
    private String sigla;
    private String descricao;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoDeImovel() {
    }

    public TipoDeImovel(String id, String sigla, String descricao) {
        this.id = id;
        this.sigla = sigla;
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoDeImovel that = (TipoDeImovel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TipoDeImovel{" +
                "id='" + id + '\'' +
                ", sigla='" + sigla + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}

