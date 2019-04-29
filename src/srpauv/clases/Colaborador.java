/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srpauv.clases;

import DAO.ColaboradorDAO;

/**
 *
 * @author edson
 */
public class Colaborador {
    private int idColaborador;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String cuerpoAcademico;
    private String Institucion;

    public Colaborador(int idColaborador, String nombre, String apellidoP, String apellidoM) {
        this.idColaborador = idColaborador;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
    }

    public Colaborador(int idColaborador, String nombre, String apellidoP) {
        this.idColaborador = idColaborador;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
    }

    public Colaborador() {
    }
    
    public boolean registrarColaborador(){
        return ColaboradorDAO.registrar(this);
    }
    
    
    @Override
    public String toString(){
        return nombre + apellidoP;
    }

    /**
     * @return the idColaborador
     */
    public int getIdColaborador() {
        return idColaborador;
    }

    /**
     * @param idColaborador the idColaborador to set
     */
    public void setIdColaborador(int idColaborador) {
        this.idColaborador = idColaborador;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidoP
     */
    public String getApellidoP() {
        return apellidoP;
    }

    /**
     * @param apellidoP the apellidoP to set
     */
    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    /**
     * @return the apellidoM
     */
    public String getApellidoM() {
        return apellidoM;
    }

    /**
     * @param apellidoM the apellidoM to set
     */
    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    /**
     * @return the cuerpoAcademico
     */
    public String getCuerpoAcademico() {
        return cuerpoAcademico;
    }

    /**
     * @param cuerpoAcademico the cuerpoAcademico to set
     */
    public void setCuerpoAcademico(String cuerpoAcademico) {
        this.cuerpoAcademico = cuerpoAcademico;
    }

    /**
     * @return the Institucion
     */
    public String getInstitucion() {
        return Institucion;
    }

    /**
     * @param Institucion the Institucion to set
     */
    public void setInstitucion(String Institucion) {
        this.Institucion = Institucion;
    }
    
    
}



