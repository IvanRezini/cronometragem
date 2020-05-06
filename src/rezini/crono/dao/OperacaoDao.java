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
public class OperacaoDao extends ConnectionFactory {

    private Connection con;

    public OperacaoDao() {
        this.con = this.getConnection();
    }

    public void inserir(Operacao operacao) throws SQLException {

        String sql = "INSERT INTO operacao (nomeOperacao, descOperacao, createOperacao, "
                + "codProduto, statusOperacao) VALUES (?, ?, CURRENT_TIMESTAMP(), ?, ?);";

        try ( PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setString(1, operacao.getNomeOperacao());
            st.setString(2, operacao.getDescOperacao());
            st.setInt(3, operacao.getCodProduto());
            st.setInt(4, operacao.getStatusOperacao());

            st.execute();
            st.close();
        }

        this.con.close();

    }

    public List<Operacao> listaOperacoes() throws SQLException {
        String sql = "SELECT * FROM operacao INNER JOIN produto on operacao.codProduto = produto.codProduto;";
        List<Operacao> operacoes = null;

        try ( PreparedStatement st = this.con.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();

            operacoes = new ArrayList<Operacao>();

            while (rs.next()) {
                Operacao op = new Operacao();
                op.setCodOperacao(rs.getInt("codOperacao"));
                op.setNomeOperacao(rs.getString("nomeOperacao"));
                op.setDescOperacao(rs.getString("descOperacao"));
                op.setCreateOperacao(rs.getString("createOperacao"));
                op.setStatusOperacao(rs.getInt("statusOperacao"));
                op.setNomeProduto(rs.getString("nomeProduto"));
                operacoes.add(op);
            }

            rs.close();
            st.close();

        }

        this.con.close();
        return operacoes;
    }

    public List<Operacao> listaOperacoesSemElementos() throws SQLException {
        String sql = "SELECT * FROM operacao INNER JOIN produto on operacao.codProduto = produto.codProduto WHERE statusOperacao = 1 ;";
        ///parametro "1" tras todas as operaçoes que não posuim elementos cadastrados
        List<Operacao> operacoes = null;

        try ( PreparedStatement st = this.con.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();

            operacoes = new ArrayList<Operacao>();

            while (rs.next()) {
                Operacao op = new Operacao();
                op.setCodOperacao(rs.getInt("codOperacao"));
                op.setNomeOperacao(rs.getString("nomeOperacao"));
                op.setDescOperacao(rs.getString("descOperacao"));
                op.setCreateOperacao(rs.getString("createOperacao"));
                op.setStatusOperacao(rs.getInt("statusOperacao"));
                op.setNomeProduto(rs.getString("nomeProduto"));

                operacoes.add(op);
            }

            rs.close();
            st.close();

        }

        this.con.close();
        return operacoes;
    }
      public List<Operacao> listaOperacoesComElementos() throws SQLException {
        String sql = "SELECT * FROM operacao INNER JOIN produto on operacao.codProduto = produto.codProduto WHERE statusOperacao = 0 ;";
        ///parametro "0" tras todas as operaçoes com elementos cadastrados
        List<Operacao> operacoes = null;

        try ( PreparedStatement st = this.con.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();

            operacoes = new ArrayList<Operacao>();

            while (rs.next()) {
                Operacao op = new Operacao();
                op.setCodOperacao(rs.getInt("codOperacao"));
                op.setNomeOperacao(rs.getString("nomeOperacao"));
                op.setDescOperacao(rs.getString("descOperacao"));
                op.setCreateOperacao(rs.getString("createOperacao"));
                op.setStatusOperacao(rs.getInt("statusOperacao"));
                op.setNomeProduto(rs.getString("nomeProduto"));

                operacoes.add(op);
            }

            rs.close();
            st.close();

        }

        this.con.close();
        return operacoes;
    }

    public Operacao getOperacoe(int cod) throws SQLException {
        String sql = "SELECT * FROM operacao "
                + "INNER JOIN produto on operacao.codProduto = produto.codProduto"
                + " WHERE codOperacao = ?;";
        Operacao operacao = null;

        try ( PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setInt(1, cod);

            try ( ResultSet rs = st.executeQuery()) {

                if (rs.next()) {
                    operacao = new Operacao();
                    operacao.setCodOperacao(rs.getInt("codOperacao"));
                    operacao.setNomeOperacao(rs.getString("nomeOperacao"));
                    operacao.setDescOperacao(rs.getString("descOperacao"));
                    operacao.setCreateOperacao(rs.getString("createOperacao"));
                    operacao.setStatusOperacao(rs.getInt("statusOperacao"));
                    operacao.setNomeProduto(rs.getString("nomeProduto"));
                }
            }
            st.close();
        }
        this.con.close();
        return operacao;
    }

    public void alterar(Operacao operacao) throws SQLException {

        String sql = "UPDATE operacao SET nomeOperacao = ?, descOperacao = ? WHERE (codOperacao = ?);";

        try ( PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setString(1, operacao.getNomeOperacao());
            st.setString(2, operacao.getDescOperacao());
            st.setInt(3, operacao.getCodOperacao());
            st.execute();
            st.close();
        }

        this.con.close();

    }

    public void alterarStatus(int cod) throws SQLException {
        
        String sql = "UPDATE operacao SET statusOperacao = '0' WHERE (codOperacao = ?);";
//Parametro "0" indica que a operçao tem elementos cadastrados
        try ( PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setInt(1, cod);
            st.execute();
            st.close();
        }

        this.con.close();

    }

}
