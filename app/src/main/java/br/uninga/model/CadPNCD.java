package br.uninga.model;

import java.util.Objects;

public class CadPNCD {

    private String id;
    private String data;
    private String hora;
    private String a1;
    private String a2;
    private String b;
    private String c;
    private String d1;
    private String d2;
    private String e;
    private String tipo01;
    private String quantidade01;
    private String tipo02;
    private String quantidade02;
    private String tipodeImovel;
    private String numero;
    private String complemento;
    private String sequencia;
    private String numerodeMoradores;
    private String telefoneResidencial;
    private String telefoneRecado;
    private String nomeMorador;
    private String cpf;
    private String dataNascimento;
    private String numerodoCartaoSus;

    public CadPNCD() {
    }

    public CadPNCD(String id, String data, String hora, String a1, String a2, String b, String c, String d1, String d2, String e, String tipo01, String quantidade01, String tipo02, String quantidade02, String tipodeImovel, String numero, String complemento, String sequencia, String numerodeMoradores, String telefoneResidencial, String telefoneRecado, String nomeMorador, String cpf, String dataNascimento, String numerodoCartaoSus) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.a1 = a1;
        this.a2 = a2;
        this.b = b;
        this.c = c;
        this.d1 = d1;
        this.d2 = d2;
        this.e = e;
        this.tipo01 = tipo01;
        this.quantidade01 = quantidade01;
        this.tipo02 = tipo02;
        this.quantidade02 = quantidade02;
        this.tipodeImovel = tipodeImovel;
        this.numero = numero;
        this.complemento = complemento;
        this.sequencia = sequencia;
        this.numerodeMoradores = numerodeMoradores;
        this.telefoneResidencial = telefoneResidencial;
        this.telefoneRecado = telefoneRecado;
        this.nomeMorador = nomeMorador;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.numerodoCartaoSus = numerodoCartaoSus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD1() {
        return d1;
    }

    public void setD1(String d1) {
        this.d1 = d1;
    }

    public String getD2() {
        return d2;
    }

    public void setD2(String d2) {
        this.d2 = d2;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public String getTipo01() {
        return tipo01;
    }

    public void setTipo01(String tipo01) {
        this.tipo01 = tipo01;
    }

    public String getQuantidade01() {
        return quantidade01;
    }

    public void setQuantidade01(String quantidade01) {
        this.quantidade01 = quantidade01;
    }

    public String getTipo02() {
        return tipo02;
    }

    public void setTipo02(String tipo02) {
        this.tipo02 = tipo02;
    }

    public String getQuantidade02() {
        return quantidade02;
    }

    public void setQuantidade02(String quantidade02) {
        this.quantidade02 = quantidade02;
    }

    public String getTipodeImovel() {
        return tipodeImovel;
    }

    public void setTipodeImovel(String tipodeImovel) {
        this.tipodeImovel = tipodeImovel;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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

    public String getNumerodeMoradores() {
        return numerodeMoradores;
    }

    public void setNumerodeMoradores(String numerodeMoradores) {
        this.numerodeMoradores = numerodeMoradores;
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

    public String getNomeMorador() {
        return nomeMorador;
    }

    public void setNomeMorador(String nomeMorador) {
        this.nomeMorador = nomeMorador;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNumerodoCartaoSus() {
        return numerodoCartaoSus;
    }

    public void setNumerodoCartaoSus(String numerodoCartaoSus) {
        this.numerodoCartaoSus = numerodoCartaoSus;
    }

    @Override
    public String toString() {
        return "CadPNCD{" +
                "id='" + id + '\'' +
                ", data='" + data + '\'' +
                ", hora='" + hora + '\'' +
                ", a1='" + a1 + '\'' +
                ", a2='" + a2 + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d1='" + d1 + '\'' +
                ", d2='" + d2 + '\'' +
                ", e='" + e + '\'' +
                ", tipo01='" + tipo01 + '\'' +
                ", quantidade01='" + quantidade01 + '\'' +
                ", tipo02='" + tipo02 + '\'' +
                ", quantidade02='" + quantidade02 + '\'' +
                ", tipodeImovel='" + tipodeImovel + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", sequencia='" + sequencia + '\'' +
                ", numerodeMoradores='" + numerodeMoradores + '\'' +
                ", telefoneResidencial='" + telefoneResidencial + '\'' +
                ", telefoneRecado='" + telefoneRecado + '\'' +
                ", nomeMorador='" + nomeMorador + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", numerodoCartaoSus='" + numerodoCartaoSus + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        return ((CadPNCD)o).id==this.id;
    }
}
