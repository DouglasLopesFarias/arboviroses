package br.uninga.model;

import java.util.Objects;

public class Agente {

    private String id;
    private String nome;
    private String email;

    public Agente() {
    }

    public Agente(String id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Agente{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agente agente = (Agente) o;
        return id.equals(agente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
