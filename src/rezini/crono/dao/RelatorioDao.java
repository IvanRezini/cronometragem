/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rezini.crono.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import rezini.crono.model.Elementos;
import rezini.crono.model.Leitura;
import rezini.crono.model.Operacao;
import rezini.crono.model.TomadaDeTempo;

/**
 *
 * @author ivan rezini
 */
public class RelatorioDao extends ConnectionFactory {

    private Connection con;

    public RelatorioDao() {
        this.con = this.getConnection();
    }

    public List<Operacao> operacaoPorProduto(int cod) throws SQLException {
        //parametro "0" traz as operacoes que posuem elementos cadastrados
        String sql = "SELECT * FROM operacao "
                + "INNER JOIN produto on operacao.codProduto = produto.codProduto"
                + " WHERE operacao.codProduto = ? AND statusOperacao = 0;";
        Operacao operacao = null;
        List<Operacao> operacoes = null;
        try ( PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setInt(1, cod);

            try ( ResultSet rs = st.executeQuery()) {
                operacoes = new ArrayList<Operacao>();
                while (rs.next()) {
                    operacao = new Operacao();
                    operacao.setCodOperacao(rs.getInt("codOperacao"));
                    operacao.setNomeOperacao(rs.getString("nomeOperacao"));
                    operacao.setDescOperacao(rs.getString("descOperacao"));
                    operacao.setCreateOperacao(rs.getString("createOperacao"));
                    operacao.setStatusOperacao(rs.getInt("statusOperacao"));
                    operacao.setNomeProduto(rs.getString("nomeProduto"));
                    operacoes.add(operacao);
                }
            }
            st.close();
        }
        this.con.close();

        return operacoes;
    }

    public List<TomadaDeTempo> tomadaTempo(String dataInicial, String dataFinal, int codOperacao) throws SQLException {
        String sql = "SELECT * FROM tomadatempo WHERE dataTomadaTempo > ?"
                + "AND dataTomadaTempo < ? AND codOperacao = ?;";
        TomadaDeTempo tom = null;
        List<TomadaDeTempo> tomadas = null;
        try ( PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setString(1, dataInicial);
            st.setString(2, dataFinal);
            st.setInt(3, codOperacao);

            try ( ResultSet rs = st.executeQuery()) {
                tomadas = new ArrayList<TomadaDeTempo>();
                while (rs.next()) {
                    tom = new TomadaDeTempo();
                    tom.setCodTomadaTempo(rs.getInt("codTomadaTempo"));
                    tom.setDataTomadaTempo(rs.getString("dataTomadaTempo"));
                    tom.setDescTomadaTempo(rs.getString("DescTomadaTempo"));
                    tom.setNomeCronometrista(rs.getString("nomeCronometrista"));
                    tom.setCodUsuario(rs.getInt("codUsuario"));
                    tomadas.add(tom);
                }
            }
            st.close();
        }
        this.con.close();

        return tomadas;
    }

    public List<Leitura> listaTempos(int cod) throws SQLException {
        String sql = "SELECT * FROM leiturastempo WHERE codTomadaTempo = ?;";

        Leitura leitura = null;
        List<Leitura> leituras = null;

        try ( PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setInt(1, cod);
            try ( ResultSet rs = st.executeQuery()) {
                leituras = new ArrayList<Leitura>();
                while (rs.next()) {
                    leitura = new Leitura();
                    leitura.setCodTomada(rs.getInt("codTomadaTempo"));
                    leitura.setLeitura(rs.getString("leitura"));
                    leitura.setSequencia(rs.getInt("sequencia"));
                    leituras.add(leitura);
                }
            }
            st.close();
        }

        this.con.close();

        return leituras;
    }

    public List<TomadaDeTempo> listaTomadaTempos(int cod) throws SQLException {
        String sql = "SELECT * FROM rezinicrono.tomadatempo WHERE codOperacao = ?;";

        TomadaDeTempo tempo = null;
        List<TomadaDeTempo> tomadas = null;

        try ( PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setInt(1, cod);
            try ( ResultSet rs = st.executeQuery()) {
                tomadas = new ArrayList<TomadaDeTempo>();
                while (rs.next()) {
                    tempo = new TomadaDeTempo();
                    tempo.setCodTomadaTempo(rs.getInt("codTomadaTempo"));
                    tempo.setDescTomadaTempo(rs.getString("DescTomadaTempo"));
                    tempo.setDataTomadaTempo(rs.getString("dataTomadaTempo"));
                    tomadas.add(tempo);
                }
            }
            st.close();
        }

        this.con.close();

        return tomadas;
    }

    public List<Elementos> atributosElementos(int cod) throws SQLException {
        String sql = "SELECT * FROM elemento where codOperacao = "
                + "(SELECT codOperacao FROM tomadatempo where codTomadaTempo = ?);";
        Elementos ele = null;
        List<Elementos> elementos = null;
        try ( PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setInt(1, cod);
            try ( ResultSet rs = st.executeQuery()) {
                elementos = new ArrayList<Elementos>();
                while (rs.next()) {
                    ele=new Elementos();
                    ele.setConcessaoElemento(rs.getFloat("concessaoElemento"));
                    ele.setInterferenciaElemento(rs.getFloat("interferenciaElemento"));
                    ele.setRitmoElemento(rs.getFloat("ritmoElemento"));
                    ele.setTotalDePecas(rs.getInt("totalDePecas"));
                    elementos.add(ele);
                }
            }
            st.close();
        }
        this.con.close();
        return elementos;

    }
}
