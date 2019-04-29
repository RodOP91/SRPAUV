/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import srpauv.clases.Integrante;

/**
 *
 * @author edson
 */
public class IntegranteDAO {
    public static boolean registrar(Integrante integrante){
        Conexion conn = new Conexion();
        String sql = "INSERT INTO `integrante` (`idIntegrante`, `apellidoM`, "
                + "`apellidoP`, `nombre`, `usuario`, `password`)"
                + "VALUES (NULL, '"+ integrante.getApellidoM() +"', '"
                + integrante.getApellidoP() +"', '"+ integrante.getNombre()+"',"
                + " '"+ integrante.getUsuario() +"', '"+ integrante.getPassword()
                +"');";
        int flag = conn.ejecutar(sql);
        conn.cerrar();
        return flag == 0;
    }
}
