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
import rezini.crono.model.Operacao;

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

}
