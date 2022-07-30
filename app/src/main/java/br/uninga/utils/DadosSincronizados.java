package br.uninga.utils;

import java.util.List;

public class DadosSincronizados {

    private String status;
    private String totalSincronizados;
    private String totalErros;
    private List lista;

    public DadosSincronizados() {
    }

    public DadosSincronizados(String status, String totalSincronizados, String totalErros) {
        this.status = status;
        this.totalSincronizados = totalSincronizados;
        this.totalErros = totalErros;
    }

    public DadosSincronizados(String status, String totalSincronizados, String totalErros, List lista) {
        this.status = status;
        this.totalSincronizados = totalSincronizados;
        this.totalErros = totalErros;
        this.lista = lista;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalSincronizados() {
        return totalSincronizados;
    }

    public void setTotalSincronizados(String totalSincronizados) {
        this.totalSincronizados = totalSincronizados;
    }

    public String getTotalErros() {
        return totalErros;
    }

    public void setTotalErros(String totalErros) {
        this.totalErros = totalErros;
    }

    public List getLista() {
        return lista;
    }

    public void setLista(List lista) {
        this.lista = lista;
    }

    @Override
    public String toString() {
        return "DadosSincronizados{" +
                "status='" + status + '\'' +
                ", totalSincronizados='" + totalSincronizados + '\'' +
                ", totalErros='" + totalErros + '\'' +
                '}';
    }
}
