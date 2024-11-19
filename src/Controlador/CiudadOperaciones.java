package Controlador;

import Modelo.Conexion;
import Modelo.Ciudad;
import Vista.Ventana;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CiudadOperaciones {
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();
    Ciudad c = new Ciudad();
    Ventana vista = new Ventana();
    
   public int agregarCiudad(Ciudad ciudad) {  
        int r=0;
        String sql="insert into ciudad(nombreCiudad, poblacionCiudad, codigoPais)values(?,?,?)";
        try{
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);      
            ps.setString(1,ciudad.getNombreCiudad());
            ps.setInt(2 ,ciudad.getPoblacionCiudad());
            ps.setString(3,ciudad.getCodigoPais());
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
   
    public int modificar(Ciudad ciudad) {  
        int r=0;
        String sql = "UPDATE ciudad SET idCiudad = ?, nombreCiudad = ?, poblacionCiudad = ? WHERE codigoPais = ?";
            try{
                con = conectar.getConnection();
                ps = con.prepareStatement(sql);
                ps.setInt(1, ciudad.getIdCiudad());
                ps.setString(2, ciudad.getNombreCiudad());
                ps.setLong(3, ciudad.getPoblacionCiudad());
                ps.setString(5, ciudad.getCodigoPais());
                r = ps.executeUpdate();

                if (r == 1) {
                    return 1;     
                } else {
                    return 0;
                }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Se Produjo un error al intentar modificar el país.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return r;
    }
    
    public List<Ciudad> Consultar(String codigo) {
    List<Ciudad> ciudades = new ArrayList<>();
    String sql = "SELECT * FROM ciudad WHERE codigoPais = ?";
    try {
        con = conectar.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1, codigo);
        rs = ps.executeQuery();
        
        while (rs.next()) {
            Ciudad ciudad = new Ciudad();
            ciudad.setIdCiudad(rs.getInt("idCiudad"));
            ciudad.setNombreCiudad(rs.getString("nombreCiudad"));
            ciudad.setPoblacionCiudad(rs.getInt("poblacionCiudad"));
            ciudad.setCodigoPais(rs.getString("codigoPais"));
            ciudades.add(ciudad);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al consultar la ciudad: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return ciudades;
}
    
    public List<Ciudad> ConsultarCiudadPorId(int idCiudad) {
    List<Ciudad> ciudades = new ArrayList<>();
    String sql = "SELECT * FROM ciudad WHERE idCiudad = ?";
    
    try (Connection con = new Conexion().getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, idCiudad);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Ciudad ciudad = new Ciudad();
            ciudad.setIdCiudad(rs.getInt("idCiudad"));
            ciudad.setNombreCiudad(rs.getString("nombreCiudad"));
            ciudad.setPoblacionCiudad(rs.getInt("poblacionCiudad"));
            ciudad.setCodigoPais(rs.getString("codigoPais"));
            ciudad.setDistrito(rs.getString("distrito"));
            ciudades.add(ciudad);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al consultar la ciudad: " + e.getMessage());
    }
    
    return ciudades;
}
    
    public int eliminarCiudad(String nombre){
        int r=0;
        String sql = "Delete From ciudad "
                + "where nombreCiudad = ?";
        try{
        con = conectar.getConnection();
        ps = con.prepareStatement(sql);  
        ps.setString(1, nombre);
        r = ps.executeUpdate();
        if(r == 1){
            return 1; 
        }
        else{
            return 0; 
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar el país: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return r;
    }
    
    public int eliminarPorCodigoPais(String codigoPais) {
    int r = 0;
    String sql = "DELETE FROM ciudad WHERE codigoPais = ?";
    try {
        con = conectar.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1, codigoPais);
        r = ps.executeUpdate();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al eliminar ciudades: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return r;
}
    
    public List<Ciudad> ConsultarCiudad(String nombre) {
    List<Ciudad> ciudades = new ArrayList<>();
    String sql = "SELECT * FROM ciudad WHERE nombreCiudad = ?"; 
    try {
        con = conectar.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1, nombre);
        rs = ps.executeQuery();

        while (rs.next()) {
            Ciudad ciudad = new Ciudad();
            ciudad.setIdCiudad(rs.getInt("idCiudad"));
            ciudad.setNombreCiudad(rs.getString("nombreCiudad"));
            ciudad.setPoblacionCiudad(rs.getInt("poblacionCiudad"));
            ciudad.setCodigoPais(rs.getString("codigoPais"));
            ciudad.setDistrito(rs.getString("distrito"));

            ciudades.add(ciudad);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al consultar la ciudad: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return ciudades;
    }
    
    public List<Ciudad> ConsultarPorPais(String codigo) {
        List<Ciudad> ciudades = new ArrayList<>();
        String sql;
            if (codigo.isEmpty()) {
                sql = "SELECT * FROM ciudad"; 
            } else {
                sql = "SELECT * FROM ciudad WHERE codigoPais = ?";
            }
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            if (!codigo.isEmpty()) {
                ps.setString(1, codigo);
            }
            rs = ps.executeQuery();
                while (rs.next()) {
                    Ciudad ciudad = new Ciudad();
                    ciudad.setIdCiudad(rs.getInt("idCiudad"));
                    ciudad.setNombreCiudad(rs.getString("nombreCiudad"));
                    ciudad.setPoblacionCiudad(rs.getInt("poblacionCiudad"));
                    ciudad.setCodigoPais(rs.getString("codigoPais"));
                    ciudad.setDistrito(rs.getString("distrito"));
                    
                    ciudades.add(ciudad);
                }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar las ciudades: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ciudades;
    }
}

