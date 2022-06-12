package br.uninga.model;

import java.util.Objects;

public class Localidade {
    private String id;
    private String descricao;
    private String categoria;
    private String zona;
    private String extrato;

    public Localidade() {
    }

    public Localidade(String id, String descricao, String categoria, String zona, String extrato) {
        this.id = id;
        this.descricao = descricao;
        this.categoria = categoria;
        this.zona = zona;
        this.extrato = extrato;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getExtrato() {
        return extrato;
    }

    public void setExtrato(String extrato) {
        this.extrato = extrato;
    }

    @Override
    public String toString() {
        return "Localidade{" +
                "id='" + id + '\'' +
                ", descricao='" + descricao + '\'' +
                ", categoria='" + categoria + '\'' +
                ", zona='" + zona + '\'' +
                ", extrato='" + extrato + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Localidade that = (Localidade) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
