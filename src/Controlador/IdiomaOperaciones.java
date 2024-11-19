package Controlador;

import Modelo.Ciudad;
import Modelo.Conexion;
import Modelo.Pais;
import Vista.Ventana;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Modelo.Idioma;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class IdiomaOperaciones {
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();
    Ciudad c = new Ciudad();
    Ventana vista = new Ventana();
    
    public int agregarIdioma(Idioma idioma) {  
        int r=0;
        String sql="insert into idioma(nombreIdioma, oficial, codigoPais) values(?,?,?)";
        try{
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);     

            ps.setString(1 ,idioma.getNombreIdioma());
            ps.setInt(2,idioma.getOficial());
            ps.setString(3, idioma.getCodigoPais());
            r=ps.executeUpdate();    
            
            if(r==1){
                return 1;
            }
            else{
                return 0;
            }
            }catch(Exception e)
            {
                  JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        return r;
    }
    public int modificarIdioma(Idioma idioma) {
    int r = 0;
    String sql = "UPDATE idioma SET nombreIdioma = ?, oficial = ?, codigoPais = ? WHERE idIdioma = ?";
    try {
        con = conectar.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1, idioma.getNombreIdioma());
        ps.setInt(2, idioma.getOficial());
        ps.setString(3, idioma.getCodigoPais());
        ps.setInt(4, idioma.getIdIdioma()); 
        r = ps.executeUpdate();

        if (r == 1) {
            return 1;
        } else {
            return 0;
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Se produjo un error al intentar modificar el idioma.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    return r;
}
    
    public int eliminarIdioma(String nombreIdio){
        int r=0;
        String sql = "Delete From idioma "
                + "where nombreIdioma = ?";
        try{
        con = conectar.getConnection();
        ps = con.prepareStatement(sql);  
        ps.setString(1, nombreIdio);
        r = ps.executeUpdate();
        if(r == 1){
            return 1; 
        }
        else{
            return 0;  
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar el idioma: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return r;
    }
    
    public int eliminarPorCodigoPais(String codigoPais) {
    int r = 0;
    String sql = "DELETE FROM idioma WHERE codigoPais = ?";
    try {
        con = conectar.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1, codigoPais);
        r = ps.executeUpdate();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al eliminar idiomas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return r;
}
    
    public List<Idioma> ConsultarIdioma(String nombre){
        List<Idioma> idiomas = new ArrayList<>();
        String sql = "SELECT * FROM idioma WHERE nombreIdioma = ?";
            try {
                con = conectar.getConnection();
                ps = con.prepareStatement(sql);
                ps.setString(1, nombre);
                rs = ps.executeQuery();
                
                    while (rs.next()) {
                        Idioma idioma = new Idioma();
                        idioma.setIdIdioma(rs.getInt("idIdioma"));
                        idioma.setNombreIdioma(rs.getString("nombreIdioma"));
                        idioma.setOficial(rs.getInt("oficial"));
                        idioma.setCodigoPais(rs.getString("codigoPais"));

                        idiomas.add(idioma);
                    } 
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al consultar el idioma: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            return idiomas; 
    }
   
    public List<Idioma> ConsultarPorPais(String codigo) {
        List<Idioma> idiomas = new ArrayList<>();
        String sql;
            if (codigo.isEmpty()) {
                sql = "SELECT * FROM idioma"; 
            } else {
                sql = "SELECT * FROM idioma WHERE codigoPais = ?";
            }
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            if (!codigo.isEmpty()) {
                ps.setString(1, codigo);
            }
            rs = ps.executeQuery();
                while (rs.next()) {
                    Idioma idioma = new Idioma();
                    idioma.setIdIdioma(rs.getInt("idIdioma"));
                    idioma.setNombreIdioma(rs.getString("nombreIdioma"));
                    idioma.setOficial(rs.getInt("oficial"));
                    idioma.setCodigoPais(rs.getString("codigoPais"));
                    idioma.setPorcentaje(rs.getInt("porcentaje"));
                    
                    idiomas.add(idioma);
                }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar los idiomas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return idiomas;
    }
}