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
import srpauv.clases.EstudiosRealizados;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author ferzo
 */
public class EstudiosRealizadosDAO {
    public static boolean registrar(int idIntegrante, EstudiosRealizados estudios)throws SQLException{
        Conexion conn = new Conexion();
        String sql = "INSERT INTO `estudiosrealizados`(`idIntegrante`, `area`, `disciplina`, `estudiosEn`, `fechaInicioEstudios`, `fechaFinEstudios`, `fechaObtencionTitulo`, `grado`, `institucionOtorgante`, `pais`, `idestudio`) "
                + "VALUES ('"+idIntegrante+"',"
                + "'"+estudios.getArea()+"',"
                + "'"+estudios.getDisciplina()+"',"
                + "'"+estudios.getEstudiosEn()+"',"
                + "'"+estudios.getFechaInicio()+"',"
                + "'"+estudios.getFechaFin()+"',"
                + "'"+estudios.getFechaObtencionTitulo()+"',"
                + "'"+estudios.getGrado()+"',"
                + "'"+estudios.getInstitucionOtorgante()+"',"
                + "'"+estudios.getPais()+"',"
                + "NULL)";
        int flag = conn.ejecutar(sql);
        conn.cerrar();
        return flag == 0;
        
    }
    
    public static boolean actualizar(int idEstudio, EstudiosRealizados estudioModificado) throws SQLException{
        Conexion conn = new Conexion();
        String sql = "UPDATE `estudiosrealizados` SET `area`='"+estudioModificado.getArea()+"',"
                + "`disciplina`='"+estudioModificado.getDisciplina()+"',"
                + "`estudiosEn`='"+estudioModificado.getEstudiosEn()+"',"
                + "`fechaInicioEstudios`='"+estudioModificado.getFechaInicio()+"',"
                + "`fechaFinEstudios`='"+estudioModificado.getFechaFin()+"',"
                + "`fechaObtencionTitulo`='"+estudioModificado.getFechaObtencionTitulo()+"',"
                + "`grado`='"+estudioModificado.getGrado()+"',"
                + "`institucionOtorgante`='"+estudioModificado.getInstitucionOtorgante()+"',"
                + "`pais`='"+estudioModificado.getPais()+"'"
                + "WHERE `idestudio` = '"+idEstudio+"'";
        
        int flag = conn.ejecutar(sql);
        conn.cerrar();
        return flag==0;
    }
    public static ObservableList<EstudiosRealizados> getEstudiosRealizados(int idIntegrante) throws SQLException{
        List<EstudiosRealizados> estudiosrealizados= new ArrayList<EstudiosRealizados>();
        
        Conexion conn = new Conexion();
        String sql = "SELECT * FROM `estudiosrealizados` WHERE `idIntegrante` = '" + idIntegrante+"'";
        ResultSet rs;
        rs = conn.consultar(sql);
        while(rs.next()){
            estudiosrealizados.add(new EstudiosRealizados(rs.getInt(1), rs.getString(2),
            rs.getString(3), rs.getString(4), (rs.getDate(5)), 
            (rs.getDate(6)), (rs.getDate(7)),
            rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11)));  
                     
        }
        ObservableList estudios = FXCollections.observableArrayList(estudiosrealizados);
        return estudios;
    }
}
