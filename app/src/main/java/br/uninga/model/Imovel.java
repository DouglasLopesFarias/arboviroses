package br.uninga.model;

import java.util.Objects;

public class Imovel {

    private String id;
    private String localidade;
    private String quarteirao;
    private String logradouro;
    private String numero;
    private String bairro;
    private String tipoImovel;
    private String complemento;
    private String sequencia;
    private String telefoneResidencial;
    private String telefoneRecado;
    private String observacao;

    public Imovel() {
    }

    public Imovel(String id, String localidade, String quarteirao, String logradouro, String numero, String bairro, String tipoImovel, String complemento, String sequencia, String telefoneResidencial, String telefoneRecado, String observacao) {
        this.id = id;
        this.localidade = localidade;
        this.quarteirao = quarteirao;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.tipoImovel = tipoImovel;
        this.complemento = complemento;
        this.sequencia = sequencia;
        this.telefoneResidencial = telefoneResidencial;
        this.telefoneRecado = telefoneRecado;
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

    public String getQuarteirao() {
        return quarteirao;
    }

    public void setQuarteirao(String quarteirao) {
        this.quarteirao = quarteirao;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTipoImovel() {
        return tipoImovel;
    }

    public void setTipoImovel(String tipoImovel) {
        this.tipoImovel = tipoImovel;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getSequencia() {
        return sequencia;
    }

    public void setSequencia(String sequencia) {
        this.sequencia = sequencia;
    }

    public String getTelefoneResidencial() {
        return telefoneResidencial;
    }

    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    public String getTelefoneRecado() {
        return telefoneRecado;
    }

    public void setTelefoneRecado(String telefoneRecado) {
        this.telefoneRecado = telefoneRecado;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return "Imovel{" +
                "id='" + id + '\'' +
                ", localidade='" + localidade + '\'' +
                ", quarteirao='" + quarteirao + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", numero='" + numero + '\'' +
                ", bairro='" + bairro + '\'' +
                ", tipoImovel='" + tipoImovel + '\'' +
                ", complemento='" + complemento + '\'' +
                ", sequencia='" + sequencia + '\'' +
                ", telefoneResidencial='" + telefoneResidencial + '\'' +
                ", telefoneRecado='" + telefoneRecado + '\'' +
                ", observacao='" + observacao + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Imovel that = (Imovel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
