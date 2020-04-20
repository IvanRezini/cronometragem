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
import rezini.crono.model.Produto;

/**
 *
 * @author ivan rezini
 */
public class ProdutoDao extends ConnectionFactory {

    private Connection con;

    public ProdutoDao() {
        this.con = this.getConnection();
    }

    public void inserir(Produto produto) throws SQLException {

        String sql = "INSERT INTO produto (nomeProduto, descProduto, createProduto) VALUES (?, ?, CURRENT_TIMESTAMP());";

        try ( PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setString(1, produto.getNomeProduto());
            st.setString(2, produto.getDescProduto());

            st.execute();
            st.close();
        }
        this.con.close();
    }

    public List<Produto> listaProdutos() throws SQLException {
        String sql = "select * from produto;";
        List<Produto> produtos = null;

        try ( PreparedStatement st = this.con.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();

            produtos = new ArrayList<Produto>();

            while (rs.next()) {
                Produto pr = new Produto();
                pr.setCodProduto(rs.getInt("codProduto"));
                pr.setNomeProduto(rs.getString("nomeProduto"));
                pr.setDescProduto(rs.getString("descProduto"));
                pr.setCreateProduto(rs.getString("createProduto"));

                produtos.add(pr);
            }
            rs.close();
            st.close();
        }
        this.con.close();
        return produtos;
    }

    public Produto getProduto(int codProduto) throws SQLException {
        String sql = "select * from produto  where codProduto = ?;";

        Produto produto = null;

        try ( PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setInt(1, codProduto);

            try ( ResultSet rs = st.executeQuery()) {

                if (rs.next()) {
                    produto = new Produto();
                    produto.setCodProduto(rs.getInt("codProduto"));
                    produto.setNomeProduto(rs.getString("nomeProduto"));
                    produto.setDescProduto(rs.getString("descProduto"));
                    produto.setCreateProduto(rs.getString("createProduto"));
                }
            }
            st.close();
        }
        this.con.close();
        return produto;
    }

    public void alterar(Produto produto) throws SQLException {
        
        String sql = "UPDATE produto SET nomeProduto= ?, descProduto = ?, createProduto = CURDATE() WHERE (codProduto= ?);";

        try ( PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setString(1, produto.getNomeProduto());
            st.setString(2, produto.getDescProduto());
            st.setInt(3, produto.getcodProduto());
            st.execute();
            st.close();
        }

        this.con.close();

    }

    public void eliminar(int codProduto) throws SQLException {

        String sql = "DELETE FROM produto WHERE codProduto = ?;";
        try ( PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setInt(1, codProduto);
            st.execute();
            st.close();
        }

        this.con.close();
    }

}
