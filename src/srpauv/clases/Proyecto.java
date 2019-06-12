/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srpauv.clases;

import DAO.ProyectoDAO;
import java.time.LocalDate;

/**
 *
 * @author edson
 */
public class Proyecto {
    private int idProyecto;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private boolean ca;
    private String lgac;
    private String patrocinador;
    private String tipoPatrocinador;
    private String numMiembros;
    private String tituloProyecto;
    private String investigadoresParticipantes;
    private String alumnosParticipantes;
    private String actividades;
    
    private int idIntegrante;

    public Proyecto(){};
    
    public Proyecto(int id){
        this.idProyecto = id;
    }
    
    public Proyecto(int idProyecto, String tituloProyecto) {
        this.idProyecto = idProyecto;
        this.tituloProyecto = tituloProyecto;
    }
    
    public boolean registrarProyecto(){
        return ProyectoDAO.registrar(this);
    }
    
    @Override
    public String toString(){
        return this.getTituloProyecto();
    }

    /**
     * @return the idProyecto
     */
    public int getIdProyecto() {
        return idProyecto;
    }

    /**
     * @param idProyecto the idProyecto to set
     */
    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    /**
     * @return the fechaInicio
     */
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public LocalDate getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * @return the ca
     */
    public boolean isCa() {
        return ca;
    }

    /**
     * @param ca the ca to set
     */
    public void setCa(boolean ca) {
        this.ca = ca;
    }

    /**
     * @return the lgac
     */
    public String getLgac() {
        return lgac;
    }

    /**
     * @param lgac the lgac to set
     */
    public void setLgac(String lgac) {
        this.lgac = lgac;
    }

    /**
     * @return the patrocinador
     */
    public String getPatrocinador() {
        return patrocinador;
    }

    /**
     * @param patrocinador the patrocinador to set
     */
    public void setPatrocinador(String patrocinador) {
        this.patrocinador = patrocinador;
    }

    /**
     * @return the tipoPatrocinador
     */
    public String getTipoPatrocinador() {
        return tipoPatrocinador;
    }

    /**
     * @param tipoPatrocinador the tipoPatrocinador to set
     */
    public void setTipoPatrocinador(String tipoPatrocinador) {
        this.tipoPatrocinador = tipoPatrocinador;
    }

    /**
     * @return the numMiembros
     */
    public String getNumMiembros() {
        return numMiembros;
    }

    /**
     * @param numMiembros the numMiembros to set
     */
    public void setNumMiembros(String numMiembros) {
        this.numMiembros = numMiembros;
    }

    /**
     * @return the tituloProyecto
     */
    public String getTituloProyecto() {
        return tituloProyecto;
    }

    /**
     * @param tituloProyecto the tituloProyecto to set
     */
    public void setTituloProyecto(String tituloProyecto) {
        this.tituloProyecto = tituloProyecto;
    }

    /**
     * @return the investigadoresParticipantes
     */
    public String getInvestigadoresParticipantes() {
        return investigadoresParticipantes;
    }

    /**
     * @param investigadoresParticipantes the investigadoresParticipantes to set
     */
    public void setInvestigadoresParticipantes(String investigadoresParticipantes) {
        this.investigadoresParticipantes = investigadoresParticipantes;
    }

    /**
     * @return the alumnosParticipantes
     */
    public String getAlumnosParticipantes() {
        return alumnosParticipantes;
    }

    /**
     * @param alumnosParticipantes the alumnosParticipantes to set
     */
    public void setAlumnosParticipantes(String alumnosParticipantes) {
        this.alumnosParticipantes = alumnosParticipantes;
    }

    /**
     * @return the actividades
     */
    public String getActividades() {
        return actividades;
    }

    /**
     * @param actividades the actividades to set
     */
    public void setActividades(String actividades) {
        this.actividades = actividades;
    }

    /**
     * @return the idIntegrante
     */
    public int getIdIntegrante() {
        return idIntegrante;
    }

    /**
     * @param idIntegrante the idIntegrante to set
     */
    public void setIdIntegrante(int idIntegrante) {
        this.idIntegrante = idIntegrante;
    }
}
