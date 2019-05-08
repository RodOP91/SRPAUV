/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import srpauv.clases.EstudiosRealizados;
/**
 *
 * @author ferzo
 */
public class EstudiosRealizadosDAO {
    public static EstudiosRealizados getEstudiosRealizados(int idIntegrante) throws SQLException{
        EstudiosRealizados estudiosrealizados = null;
        Conexion conn = new Conexion();
        String sql = "SELECT * FROM `estudiosrealizados` WHERE `idIntegrante` = '" + idIntegrante+"'";
        ResultSet rs;
        rs = conn.consultar(sql);
        while(rs.next()){
            estudiosrealizados = new EstudiosRealizados(rs.getInt(1), rs.getString(2),
            rs.getString(3), rs.getString(4), (rs.getDate(5)).toLocalDate(), 
            (rs.getDate(6)).toLocalDate(), (rs.getDate(7)).toLocalDate(),
            rs.getString(8), rs.getString(9), rs.getString(10));           
        }
        return estudiosrealizados;
    }
}
