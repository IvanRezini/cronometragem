/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rezini.crono.dao;
import rezini.crono.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ivan rezini
 */
public class UsuarioDao extends ConnectionFactory {

    private Connection con;

    public UsuarioDao() {
        this.con = this.getConnection();
    }

    public void inserir(Usuario col) throws SQLException {

        String sql = "INSERT INTO usuario "
                + "(nomCol, ruaCol, baiCol, "
                + "numCol, cepCol, cidCol, celCol, dddCol,"
                + "tipCol, usuCol, senCol, emaCol, utiCol, datCol, estCol) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, md5(?), ?, ?, ?, ?);";
//INSERT INTO `rezinicrono`.`usuario` (`nomCol`, `baiCol`, `ruaCol`, `
//cidCol`, `usuCol`, `senCol`, `emaCol`, `utiCol`, `datCol`, `numCol`, `cepCol`,
//`celCol`, `dddCol`, `tipCol`, `estCol`) VALUES (' bb', 'bb', 'nb', 'bn', 'bn', 'b', 'bn', 'bnb', '112', '2', '23', '23', '22', '1', '2');

        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setString(1, col.getNomCol());
            st.setString(2, col.getRuaCol());
            st.setString(3, col.getBaiCol());
            st.setInt(4, col.getNumCol());
            st.setInt(5, (int) col.getCepCol());
            st.setString(6, col.getCidCol());
            st.setInt(7, (int) col.getCelCol());
            st.setInt(8, col.getDddCol());
            st.setInt(9, col.getTipCol());
            st.setString(10, col.getUsuCol());
            st.setString(11, col.getSenCol());
            st.setString(12, col.getEmaCol());
            st.setString(13, col.getUtiCol());
            st.setString(14, col.getDatCol());
            //verificar se vai comecar como 1 o estCol
            st.setInt(15, col.getEstCol());
           
            st.execute();
            st.close();
        }

