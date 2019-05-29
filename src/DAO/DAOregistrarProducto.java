/*
 *******************************************************************************
 *******************************************************************************
 *******************************************************************************
 **                                                                          ***
 **   IMPORTANTE PASAR TODO DE ESTA CLASE A SU RESPECTIVA CLASE DE DOMINIO   ***
 **                                                                          ***
 *******************************************************************************
 *******************************************************************************
 *******************************************************************************
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
    public static List<Proyecto> recuperarProyectos() throws SQLException{
        List<Proyecto> proyectos = new ArrayList<>();
        Conexion conn = new Conexion();
        String sql = "SELECT idProyecto, tituloProyecto FROM `proyecto`";
        ResultSet rs;
        rs = conn.consultar(sql);
        while(rs.next()){
            proyectos.add(new Proyecto(rs.getInt(1), rs.getString(2)));
        }
        conn.cerrar();
        return proyectos;
    }
    
    public static List<Integrante> recuperarIntegrantes() throws SQLException{
        List<Integrante> integrantes = new ArrayList<>();
        Conexion conn = new Conexion();
        String sql = "SELECT `idIntegrante`, `apellidoP`, `nombre` FROM `integrante`";
        ResultSet rs;
        rs = conn.consultar(sql);
        while(rs.next()){
            integrantes.add(new Integrante(rs.getInt(1), rs.getString(3), rs.getString(2)));
        }
        conn.cerrar();
        return integrantes;
    }
    public static List<Colaborador> recuperarColaboradores() throws SQLException{
        List<Colaborador> colaboradores = new ArrayList<>();
        Conexion conn = new Conexion();
        String sql = "SELECT `idColaborador`, `nombre`, `apellidoP` FROM `colaborador`";
        ResultSet rs;
        rs = conn.consultar(sql);
        while(rs.next()){
            colaboradores.add(new Colaborador(rs.getInt(1), rs.getString(2), rs.getString(3)));   
        }
        conn.cerrar();
        return colaboradores;
    }
}
