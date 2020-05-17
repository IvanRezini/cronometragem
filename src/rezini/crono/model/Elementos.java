/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rezini.crono.model;

/**
 *
 * @author ivan rezini
 */
public class Elementos {
    private String nomeElemento;
    private float ritmoElemento;
    private float interferenciaElemento;
    private float concessaoElemento;
    private int totalDePecas;
    private int codOperacao;

    public String getNomeElemento() {
        return nomeElemento;
    }

    public void setNomeElemento(String nomeElemento) {
        this.nomeElemento = nomeElemento;
    }

    public float getRitmoElemento() {
        return ritmoElemento;
    }

    public void setRitmoElemento(float ritmoElemento) {
        this.ritmoElemento = ritmoElemento;
    }

    public float getInterferenciaElemento() {
        return interferenciaElemento;
    }

    public void setInterferenciaElemento(float interverenciaElemento) {
        this.interferenciaElemento = interverenciaElemento;
    }

    public float getConcessaoElemento() {
        return concessaoElemento;
    }

    public void setConcessaoElemento(float concessaoElemento) {
        this.concessaoElemento = concessaoElemento;
    }

    public int getTotalDePecas() {
        return totalDePecas;
    }

    public void setTotalDePecas(int totalDePecas) {
        this.totalDePecas = totalDePecas;
    }

    public int getCodOperacao() {
        return codOperacao;
    }

    public void setCodOperacao(int codOperacao) {
        this.codOperacao = codOperacao;
    }
    
}
