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
                    + ","+tesis.getNumAlumnos()+",'"+tesis.getLgac()+"',"+tesis.isConsiderarCA()+""
                    + ",'"+tesis.getTipoProducto()+"','"+tesis.getGrado()+"')";
            flag = conn.ejecutar(sql);
            conn.cerrar();
        }
        
        if(producto.getTipoProducto().equals("articuloIndexado")){
            ArticuloIndexado articuloindexado = (ArticuloIndexado) producto;
            Conexion conn = new Conexion();
            
            String sql ="";
            flag = conn.ejecutar(sql);
            conn.cerrar();
        }
        
        if(producto.getTipoProducto().equals("articuloArbitrado")){
            ArticuloArbitrado articuloarbitrado = (ArticuloArbitrado) producto;
            Conexion conn = new Conexion();
            
            String sql ="";
            flag = conn.ejecutar(sql);
            conn.cerrar();
        }
        
        if(producto.getTipoProducto().equals("articulo")){
            Articulo articulo = (Articulo) producto;
            Conexion conn = new Conexion();
            
            String sql ="";
            flag = conn.ejecutar(sql);
            conn.cerrar();
        }
        
        if(producto.getTipoProducto().equals("capituloLibro")){
            CapituloLibro capLib = (CapituloLibro) producto;
            Conexion conn = new Conexion();
            
            String sql = "INSERT INTO `capitulolibro`(`idProducto`, `titulo`, "
                    + "`estado`, `lgac`, `ca`, `autor_es`, `editorial`, "
                    + "`rangoPaginas`, `pais`, `año`, `proposito`, `noEdiciones`,"
                    + " `totalEjemplares`, `isbn`, `tituloibro`) VALUES "
                    + "(NULL,'"+capLib.getTitulo()+"','"+capLib.getEstado()+"',"
                    + "'"+capLib.getLgac()+"',"+capLib.isConsiderarCA()+",'"
                    + ""+capLib.getAutor_es()+"','"+capLib.getEditorial()+"',"
                    + "'"+capLib.getPaginas()+"','"+capLib.getPais()+"','"+capLib.getAño()+"',"
                    + "'"+capLib.getProposito()+"',"+capLib.getNoEdiciones()+","
                    + ""+capLib.getTotalEjemplares()+",'"+capLib.getISBN()+"','"+capLib.getTituloLibro()+"')";
            flag = conn.ejecutar(sql);
            conn.cerrar();
        }
        if(producto.getTipoProducto().equals("libro")){
            Libro libro = (Libro) producto;
            Conexion conn = new Conexion();
            
            String sql = "INSERT INTO `libro`(`idProducto`, `titulo`, `estado`, "
                    + "`lgac`, `ca`, `autor_es`, `aditorial`, `pais`, `año`, "
                    + "`proposito`, `noEdiciones`, `totalEjemplares`, `isbn`) "
                    + "VALUES (NULL,'"+libro.getTitulo()+"','"+libro.getEstado()+"',"
                    + "'"+libro.getLgac()+"',"+libro.isConsiderarCA()+",'"+libro.getAutor_es()+"',"
                    + "'"+libro.getEditorial()+"','"+libro.getPais()+"','"+libro.getAño()+"',"
                    + "'"+libro.getProposito()+"',"+libro.getNoEdiciones()+","
                    + ""+libro.getTotalEjemplares()+",'"+libro.getISBN()+"')";
            flag = conn.ejecutar(sql);
            conn.cerrar();
        }
        
        if(producto.getTipoProducto().equals("produccionInnovadora")){
            ProduccionInnovadora produccioninnovadora = (ProduccionInnovadora) producto;
            Conexion conn = new Conexion();
            
            String sql ="";
            flag = conn.ejecutar(sql);
            conn.cerrar();
        }
        
        if(producto.getTipoProducto().equals("memoriaExtenso")){
            MemoriaExtenso memoriaextenso = (MemoriaExtenso) producto;
            Conexion conn = new Conexion();
            
            String sql ="";
            flag = conn.ejecutar(sql);
            conn.cerrar();
        }
        
        if(producto.getTipoProducto().equals("prototipo")){
            Prototipo proto = (Prototipo) producto;
            Conexion conn = new Conexion();
            
            String sql = "INSERT INTO `prototipo`(`idProducto`, `nombre`, "
                    + "`estado`, `lgac`, `autor_es`, `pais`, `año`, `proposito`,"
                    + " `objetivos`, `caracteristicas`, `institucion`) VALUES "
                    + "(NULL,'"+proto.getTitulo()+"','"+proto.getEstado()+"',"
                    + "'"+proto.getLgac()+"','"+proto.getAutor_es()+"','"+proto.getPais()+"',"
                    + "'"+proto.getAño()+"','"+proto.getProposito()+"','"+proto.getObjetivos()+"',"
                    + "'"+proto.getCaracteristicas()+"','"+proto.getInstitucion()+"')";
            flag = conn.ejecutar(sql);
            conn.cerrar();
        }
        
        return flag;
    }
}
