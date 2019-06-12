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
    
    public static int editar(Producto producto){
        int flag = -1;
        if(producto.getTipoProducto().equals("tesis")){
            Tesis tesis = (Tesis) producto;
            Conexion conn = new Conexion();
            String sql = "UPDATE `tesis` SET `titulo`= '"+ tesis.getTitulo() +"'"
                    + ",`estado`='"+ tesis.getEstado() +"'"
                    + ",`fechaInicio`='"+ tesis.getFechaInicio() +"'"
                    + ",`fechaFin`='"+ tesis.getFechaFin() +"'"
                    + ",`noAlumnos`="+ tesis.getNumAlumnos() +""
                    + ",`lgac`='"+ tesis.getLgac() +"',"
                    + "`ca`="+ tesis.isConsiderarCA() +""
                    + ",`grado`='"+ tesis.getGrado() +"'"
                    + " WHERE idProducto = " + tesis.getIdProducto();
            flag = conn.ejecutar(sql);
            conn.cerrar();
        }
        
        if(producto.getTipoProducto().equals("articuloIndexado")){
            ArticuloIndexado articuloindexado = (ArticuloIndexado) producto;
            Conexion conn = new Conexion();
            
            String sql = "UPDATE `articulo_ind_arb` SET `titulo`='"+ articuloindexado.getTitulo() +"',"
                    + "`estado`='"+ articuloindexado.getEstado() +"',"
                    + "`lgac`='"+ articuloindexado.getLgac() +"',"
                    + "`ca`="+ articuloindexado.isConsiderarCA() +","
                    + "`autor_es`='"+ articuloindexado.getAutor() +"',"
                    + "`descripcion`='"+ articuloindexado.getDescripcion() +"',"
                    + "`nombreRevista`='"+ articuloindexado.getNomrevista() +"',"
                    + "`editorial`='"+ articuloindexado.getEditorial() +"',"
                    + "`volumen`='"+ articuloindexado.getVolumen() +"',"
                    + "`isnn`='"+ articuloindexado.getIssn() +"',"
                    + "`rangoPaginas`='"+ articuloindexado.getPags() +"',"
                    + "`pais`='"+ articuloindexado.getPais() +"',"
                    + "`año`='"+ articuloindexado.getAno() +"',"
                    + "`direccionElectronica`='"+ articuloindexado.getDirelectronica() +"',"
                    + "`proposito`='"+ articuloindexado.getProposito() +"' "
                    + "WHERE `idProducto` = " + articuloindexado.getIdProducto();
            flag = conn.ejecutar(sql);
            conn.cerrar();
        }
        
        if(producto.getTipoProducto().equals("articuloArbitrado")){
            ArticuloArbitrado articuloarbitrado = (ArticuloArbitrado) producto;
            Conexion conn = new Conexion();
            
            String sql ="UPDATE `articulo_ind_arb` SET `titulo`='"+ articuloarbitrado.getTitulo() +"',"
                    + "`estado`='"+ articuloarbitrado.getEstado() +"',"
                    + "`lgac`='"+ articuloarbitrado.getLgac() +"',"
                    + "`ca`="+ articuloarbitrado.isConsiderarCA() +","
                    + "`autor_es`='"+ articuloarbitrado.getAutor() +"',"
                    + "`descripcion`='"+ articuloarbitrado.getDescripcion() +"',"
                    + "`nombreRevista`='"+ articuloarbitrado.getNomrevista() +"',"
                    + "`editorial`='"+ articuloarbitrado.getEditorial() +"',"
                    + "`volumen`='"+ articuloarbitrado.getVolumen() +"',"
                    + "`isnn`='"+ articuloarbitrado.getIssn() +"',"
                    + "`rangoPaginas`='"+ articuloarbitrado.getPaginas() +"',"
                    + "`pais`='"+ articuloarbitrado.getPais() +"',"
                    + "`año`='"+ articuloarbitrado.getAno() +"',"
                    + "`proposito`='"+ articuloarbitrado.getProposito() +"' "
                    + "WHERE `idProducto` = " + articuloarbitrado.getIdProducto();
            flag = conn.ejecutar(sql);
            conn.cerrar();
        }
        
        if(producto.getTipoProducto().equals("articulo")){
            Articulo articulo = (Articulo) producto;
            Conexion conn = new Conexion();
            
            String sql ="UPDATE `articulo` SET `titulo`='"+articulo.getTitulo()+"',"
                    + "`estadoActual`='"+articulo.getEstado()+"',"
                    + "`lgac`='"+articulo.getLgac()+"',"
                    + "`ca`="+articulo.isConsiderarCA()+","
                    + "`autor_es`='"+articulo.getAutor()+"',"
                    + "`nombre_revista`='"+articulo.getNomrevista()+"',"
                    + "`editorial`='"+articulo.getEditorial()+"',"
                    + "`volumen`='"+articulo.getVolumen()+"',"
                    + "`issn`='"+articulo.getIssn()+"',"
                    + "`paginas`='"+articulo.getPaginas()+"',"
                    + "`pais`='"+articulo.getPais()+"',"
                    + "`año`='"+articulo.getAno()+"',"
                    + "`proposito`='"+articulo.getProposito()+"' "
                    + "WHERE `idProducto` =" + articulo.getIdProducto();
            flag = conn.ejecutar(sql);
            conn.cerrar();
        }
        
        if(producto.getTipoProducto().equals("capituloLibro")){
            CapituloLibro capLib = (CapituloLibro) producto;
            Conexion conn = new Conexion();
            
            String sql = "UPDATE `capitulolibro` SET `titulo`='"+capLib.getTitulo()+"',"
                    + "`estado`='"+capLib.getEstado()+"',"
                    + "`lgac`='"+capLib.getLgac()+"',"
                    + "`ca`="+capLib.isConsiderarCA()+","
                    + "`autor_es`='"+capLib.getAutor_es()+"',"
                    + "`editorial`='"+capLib.getEditorial()+"',"
                    + "`rangoPaginas`='"+capLib.getPaginas()+"'"
                    + ",`pais`='"+capLib.getPais()+"'"
                    + ",`año`='"+capLib.getAño()+"'"
                    + ",`proposito`='"+capLib.getProposito()+"'"
                    + ",`noEdiciones`="+capLib.getNoEdiciones()+""
                    + ",`totalEjemplares`="+capLib.getTotalEjemplares()+""
                    + ",`isbn`='"+capLib.getISBN()+"'"
                    + ",`tituloibro`='"+capLib.getTituloLibro()+"' "
                    + "WHERE `idProducto` ="+capLib.getIdProducto();
            flag = conn.ejecutar(sql);
            conn.cerrar();
        }
        if(producto.getTipoProducto().equals("libro")){
            Libro libro = (Libro) producto;
            Conexion conn = new Conexion();
            
            String sql = "UPDATE `libro` SET `titulo`='"+libro.getTitulo()+"',"
                    + "`estado`='"+libro.getEstado()+"',"
                    + "`lgac`='"+libro.getLgac()+"',"
                    + "`ca`="+libro.isConsiderarCA()+","
                    + "`autor_es`='"+libro.getAutor_es()+"',"
                    + "`aditorial`='"+libro.getEditorial()+"',"
                    + "`pais`='"+libro.getPais()+"',"
                    + "`año`='"+libro.getAño()+"',"
                    + "`proposito`='"+libro.getProposito()+"',"
                    + "`noEdiciones`="+libro.getNoEdiciones()+","
                    + "`totalEjemplares`="+libro.getTotalEjemplares()+","
                    + "`isbn`='"+libro.getISBN()+"'"
                    + " WHERE `idProducto` ="+libro.getIdProducto();
            flag = conn.ejecutar(sql);
            conn.cerrar();
        }
        
        if(producto.getTipoProducto().equals("produccionInnovadora")){
            ProduccionInnovadora produccioninnovadora = (ProduccionInnovadora) producto;
            Conexion conn = new Conexion();
            
            String sql ="UPDATE `produccioninovadora` SET `titulo`='"+produccioninnovadora.getTitulo()+"',"
                    + "`estadoActual`='"+produccioninnovadora.getEstado()+"',"
                    + "`lgac`='"+produccioninnovadora.getLgac()+"',"
                    + "`ca`="+produccioninnovadora.isConsiderarCA()+","
                    + "`descripcion`='"+produccioninnovadora.getDescripcion()+"',"
                    + "`pais`='"+produccioninnovadora.getPais()+"',"
                    + "`proposito`='"+produccioninnovadora.getProposito()+"',"
                    + "`clasifInterna`='"+produccioninnovadora.getClasifinternacional()+"',"
                    + "`fechaPublicacion`='"+produccioninnovadora.getFechapub()+"',"
                    + "`numRegistro`='"+produccioninnovadora.getNumregistro()+"',"
                    + "`usuario`='"+produccioninnovadora.getUsuario()+"',"
                    + "`participante`='"+produccioninnovadora.getParticipante()+"' "
                    + "WHERE `idProducto` ="+ produccioninnovadora.getIdProducto();
            flag = conn.ejecutar(sql);
            conn.cerrar();
        }
        
        if(producto.getTipoProducto().equals("memoriaExtenso")){
            MemoriaExtenso memoriaextenso = (MemoriaExtenso) producto;
            Conexion conn = new Conexion();
            
            String sql ="UPDATE `memoriaextenso` SET `titulo`='"+memoriaextenso.getTitulo()+"',"
                    + "`estadoActual`='"+memoriaextenso.getEstado()+"',"
                    + "`lgac`='"+memoriaextenso.getLgac()+"',"
                    + "`ca`="+memoriaextenso.isConsiderarCA()+","
                    + "`autor_es`='"+memoriaextenso.getAutor()+"',"
                    + "`paginas`='"+memoriaextenso.getRangopags()+"',"
                    + "`pais`='"+memoriaextenso.getPais()+"',"
                    + "`año`='"+memoriaextenso.getAno()+"',"
                    + "`proposito`='"+memoriaextenso.getProposito()+"',"
                    + "`nombreCongreso`='"+memoriaextenso.getCongreso()+"',"
                    + "`estado`='"+memoriaextenso.getEstadoG()+"',"
                    + "`ciudad`='"+memoriaextenso.getCiudad()+"' "
                    + "WHERE `idProducto` ="+memoriaextenso.getIdProducto();
            flag = conn.ejecutar(sql);
            conn.cerrar();
        }
        
        if(producto.getTipoProducto().equals("prototipo")){
            Prototipo proto = (Prototipo) producto;
            Conexion conn = new Conexion();
            
            String sql = "UPDATE `prototipo` SET `titulo`='"+proto.getTitulo()+"',"
                    + "`estado`='"+proto.getEstado()+"',"
                    + "`lgac`='"+proto.getLgac()+"',"
                    + "`ca`="+proto.isConsiderarCA()+","
                    + "`autor_es`='"+proto.getAutor_es()+"',"
                    + "`pais`='"+proto.getPais()+"',"
                    + "`año`='"+proto.getAño()+"',"
                    + "`proposito`='"+proto.getProposito()+"',"
                    + "`objetivos`='"+proto.getObjetivos()+"',"
                    + "`caracteristicas`='"+proto.getCaracteristicas()+"',"
                    + "`institucion`='"+proto.getInstitucion()+"' "
                    + "WHERE idProducto = " +proto.getIdProducto();
            flag = conn.ejecutar(sql);
            conn.cerrar();
        }
        return flag;
    }
    
    public static int registrar(Producto producto){
        int flag = -1;
        if(producto.getTipoProducto().equals("tesis")){
            Tesis tesis = (Tesis) producto;
            Conexion conn = new Conexion();
            String sql = "INSERT INTO `tesis`(`idProducto`, `titulo`, `estado`, "
                    + "`fechaInicio`, `fechaFin`, `noAlumnos`, `lgac`, `ca`, `tipo`, `grado`, "
                    + "`idIntegrante`, `idProyecto`) "
                    + "VALUES (NULL,'"+tesis.getTitulo()+"','"+tesis.getEstado()+"'"
                    + ",'"+tesis.getFechaInicio()+"','"+tesis.getFechaFin()+"'"
                    + ","+tesis.getNumAlumnos()+",'"+tesis.getLgac()+"',"+tesis.isConsiderarCA()+""
                    + ",'"+tesis.getTipoProducto()+"','"+tesis.getGrado()+"',"
                    + ""+tesis.getIntegranteR().getIdIntegrante()+", "
                    + ""+tesis.getIdProyecto()+")";
            flag = conn.ejecutar(sql);
            conn.cerrar();
        }
        
        if(producto.getTipoProducto().equals("articuloIndexado")){
            ArticuloIndexado articuloindexado = (ArticuloIndexado) producto;
            Conexion conn = new Conexion();
            
            String sql ="INSERT INTO `articulo_ind_arb`(`idProducto`, `titulo`,"
                    + " `estado`, `lgac`, `ca`, `autor_es`, `descripcion`, `nombreRevista`, "
                    + "`editorial`, `volumen`, `isnn`, `rangoPaginas`, `pais`, `año`, "
                    + "`direccionElectronica`, `proposito`, `idIntegrante`, `idProyecto`) VALUES "
                    + "(null,'" + articuloindexado.getTitulo() + "','" + articuloindexado.getEstado() + "',"
                    + "'" + articuloindexado.getLgac() + "'," + articuloindexado.isConsiderarCA() + ","
                    + "'" + articuloindexado.getAutor() + "','" + articuloindexado.getDescripcion() + "',"
                    + "'" + articuloindexado.getNomrevista() + "','" + articuloindexado.getEditorial() + "',"
                    + "'" + articuloindexado.getVolumen() + "','" + articuloindexado.getIssn() + "',"
                    + "'" + articuloindexado.getPags() + "','" + articuloindexado.getPais() + "',"
                    + "'" + articuloindexado.getAno() + "','" + articuloindexado.getDirelectronica() + "',"
                    + "'" + articuloindexado.getProposito() + "',"
                    + ""+articuloindexado.getIntegranteR().getIdIntegrante()+", "+articuloindexado.getIdProyecto()+")";
            flag = conn.ejecutar(sql);
            conn.cerrar();
        }
        
        if(producto.getTipoProducto().equals("articuloArbitrado")){
            ArticuloArbitrado articuloarbitrado = (ArticuloArbitrado) producto;
            Conexion conn = new Conexion();
            
            String sql ="INSERT INTO `articulo_ind_arb`(`idProducto`, `titulo`,"
                    + " `estado`, `lgac`, `ca`, `autor_es`, `descripcion`, `nombreRevista`, "
                    + "`editorial`, `volumen`, `isnn`, `rangoPaginas`, `pais`, `año`, "
                    + "`direccionElectronica`, `proposito`, `idIntegrante`, `idProyecto`) VALUES "
                    + "(null,'" + articuloarbitrado.getTitulo() + "','" + articuloarbitrado.getEstado() + "',"
                    + "'" + articuloarbitrado.getLgac() + "'," + articuloarbitrado.isConsiderarCA() + ","
                    + "'" + articuloarbitrado.getAutor() + "','" + articuloarbitrado.getDescripcion() + "',"
                    + "'" + articuloarbitrado.getNomrevista() + "','" + articuloarbitrado.getEditorial() + "',"
                    + "'" + articuloarbitrado.getVolumen() + "','" + articuloarbitrado.getIssn() + "',"
                    + "'" + articuloarbitrado.getPaginas()+ "','" + articuloarbitrado.getPais() + "',"
                    + "'" + articuloarbitrado.getAno() + "','',"
                    + "'" + articuloarbitrado.getProposito() + "',"
                    + ""+articuloarbitrado.getIntegranteR().getIdIntegrante()+", "
                    + ""+articuloarbitrado.getIdProyecto()+")";
            flag = conn.ejecutar(sql);
            conn.cerrar();
        }
        
        if(producto.getTipoProducto().equals("articulo")){
            Articulo articulo = (Articulo) producto;
            Conexion conn = new Conexion();
            
            String sql ="INSERT INTO `articulo`(`idProducto`, `titulo`, "
                    + "`estadoActual`, `lgac`, `ca`, `autor_es`, `nombre_revista`,"
                    + " `editorial`, `volumen`, `issn`, `paginas`, `pais`, `año`,"
                    + " `proposito`, `idIntegrante`, `idProyecto`) "
                    + "VALUES (null,'"+articulo.getTitulo()+"','"+articulo.getEstado()+"',"
                    + "'"+articulo.getLgac()+"',"+articulo.isConsiderarCA()+","
                    + "'"+articulo.getAutor()+"','"+articulo.getNomrevista()+"',"
                    + "'"+articulo.getEditorial()+"','"+articulo.getVolumen()+"',"
                    + "'"+articulo.getIssn()+"','"+articulo.getPaginas()+"',"
                    + "'"+articulo.getPais()+"','"+articulo.getAno()+"',"
                    + "'"+articulo.getProposito()+"',"+articulo.getIntegranteR().getIdIntegrante()+","
                    + "'"+articulo.getIdProyecto()+"')";
            flag = conn.ejecutar(sql);
            conn.cerrar();
        }
        
        if(producto.getTipoProducto().equals("capituloLibro")){
            CapituloLibro capLib = (CapituloLibro) producto;
            Conexion conn = new Conexion();
            
            String sql = "INSERT INTO `capitulolibro`(`idProducto`, `titulo`, "
                    + "`estado`, `lgac`, `ca`, `autor_es`, `editorial`, "
                    + "`rangoPaginas`, `pais`, `año`, `proposito`, `noEdiciones`,"
                    + " `totalEjemplares`, `isbn`, `tituloibro`, `idIntegrante`, `idProyecto`) VALUES "
                    + "(NULL,'"+capLib.getTitulo()+"','"+capLib.getEstado()+"',"
                    + "'"+capLib.getLgac()+"',"+capLib.isConsiderarCA()+",'"
                    + ""+capLib.getAutor_es()+"','"+capLib.getEditorial()+"',"
                    + "'"+capLib.getPaginas()+"','"+capLib.getPais()+"','"+capLib.getAño()+"',"
                    + "'"+capLib.getProposito()+"',"+capLib.getNoEdiciones()+","
                    + ""+capLib.getTotalEjemplares()+",'"+capLib.getISBN()+"',"
                    + "'"+capLib.getTituloLibro()+"',"+capLib.getIntegranteR().getIdIntegrante()+", "
                    + ""+capLib.getIdProyecto()+")";
            flag = conn.ejecutar(sql);
            conn.cerrar();
        }
        if(producto.getTipoProducto().equals("libro")){
            Libro libro = (Libro) producto;
            Conexion conn = new Conexion();
            
            String sql = "INSERT INTO `libro`(`idProducto`, `titulo`, `estado`, "
                    + "`lgac`, `ca`, `autor_es`, `aditorial`, `pais`, `año`, "
                    + "`proposito`, `noEdiciones`, `totalEjemplares`, `isbn`, `idIntegrante`, `idProyecto`) "
                    + "VALUES (NULL,'"+libro.getTitulo()+"','"+libro.getEstado()+"',"
                    + "'"+libro.getLgac()+"',"+libro.isConsiderarCA()+",'"+libro.getAutor_es()+"',"
                    + "'"+libro.getEditorial()+"','"+libro.getPais()+"','"+libro.getAño()+"',"
                    + "'"+libro.getProposito()+"',"+libro.getNoEdiciones()+","
                    + ""+libro.getTotalEjemplares()+",'"+libro.getISBN()+"',"
                    + ""+libro.getIntegranteR().getIdIntegrante()+", "+libro.getIdProyecto()+")";
            flag = conn.ejecutar(sql);
            conn.cerrar();
        }
        
        if(producto.getTipoProducto().equals("produccionInnovadora")){
            ProduccionInnovadora produccioninnovadora = (ProduccionInnovadora) producto;
            Conexion conn = new Conexion();
            
            String sql ="INSERT INTO `produccioninovadora`(`idProducto`, `titulo`,"
                    + " `estadoActual`, `lgac`, `ca`, `descripcion`, `pais`, `proposito`,"
                    + " `clasifInterna`, `fechaPublicacion`, `numRegistro`, `usuario`, "
                    + "`participante`, `idIntegrante`, `idProyecto`) "
                    + "VALUES (null,'"+produccioninnovadora.getTitulo()+"',"
                    + "'"+produccioninnovadora.getEstado()+"','"+produccioninnovadora.getLgac()+"',"
                    + ""+produccioninnovadora.isConsiderarCA()+","
                    + "'"+produccioninnovadora.getDescripcion()+"',"
                    + "'"+produccioninnovadora.getPais()+"','"+produccioninnovadora.getProposito()+"',"
                    + "'"+produccioninnovadora.getClasifinternacional()+"','"+produccioninnovadora.getFechapub()+"',"
                    + "'"+produccioninnovadora.getNumregistro()+"','"+produccioninnovadora.getUsuario()+"',"
                    + "'"+produccioninnovadora.getParticipante()+"',"+produccioninnovadora.getIntegranteR().getIdIntegrante()+","
                    + ""+produccioninnovadora.getIdProyecto()+")";
            flag = conn.ejecutar(sql);
            conn.cerrar();
        }
        
        if(producto.getTipoProducto().equals("memoriaExtenso")){
            MemoriaExtenso memoriaextenso = (MemoriaExtenso) producto;
            Conexion conn = new Conexion();
            
            String sql ="INSERT INTO `memoriaextenso`(`idProducto`, `titulo`,"
                    + " `estadoActual`, `lgac`, `ca`, `autor_es`, `paginas`, "
                    + "`pais`, `año`, `proposito`, `nombreCongreso`, `estado`, "
                    + "`ciudad`, `idIntegrante`, `idProyecto`)"
                    + " VALUES (null,'"+memoriaextenso.getTitulo()+"','"+memoriaextenso.getEstado()+"',"
                    + "'"+memoriaextenso.getLgac()+"',"+memoriaextenso.isConsiderarCA()+","
                    + "'"+memoriaextenso.getAutor()+"','"+memoriaextenso.getRangopags()+"',"
                    + "'"+memoriaextenso.getPais()+"','"+memoriaextenso.getAno()+"',"
                    + "'"+memoriaextenso.getProposito()+"',"
                    + "'"+memoriaextenso.getCongreso()+"',"
                    + "'"+memoriaextenso.getEstadoG()+"','"+memoriaextenso.getCiudad()+"',"
                    + ""+memoriaextenso.getIntegranteR().getIdIntegrante()+","+memoriaextenso.getIdProyecto()+")";
            flag = conn.ejecutar(sql);
            conn.cerrar();
        }
        
        if(producto.getTipoProducto().equals("prototipo")){
            Prototipo proto = (Prototipo) producto;
            Conexion conn = new Conexion();
            
            String sql = "INSERT INTO `prototipo`(`idProducto`, `titulo`, `estado`, "
                    + "`lgac`, `ca`, `autor_es`, `pais`, `año`, `proposito`, "
                    + "`objetivos`, `caracteristicas`, `institucion`, `idIntegrante`,"
                    + " `idProyecto`) VALUES "
                    + "(NULL,'"+proto.getTitulo()+"','"+proto.getEstado()+"',"
                    + "'"+proto.getLgac()+"',"+proto.isConsiderarCA()+" ,'"+proto.getAutor_es()+"','"+proto.getPais()+"',"
                    + "'"+proto.getAño()+"','"+proto.getProposito()+"','"+proto.getObjetivos()+"',"
                    + "'"+proto.getCaracteristicas()+"','"+proto.getInstitucion()+"',"
                    + ""+proto.getIntegranteR().getIdIntegrante()+", "+proto.getIdProyecto()+")";
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
    
    public static List<Producto> recuperarPorIntegrante(int idIntegrante) throws SQLException{
        List<Producto> list = new ArrayList<>();
        Conexion conn = new Conexion();
        String sql;
        
        //TESIS
        sql =  "SELECT `fechaInicio`,`fechaFin`,`grado`,`noAlumnos`,`idProducto`"
                + ",`ca`,`lgac`,`titulo`,`estado`,`idProyecto`,`tipo` "
                + "FROM tesis WHERE idIntegrante = " + idIntegrante;
        ResultSet rs = conn.consultar(sql);
        while(rs.next()){
            Producto prod = new Tesis(rs.getDate(1), rs.getDate(2), 
                    rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getBoolean(6), 
                    rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), 
                    rs.getString(11));
            list.add(prod);
        }
        
        //PROTOTIPO
        sql =  "SELECT `autor_es`,`pais`,`año`,`proposito`,`objetivos`,"
                + "`caracteristicas`,`institucion`,`idProducto`,`ca`,`lgac`,"
                + "`titulo`,`estado`,`idProyecto` FROM `prototipo` "
                + "WHERE idIntegrante = " + idIntegrante;
        rs = conn.consultar(sql);
        while(rs.next()){
            Producto prod = new Prototipo(rs.getString(1), rs.getString(2), 
                    rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), 
                    rs.getString(7), rs.getInt(8), rs.getBoolean(9), rs.getString(10)
                    , rs.getString(11), rs.getString(12), rs.getInt(13), "prototipo");
            list.add(prod);
        }
        //PROD INNOV
        sql =  "SELECT `participante`,`descripcion`,`pais`,`proposito`,"
                + "`clasifInterna`,`fechaPublicacion`,`numRegistro`,`usuario`,"
                + "`idProducto`,`ca`,`lgac`,`titulo`,`estadoActual`,`idProyecto` "
                + "FROM `produccioninovadora` WHERE idIntegrante =" + idIntegrante;
        rs = conn.consultar(sql);
        while(rs.next()){
            Producto prod = new ProduccionInnovadora(rs.getString(1), 
                    rs.getString(2), rs.getString(3), rs.getString(4), 
                    rs.getString(5), rs.getDate(6), rs.getString(7), rs.getString(8), 
                    rs.getInt(9), rs.getBoolean(10), rs.getString(11), rs.getString(12), 
                    rs.getString(13), rs.getInt(14), "produccionInnovadora");
            
            list.add(prod);
        }
        //MEMORIA EXTENSO
        sql =  "SELECT `autor_es`,`nombreCongreso`,`estado`,`ciudad`,`paginas`,"
                + "`pais`,`año`,`proposito`,`idProducto`,`ca`,`lgac`,`titulo`,"
                + "`estadoActual`,`idProyecto` FROM `memoriaextenso` "
                + "WHERE idIntegrante =" + idIntegrante;
        rs = conn.consultar(sql);
        while(rs.next()){
            Producto prod = new MemoriaExtenso(rs.getString(1), rs.getString(2), 
                    rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), 
                    rs.getString(7), rs.getString(8), rs.getInt(9), rs.getBoolean(10), 
                    rs.getString(11), rs.getString(12), rs.getString(13), rs.getInt(14),
                    "memoriaExtenso");
            list.add(prod);
        }
        //LIBRO
        sql =  "SELECT `autor_es`,`aditorial`,`pais`,`año`,`proposito`,"
                + "`noEdiciones`,`totalEjemplares`,`isbn`,`idProducto`,`ca`,"
                + "`lgac`,`titulo`,`estado`,`idProyecto` FROM `libro` "
                + "WHERE `idIntegrante` = "+idIntegrante;
        rs = conn.consultar(sql);

        while(rs.next()){
            Producto prod = new Libro(rs.getString(1), rs.getString(2), 
                    rs.getString(3), rs.getString(4), rs.getString(5), 
                    rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getInt(9),
                    rs.getBoolean(10), rs.getString(11), rs.getString(12), 
                    rs.getString(13), rs.getInt(14), "libro");
            list.add(prod);
        }
        //CAP LIBRO
        sql =  "SELECT `autor_es`,`editorial`,`rangoPaginas`,`pais`,`año`,"
                + "`proposito`,`noEdiciones`,`totalEjemplares`,`isbn`,`tituloibro`,"
                + "`idProducto`,`ca`,`lgac`,`titulo`,`estado`,`idProyecto` "
                + "FROM `capitulolibro` WHERE `idIntegrante` =" + idIntegrante;
        rs = conn.consultar(sql);
        while(rs.next()){
            Producto prod = new CapituloLibro(rs.getString(1), rs.getString(2), 
                    rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), 
                    rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10), 
                    rs.getInt(11), rs.getBoolean(12), rs.getString(13), rs.getString(14), 
                    rs.getString(15), rs.getInt(16), "capituloLibro");
            
            list.add(prod);
        }
        //ARTICULO
        sql =  "SELECT `autor_es`,`nombre_revista`,`editorial`,`volumen`,`issn`,"
                + "`paginas`,`pais`,`año`,`proposito`,`idProducto`,`ca`,`lgac`,"
                + "`titulo`,`estadoActual`,`idProyecto` FROM `articulo` WHERE "
                + "`idIntegrante` =" + idIntegrante;
        rs = conn.consultar(sql);
        while(rs.next()){
            Producto prod = new Articulo(rs.getString(1), rs.getString(2), 
                    rs.getString(3), rs.getString(4), rs.getString(5), 
                    rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), 
                    rs.getInt(10), rs.getBoolean(11), rs.getString(12), rs.getString(13),
                    rs.getString(14), rs.getInt(15), "articulo");
            list.add(prod);
        }
        /*
        //ARTICULO ARB_INDEX
        sql =  "";
        rs = conn.consultar(sql);
        while(rs.next()){
            Producto prod = null;
            list.add(prod);
        }
        */
        
        conn.cerrar();
        return list;
    }
}
