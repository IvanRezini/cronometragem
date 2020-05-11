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
public class TomadaDeTempo {

    private int codTomadaTempo;
    private int codOperacao;
    private int codUsuario;
    private String nomeCronometrista;
    private String dataTomadaTempo;
    private String DescTomadaTempo;

    public int getCodTomadaTempo() {
        return codTomadaTempo;
    }

    public void setCodTomadaTempo(int codTomadaTempo) {
        this.codTomadaTempo = codTomadaTempo;
    }

    public int getCodOperacao() {
        return codOperacao;
    }

    public void setCodOperacao(int codOperacao) {
        this.codOperacao = codOperacao;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNomeCronometrista() {
        return nomeCronometrista;
    }

    public void setNomeCronometrista(String nomeCronometrista) {
        this.nomeCronometrista = nomeCronometrista;
    }

    public String getDataTomadaTempo() {
        return dataTomadaTempo;
    }

    public void setDataTomadaTempo(String dataTomadaTempo) {
        this.dataTomadaTempo = dataTomadaTempo;
    }

    public String getDescTomadaTempo() {
        return DescTomadaTempo;
    }

    public void setDescTomadaTempo(String DescTomadaTempo) {
        this.DescTomadaTempo = DescTomadaTempo;
    }

}
