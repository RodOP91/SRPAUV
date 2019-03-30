/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import srpauv.clases.*;

/**
 *
 * @author edson
 */
public class DAOregistrarProducto {
    public static List<Linea> recuperarLineas() throws SQLException{
        List<Linea> lineas = new ArrayList<>();
        Conexion conn = new Conexion();
        String sql = "SELECT * FROM `linea`";
        ResultSet rs;
        rs = conn.consultar(sql);
        while(rs.next()){
            lineas.add(new Linea(rs.getInt(1), rs.getString(2), rs.getString(3)));
        }
        return lineas;
    }
}
