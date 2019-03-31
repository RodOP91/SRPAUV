/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import srpauv.clases.CapituloLibro;
import srpauv.clases.*;

/**
 *
 * @author edson
 */
public class ProductosDAO {
    public static int registrar(Producto producto){
        int flag = -1;
        if(producto.getTipoProducto().equals("tesis")){
            Tesis tesis = (Tesis) producto;
            Conexion conn = new Conexion();
            
            String sql = "INSERT INTO `tesis`(`idProducto`, `titulo`, `estado`, "
                    + "`fechaInicio`, `fechaFin`, `noAlumnos`, `lgac`, `ca`, `tipo`, `grado`) "
                    + "VALUES (NULL,'"+tesis.getTitulo()+"','"+tesis.getEstado()+"'"
                    + ",'"+tesis.getFechaInicio()+"','"+tesis.getFechaFin()+"'"
                    + ","+tesis.getNumAlumnos()+",'"+tesis.getLgac()+"',"+tesis.isValidadoCA()+""
                    + ",'"+tesis.getTipoProducto()+"','"+tesis.getGrado()+"')";
            flag = conn.ejecutar(sql);
            conn.cerrar();
        }
        if(producto.getTipoProducto().equals("capituloLibro")){
            CapituloLibro capLib = (CapituloLibro) producto;
            Conexion conn = new Conexion();
            
            String sql = "";
            flag = conn.ejecutar(sql);
            conn.cerrar();
        }
        if(producto.getTipoProducto().equals("libro")){
            Libro libro = (Libro) producto;
            Conexion conn = new Conexion();
            
            String sql = "";
            flag = conn.ejecutar(sql);
            conn.cerrar();
        }
        if(producto.getTipoProducto().equals("prototipo")){
            Prototipo proto = (Prototipo) producto;
            Conexion conn = new Conexion();
            
            String sql = "";
            flag = conn.ejecutar(sql);
            conn.cerrar();
        }
        
        return flag;
    }
}
