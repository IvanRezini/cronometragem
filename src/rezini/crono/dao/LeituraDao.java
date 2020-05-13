/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rezini.crono.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import rezini.crono.model.Leitura;

/**
 *
 * @author ivan rezini
 */
public class LeituraDao extends ConnectionFactory {

    private Connection con;

    public LeituraDao() {
        this.con = this.getConnection();
    }

    public void inserir(Leitura leituras) throws SQLException {
        String sql = "INSERT INTO leiturastempo (codTomadaTempo, leitura, sequencia) VALUES (?, ?, ?);";

        try ( PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setInt(1, leituras.getCodLeitura());
            st.setString(2, leituras.getLeitura());
            st.setInt(3, leituras.getSequencia());
            st.execute();
            st.close();
        }

        this.con.close();

    }

}
