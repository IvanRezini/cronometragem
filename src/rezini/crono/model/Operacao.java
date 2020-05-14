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
public class Operacao {
    private int codOperacao;
    private String nomeOperacao;
    private String nomeProduto;
    private String descOperacao;
    private String createOperacao;
    private int codProduto;
    private int statusOperacao; //"1" operação sem elementos "0" operação com elementos cadastrados

    public int getCodOperacao() {
        return codOperacao;
    }

    public void setCodOperacao(int codOperacao) {
        this.codOperacao = codOperacao;
    }

    public String getNomeOperacao() {
        return nomeOperacao;
    }

    public void setNomeOperacao(String nomeOperacao) {
        this.nomeOperacao = nomeOperacao;
    }

    public String getDescOperacao() {
        return descOperacao;
    }

    public void setDescOperacao(String descOperacao) {
        this.descOperacao = descOperacao;
    }

    public String getCreateOperacao() {
        return createOperacao;
    }

    public void setCreateOperacao(String createOperacao) {
        this.createOperacao = createOperacao;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public int getStatusOperacao() {
        return statusOperacao;
    }

    public void setStatusOperacao(int statusOperacao) {
        this.statusOperacao = statusOperacao;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
}
