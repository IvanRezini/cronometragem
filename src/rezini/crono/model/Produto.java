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
public class Produto {

    private int codProduto;
    private String nomeProduto;
    private String descProduto;
    private String createProduto;

    public int getcodProduto() {
        return codProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public String getDescProduto() {
        return descProduto;
    }

    public String getCreateProduto() {
        return createProduto;
    }
    
     public String getProdutoMenu() {
        String menu;
        menu = this.codProduto +"  "+this.nomeProduto;
         return menu;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
    }

    public void setCreateProduto(String createProduto) {
        this.createProduto = createProduto;
    }
    
}
