package br.uninga.model;

import java.util.Objects;

public class Logradouro {

    private String id;
    private String descricao;

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

    public Logradouro(String id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Logradouro() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Logradouro that = (Logradouro) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Logradouro{" +
                "id='" + id + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
