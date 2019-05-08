/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import srpauv.clases.Colaborador;

/**
 *
 * @author edson
 */
public class ColaboradorDAO {
    public static boolean registrar(Colaborador colaborador) throws SQLException{
        Conexion conn = new Conexion();
        String sql = "INSERT INTO `colaborador` (`nombre`, `apellidoP`, "
                + "`apellidoM`, `cuerpoAcademico`, `institucion`) VALUES "
                + "('"+colaborador.getNombre()+"','"+colaborador.getApellidoP()+
                "','"+colaborador.getApellidoM()+"','"
                + ""+colaborador.getCuerpoAcademico()+"','"
                + ""+colaborador.getInstitucion()+"')";
        int flag = conn.ejecutar(sql);
        conn.cerrar();
        return flag == 0;
    }
}
