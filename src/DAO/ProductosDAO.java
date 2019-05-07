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
            
            String sql ="INSERT INTO `articulo_ind_arb`(`idProducto`, `titulo`,"
                    + " `estado`, `lgac`, `ca`, `autor_es`, `descripcion`, `nombreRevista`, "
                    + "`editorial`, `volumen`, `isnn`, `rangoPaginas`, `pais`, `año`, "
                    + "`direccionElectronica`, `proposito`) VALUES "
                    + "(null,'" + articuloindexado.getTitulo() + "','" + articuloindexado.getEstado() + "',"
                    + "'" + articuloindexado.getLgac() + "'," + articuloindexado.isConsiderarCA() + ","
                    + "'" + articuloindexado.getAutor() + "','" + articuloindexado.getDescripcion() + "',"
                    + "'" + articuloindexado.getNomrevista() + "','" + articuloindexado.getEditorial() + "',"
                    + "'" + articuloindexado.getVolumen() + "','" + articuloindexado.getIssn() + "',"
                    + "'" + articuloindexado.getPags() + "','" + articuloindexado.getPais() + "',"
                    + "'" + articuloindexado.getAno() + "','" + articuloindexado.getDirelectronica() + "',"
                    + "'" + articuloindexado.getProposito() + "')";
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
    
    public static List<Producto> recuperarTodos() throws SQLException{
        List<Producto> list = new ArrayList<Producto>();
        Conexion conn = new Conexion();
        String sql;
        
        
        //TESIS
        sql =  "select `tesis`.`idProducto`,"
                + "`tesis`.`titulo`,"
                + "`tesis`.`lgac`,"
                + "`integrante`.`idIntegrante`,"
                + "`integrante`.`nombre`"
                + ",`integrante`.`apellidoP`"
                + ",`integrante`.`apellidoM`"
                + " from (`tesis` join `integrante`) where "
                + "`tesis`.`idIntegrante` = `integrante`.`idIntegrante` AND `tesis`.`ca` = 1";
        ResultSet rs = conn.consultar(sql);
        while(rs.next()){
            Producto prod = new Tesis(rs.getInt(1), rs.getString(3), 
                    rs.getString(2), new Integrante(rs.getInt(4), rs.getString(5), 
                            rs.getString(6), rs.getString(7)));
            
            list.add(prod);
        }
        
        //PROTOTIPO
        sql =  "select `prototipo`.`idProducto`,"
                + "`prototipo`.`titulo`,"
                + "`prototipo`.`lgac`,"
                + "`integrante`.`idIntegrante`,"
                + "`integrante`.`nombre`"
                + ",`integrante`.`apellidoP`"
                + ",`integrante`.`apellidoM`"
                + " from (`prototipo` join `integrante`) where "
                + "`prototipo`.`idIntegrante` = `integrante`.`idIntegrante` AND `prototipo`.`ca` = 1";
        rs = conn.consultar(sql);
        while(rs.next()){
            Producto prod = new Prototipo(rs.getInt(1), rs.getString(3), 
                    rs.getString(2), new Integrante(rs.getInt(4), rs.getString(5), 
                            rs.getString(6), rs.getString(7)));
            
            list.add(prod);
        }
        
        //PROD INNOV
        sql =  "select `produccioninovadora`.`idProducto`,"
                + "`produccioninovadora`.`titulo`,"
                + "`produccioninovadora`.`lgac`,"
                + "`integrante`.`idIntegrante`,"
                + "`integrante`.`nombre`"
                + ",`integrante`.`apellidoP`"
                + ",`integrante`.`apellidoM`"
                + " from (`produccioninovadora` join `integrante`) where "
                + "`produccioninovadora`.`idIntegrante` = `integrante`.`idIntegrante` AND `produccioninovadora`.`ca` = 1";
        rs = conn.consultar(sql);
        while(rs.next()){
            Producto prod = new Tesis(rs.getInt(1), rs.getString(3), 
                    rs.getString(2), new Integrante(rs.getInt(4), rs.getString(5), 
                            rs.getString(6), rs.getString(7)));
            
            list.add(prod);
        }
        
        //MEMORIA EXTENSO
        sql =  "select `memoriaextenso`.`idProducto`,"
                + "`memoriaextenso`.`titulo`,"
                + "`memoriaextenso`.`lgac`,"
                + "`integrante`.`idIntegrante`,"
                + "`integrante`.`nombre`"
                + ",`integrante`.`apellidoP`"
                + ",`integrante`.`apellidoM`"
                + " from (`memoriaextenso` join `integrante`) where "
                + "`memoriaextenso`.`idIntegrante` = `integrante`.`idIntegrante` AND `memoriaextenso`.`ca` = 1";
        rs = conn.consultar(sql);
        while(rs.next()){
            Producto prod = new Tesis(rs.getInt(1), rs.getString(3), 
                    rs.getString(2), new Integrante(rs.getInt(4), rs.getString(5), 
                            rs.getString(6), rs.getString(7)));
            
            list.add(prod);
        }
        
        //LIBRO
        sql =  "select `libro`.`idProducto`,"
                + "`libro`.`titulo`,"
                + "`libro`.`lgac`,"
                + "`integrante`.`idIntegrante`,"
                + "`integrante`.`nombre`"
                + ",`integrante`.`apellidoP`"
                + ",`integrante`.`apellidoM`"
                + " from (`libro` join `integrante`) where "
                + "`libro`.`idIntegrante` = `integrante`.`idIntegrante` AND `libro`.`ca` = 1";
        rs = conn.consultar(sql);
        while(rs.next()){
            Producto prod = new Tesis(rs.getInt(1), rs.getString(3), 
                    rs.getString(2), new Integrante(rs.getInt(4), rs.getString(5), 
                            rs.getString(6), rs.getString(7)));
            
            list.add(prod);
        }
        
        //CAP LIBRO
        sql =  "select `capitulolibro`.`idProducto`,"
                + "`capitulolibro`.`titulo`,"
                + "`capitulolibro`.`lgac`,"
                + "`integrante`.`idIntegrante`,"
                + "`integrante`.`nombre`"
                + ",`integrante`.`apellidoP`"
                + ",`integrante`.`apellidoM`"
                + " from (`capitulolibro` join `integrante`) where "
                + "`capitulolibro`.`idIntegrante` = `integrante`.`idIntegrante` AND `capitulolibro`.`ca` = 1";
        rs = conn.consultar(sql);
        while(rs.next()){
            Producto prod = new Tesis(rs.getInt(1), rs.getString(3), 
                    rs.getString(2), new Integrante(rs.getInt(4), rs.getString(5), 
                            rs.getString(6), rs.getString(7)));
            
            list.add(prod);
        }
        
        //ARTICULO
        sql =  "select `articulo`.`idProducto`,"
                + "`articulo`.`titulo`,"
                + "`articulo`.`lgac`,"
                + "`integrante`.`idIntegrante`,"
                + "`integrante`.`nombre`"
                + ",`integrante`.`apellidoP`"
                + ",`integrante`.`apellidoM`"
                + " from (`articulo` join `integrante`) where "
                + "`articulo`.`idIntegrante` = `integrante`.`idIntegrante` AND `articulo`.`ca` = 1";
        rs = conn.consultar(sql);
        while(rs.next()){
            Producto prod = new Tesis(rs.getInt(1), rs.getString(3), 
                    rs.getString(2), new Integrante(rs.getInt(4), rs.getString(5), 
                            rs.getString(6), rs.getString(7)));
            
            list.add(prod);
        }
        
        //ARTICULO ARB_INDEX
        sql =  "select `articulo_ind_arb`.`idProducto`,"
                + "`articulo_ind_arb`.`titulo`,"
                + "`articulo_ind_arb`.`lgac`,"
                + "`integrante`.`idIntegrante`,"
                + "`integrante`.`nombre`"
                + ",`integrante`.`apellidoP`"
                + ",`integrante`.`apellidoM`"
                + " from (`articulo_ind_arb` join `integrante`) where "
                + "`articulo_ind_arb`.`idIntegrante` = `integrante`.`idIntegrante` AND `articulo_ind_arb`.`ca` = 1";
        rs = conn.consultar(sql);
        while(rs.next()){
            Producto prod = new Tesis(rs.getInt(1), rs.getString(3), 
                    rs.getString(2), new Integrante(rs.getInt(4), rs.getString(5), 
                            rs.getString(6), rs.getString(7)));
            
            list.add(prod);
        }
        
        
        conn.cerrar();
        return list;
    }

    public static boolean validarCA(int idProducto, String tipo) {
        Conexion conn = new Conexion();
        String sql = "";
        switch(tipo){
            case "tesis":
                sql = "UPDATE `tesis` SET `ca`= 2 WHERE `idProducto` =" + idProducto;
                break;
            case "prototipo":
                sql = "UPDATE `prototipo` SET `ca`= 2 WHERE `idProducto` =" + idProducto;
                break;
            case "produccionInnovadora":
                sql = "UPDATE `produccioninovadora` SET `ca`= 2 WHERE `idProducto` =" + idProducto;
                break;
            case "memoriaExtenso":
                sql = "UPDATE `memoriaextenso` SET `ca`= 2 WHERE `idProducto` =" + idProducto;
                break;
            case "libro":
                sql = "UPDATE `libro` SET `ca`= 2 WHERE `idProducto` =" + idProducto;
                break;
            case "capituloLibro":
                sql = "UPDATE `capitulolibro` SET `ca`= 2 WHERE `idProducto` =" + idProducto;
                break;
            case "articuloIndexado":
                sql = "UPDATE `articulo_ind_arb` SET `ca`= 2 WHERE `idProducto` =" + idProducto;
                break;
            case "articuloArbitrado":
                sql = "UPDATE `articulo_ind_arb` SET `ca`= 2 WHERE `idProducto` =" + idProducto;
                break;
            case "articulo":
                sql = "UPDATE `articulo` SET `ca`= 2 WHERE `idProducto` =" + idProducto;
                break;
        }
        int flag = conn.ejecutar(sql);
        conn.cerrar();
        return flag == 0;
    }
}
