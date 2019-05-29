/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import srpauv.clases.Integrante;

/**
 *
 * @author edson
 */
public class IntegranteDAO {
    
    public static boolean registrar(Integrante integrante) {
        Conexion conn = new Conexion();
        String sql;
        
        if(integrante.getApellidoM() == null){
            sql = "INSERT INTO `integrante` (`idIntegrante`, `apellidoM`, "
                + "`apellidoP`, `nombre`, `usuario`, `password`)"
                + "VALUES (NULL, '', '"
                + integrante.getApellidoP() +"', '"+ integrante.getNombre()+"',"
                + " '"+ integrante.getUsuario() +"', '"+ integrante.getPassword()
                +"');";
        } else {
            sql = "INSERT INTO `integrante` (`idIntegrante`, `apellidoM`, "
                + "`apellidoP`, `nombre`, `usuario`, `password`)"
                + "VALUES (NULL, '"+ integrante.getApellidoM() +"', '"
                + integrante.getApellidoP() +"', '"+ integrante.getNombre()+"',"
                + " '"+ integrante.getUsuario() +"', '"+ integrante.getPassword()
                +"');";
        }
        int flag = conn.ejecutar(sql);
        conn.cerrar();
        return flag == 0;
    }
    
    public static Integrante getDatosIntegrante(int idIntegrante)throws SQLException{
            Integrante integrante = null;
            Conexion conn = new Conexion();
            String sql = "SELECT * FROM `integrante` WHERE `idIntegrante` = '" + idIntegrante+"'";
            ResultSet rs;
            rs = conn.consultar(sql);
            while(rs.next()){
                integrante = new Integrante(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6),
                        rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
                        rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
                        rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19),           
                        rs.getInt(20));
            }
            return integrante;
    }

    public static boolean actualizarDatosIntegrante(Integrante integrante) throws SQLException{
        Conexion conn = new Conexion();
        String sql = "UPDATE `integrante` SET `apellidoM`='"+integrante.getApellidoM()+"',"
                + "`apellidoP`='"+integrante.getApellidoP()+"',"
                + "`nombre`='"+integrante.getNombre()+"',"
                + "`area`='"+integrante.getArea()+"',"
                + "`correoAdicional`='"+integrante.getCorreoAdicional()+"',"
                + "`correoUV`='"+integrante.getCorreoUV()+"',"
                + "`curp`='"+integrante.getCURP()+"',"
                + "`disciplina`='"+integrante.getDisciplina()+"',"
                + "`estadoCivil`='"+integrante.getEstadoCivil()+"',"
                + "`rfc`='"+integrante.getRfc()+"',"
                + "`telefonoCasa`='"+integrante.getTelefonoCasa()+"',"
                + "`telefonoTrabajo`='"+integrante.getTelefonoTrabajo()+"' WHERE `idIntegrante`= '" + integrante.getIdIntegrante()+"'";
        int flag = conn.ejecutar(sql);
        conn.cerrar();
        return flag == 0;
    }
    
    public static Integrante recuperarUsuario(String usuario) throws SQLException{
        Conexion conn = new Conexion();
        ResultSet rs;
        String sql = "SELECT `idIntegrante`, `apellidoP`, `apellidoM`, `nombre`,"
                + " `usuario`, `password`, `responsable` FROM `integrante` "
                + "WHERE usuario = '" + usuario + "'";
        rs = conn.consultar(sql);
        rs.next();
        Integrante integrante = new Integrante(rs.getInt(1), rs.getString(4), 
                rs.getString(2), rs.getString(3), rs.getString(5), 
                rs.getString(6), rs.getInt(7));
        conn.cerrar();
        return integrante;
    }
}
