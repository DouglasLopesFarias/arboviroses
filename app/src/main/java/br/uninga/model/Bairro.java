package br.uninga.model;

public class Bairro {

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

    public Bairro() {
    }

    public Bairro(String id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Bairro{" +
                "id='" + id + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }


}
