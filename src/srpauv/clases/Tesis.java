/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srpauv.clases;

import DAO.ProductosDAO;
import java.sql.Date;

/**
 *
 * @author edson
 */
public class Tesis extends Producto{
     
    private Date fechaInicio;
    private Date fechaFin;
    private String grado;
    private int numAlumnos;

    public Tesis(Date fechaInicio, Date fechaFin, String grado, int numAlumnos, 
            int idProducto, boolean considerarCA, String lgac, String titulo, 
            String estado, int idProyecto, String tipoProducto) {
        super(idProducto, considerarCA, lgac, titulo, estado, idProyecto, tipoProducto);
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.grado = grado;
        this.numAlumnos = numAlumnos;
    }
    
    public Tesis(int id, String lgac, String titulo, Integrante integrante){
        super(id, lgac, titulo, integrante);
        this.setTipoProducto("tesis");
    }
    
    public Tesis(){
        this.setTipoProducto("tesis");
    }
    
    @Override
    public int actualizarProducto() {
        return ProductosDAO.editar(this);
    }

    @Override
    public int eliminarProducto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int recuperarProducto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int registrarProducto() {
        return ProductosDAO.registrar(this);
    }

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * @return the grado
     */
    public String getGrado() {
        return grado;
    }

    /**
     * @param grado the grado to set
     */
    public void setGrado(String grado) {
        this.grado = grado;
    }

    /**
     * @return the numAlumnos
     */
    public int getNumAlumnos() {
        return numAlumnos;
    }

    /**
     * @param numAlumnos the numAlumnos to set
     */
    public void setNumAlumnos(int numAlumnos) {
        this.numAlumnos = numAlumnos;
    }
}
