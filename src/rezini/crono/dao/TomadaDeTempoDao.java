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
import rezini.crono.model.TomadaDeTempo;

/**
 *
 * @author ivan rezini
 */
public class TomadaDeTempoDao extends ConnectionFactory {

    private Connection con;

    public TomadaDeTempoDao() {
        this.con = this.getConnection();
    }

    public void inserir(TomadaDeTempo tomada) throws SQLException {
        String sql = "INSERT INTO tomadatempo(dataTomadaTempo, nomeCronometrista, DescTomadaTempo, codOperacao, codUsuario) VALUES(?, ?, ?, ?, ?); ";
        try ( PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setString(1, tomada.getDataTomadaTempo());
            st.setString(2, tomada.getNomeCronometrista());
            st.setString(3, tomada.getDescTomadaTempo());
            st.setInt(4, tomada.getCodOperacao());
            st.setInt(5, tomada.getCodUsuario());

            st.execute();
            st.close();
        }
        this.con.close();
    }

    public int ultimaTomada(String data) throws SQLException {
        String sql = "SELECT * FROM tomadatempo where dataTomadaTempo = ?;";
        int cod = 0;
        try (PreparedStatement st = this.con.prepareStatement(sql)){
             st.setString(1, data);
             try ( ResultSet rs = st.executeQuery()) {

                if (rs.next()) {
                    cod = (rs.getInt("codTomadaTempo"));
                }
            }
            st.close();
        }
        this.con.close();
        return cod;
    }
}
