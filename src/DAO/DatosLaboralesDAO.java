/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import srpauv.clases.DatosLaborales;
/**
 *
 * @author ferzo
 */
public class DatosLaboralesDAO {
    /**
     * 
     * @param idIntegrante , identificador único del integrante a consultar
     * @return datoslaborales, objeto de tipo DatosLaborales que contiene todos
     * los datos laborales del integrante consultado.
     * @throws SQLException 
     */
    public static DatosLaborales getDatosLaborales(int idIntegrante) throws SQLException{
        DatosLaborales datoslaborales = null;
        Conexion conn = new Conexion();
        String sql = "SELECT * FROM `datoslaborales` WHERE `idIntegrante` = '" + idIntegrante+"'";
        ResultSet rs;
        rs = conn.consultar(sql);
        while(rs.next()){
            datoslaborales = new DatosLaborales(rs.getInt(1), rs.getBoolean(2), 
            (rs.getDate(3)).toLocalDate(), rs.getString(4), rs.getString(5), rs.getString(6), 
            rs.getString(7), rs.getString(8));           
        }
        return datoslaborales;
    }
}
