/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rezini.crono.dao;

import java.sql.Connection;
import rezini.crono.model.Elementos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ivan rezini
 */
public class ElementosDao extends ConnectionFactory {

    private Connection con;

    public ElementosDao() {
        this.con = this.getConnection();
    }

    public void inserir(Elementos elemento) throws SQLException {

        String sql = "INSERT INTO elemento (nomeElemento, ritmoElemento, interferenciaElemento, concessaoElemento, totalDePecas, codOperacao) VALUES (?, ?, ?, ?, ?, ?);";

        try ( PreparedStatement st = this.con.prepareStatement(sql)) {
           st.setString(1, elemento.getNomeElemento());
            st.setFloat(2, elemento.getRitmoElemento());
            st.setFloat(3, elemento.getInterferenciaElemento());
            st.setFloat(4, elemento.getConcessaoElemento());
            st.setInt(5, elemento.getTotalDePecas());
            st.setInt(6, elemento.getCodOperacao());

            st.execute();
            st.close();
        }

        this.con.close();

    }
public List<Elementos> listarElementos(int codOperacao) throws SQLException {
        String sql = "select * from elemento where codOperacao = ?";
        
        List<Elementos> elementos = null;

        try (PreparedStatement st = this.con.prepareStatement(sql)) {
              st.setInt(1, codOperacao);
            ResultSet rs = st.executeQuery();

            elementos = new ArrayList<Elementos>();

            while (rs.next()) {
                Elementos el = new Elementos();
                el.setNomeElemento(rs.getString("nomeElemento"));
                el.setRitmoElemento(rs.getFloat("ritmoElemento"));
                el.setCodOperacao(rs.getInt("codOperacao"));
                el.setInterferenciaElemento(rs.getFloat("interferenciaElemento"));
                el.setConcessaoElemento(rs.getFloat("concessaoElemento"));
                el.setTotalDePecas(rs.getInt("totalDePecas"));

                elementos.add(el);
            }

            rs.close();
            st.close();

        }

        this.con.close();
        return elementos;
    }

}