        this.con.close();

    }

    public Usuario checar(String usuario, String senha) throws SQLException {
        String sql = "select * from usuario where usuCol = ? and senCol = md5(?);";
        List<Usuario> colaboradores = null;
        Usuario colaborador = null;
        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setString(1, usuario);
            st.setString(2, senha);
            
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    colaborador = new Usuario();
                    colaborador.setCodCol(rs.getInt("codCol"));
                    colaborador.setNomCol(rs.getString("nomCol"));
                    colaborador.setRuaCol(rs.getString("ruaCol"));
                    colaborador.setBaiCol(rs.getString("baiCol"));
                    colaborador.setNumCol(rs.getInt("numCol"));
                    colaborador.setCepCol(rs.getInt("cepCol"));
                    colaborador.setCidCol(rs.getString("cidCol"));
                    colaborador.setCelCol(rs.getInt("celCol"));
                    colaborador.setDddCol(rs.getInt("dddCol"));
                    colaborador.setTipCol(rs.getInt("tipCol"));
                    colaborador.setUsuCol(rs.getString("usuCol"));
                    colaborador.setSenCol(rs.getString("senCol"));
                    colaborador.setEmaCol(rs.getString("emaCol"));
                    colaborador.setUtiCol(rs.getString("utiCol"));
                    colaborador.setDatCol(rs.getString("datCol"));
                    colaborador.setEstCol(rs.getInt("estCol"));

                }
            }
            
            st.close();

        } catch (SQLException ex) {

            return null;
        }

        this.con.close();
        return colaborador;

    }

    public void eliminar(int estCol) throws SQLException {

        String sql = "update usuario set estCol = 0 where codCol =?";
        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setInt(1, estCol);
            st.execute();
            st.close();
        }

        this.con.close();

    }

    public void alterar(Usuario col) throws SQLException {
        String sql = "update usuario set nomCol = ?, ruaCol = ?, baiCol = ?, "
                + "numCol = ?, cepCol = ?, cidCol = ?, celCol = ?, dddCol = ?,"
                + "tipCol = ?, emaCol = ?, utiCol = ?,"
                + " datCol = ?, estCol = ? where codCol = ?";
        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setString(1, col.getNomCol());
            st.setString(2, col.getRuaCol());
            st.setString(3, col.getBaiCol());
            st.setInt(4, col.getNumCol());
            st.setInt(5, col.getCepCol());
            st.setString(6, col.getCidCol());
            st.setInt(7, col.getCelCol());
            st.setInt(8, col.getDddCol());
            st.setInt(9, col.getTipCol());
            st.setString(10, col.getEmaCol());
            st.setString(11, col.getUtiCol());
            st.setString(12, col.getDatCol());
            st.setInt(13, col.getEstCol());
            st.setInt(14, col.getCodCol());

            st.execute();
            st.close();
        }

        this.con.close();

    }

    public List<Usuario> listarColaboradores() throws SQLException {
        String sql = "select * from usuario where estCol=1";
        List<Usuario> colaboradores = null;

        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();

            colaboradores = new ArrayList<Usuario>();

            while (rs.next()) {
                Usuario col = new Usuario();
                col.setCodCol(rs.getInt("codCol"));
                col.setNomCol(rs.getString("nomCol"));
                col.setRuaCol(rs.getString("ruaCol"));
                col.setBaiCol(rs.getString("baiCol"));
                col.setNumCol(rs.getInt("numCol"));
                col.setCepCol(rs.getInt("cepCol"));
                col.setCidCol(rs.getString("cidCol"));
                col.setCelCol(rs.getInt("celCol"));
                col.setDddCol(rs.getInt("dddCol"));
                col.setTipCol(rs.getInt("tipCol"));
                col.setUsuCol(rs.getString("usuCol"));
                col.setSenCol(rs.getString("senCol"));
                col.setEmaCol(rs.getString("emaCol"));
                col.setUtiCol(rs.getString("utiCol"));
                col.setDatCol(rs.getString("datCol"));
                col.setEstCol(rs.getInt("estCol"));

                colaboradores.add(col);
            }

            rs.close();
            st.close();

        }

        this.con.close();
        return colaboradores;
    }

    public Usuario getColaborador(int codCol) throws SQLException {

        String sql = "select * from usuario where codCol = ?";

        Usuario colaborador = null;

        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setInt(1, codCol);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    colaborador = new Usuario();
                    colaborador.setCodCol(rs.getInt("codCol"));
                    colaborador.setNomCol(rs.getString("nomCol"));
                    colaborador.setRuaCol(rs.getString("ruaCol"));
                    colaborador.setBaiCol(rs.getString("baiCol"));
                    colaborador.setNumCol(rs.getInt("numCol"));
                    colaborador.setCepCol(rs.getInt("cepCol"));
                    colaborador.setCidCol(rs.getString("cidCol"));
                    colaborador.setCelCol(rs.getInt("celCol"));
                    colaborador.setDddCol(rs.getInt("dddCol"));
                    colaborador.setTipCol(rs.getInt("tipCol"));
                    colaborador.setUsuCol(rs.getString("usuCol"));
                    colaborador.setSenCol(rs.getString("senCol"));
                    colaborador.setEmaCol(rs.getString("emaCol"));
                    colaborador.setUtiCol(rs.getString("utiCol"));
                    colaborador.setDatCol(rs.getString("datCol"));
                    colaborador.setEstCol(rs.getInt("estCol"));

                }
            }
            st.close();
        }

        this.con.close();
        return colaborador;
    }
    
 public void alterarSenha(int cod,String senha) throws SQLException {
        String sql = "update usuario set senCol = md5(?) where codCol = ?";
        try (PreparedStatement st = this.con.prepareStatement(sql)) {
           st.setString(1, senha);
            st.setInt(2, cod);
            st.execute();
            st.close();
        }

        this.con.close();

    }
  public void SetarUltimoAcesso(int codCliente) throws SQLException {


        String sql = "update usuario set utiCol = CURDATE() where  codCol =?";


      
//estatus = 0 significa que o colaborador esta inativel

        try (PreparedStatement st = this.con.prepareStatement(sql)) {
           
            st.setInt(1,codCliente);
            st.execute();
            st.close();
        }

        this.con.close();

    }
  
}

