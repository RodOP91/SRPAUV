/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srpauv.clases;

import java.sql.Date;

/**
 *
 * @author ferzo
 */
public class DatosLaborales {
    private int idIntegrante;
    private boolean contratoPTC;
    private Date fechaIngresoUV;
    private String des;
    private String nombramiento;
    private String nivelSNI;
    private String programaEducativo;
    private String unidadAcademica;

    public DatosLaborales(){}
    
    public DatosLaborales(int id, boolean contrato, Date fechaIngreso, String des,
            String nivelSNI, String nombramiento, String programa, String unidad){
        this.idIntegrante = id;
        this.contratoPTC = contrato;
        this.fechaIngresoUV = fechaIngreso;
        this.des = des;
        this.nombramiento = nombramiento;
        this.nivelSNI = nivelSNI;
        this.programaEducativo = programa;
        this.unidadAcademica = unidad;
        
    }
    
    
    //SETTER & GETTERS----------------------------------------------------------
    public boolean getContratoPTC() {
        return contratoPTC;
    }

    public void setContratoPTC(boolean contratoPTC) {
        this.contratoPTC = contratoPTC;
    }

    public Date getFechaIngresoUV() {
        return fechaIngresoUV;
    }

    public void setFechaIngresoUV(Date fechaIngresoUV) {
        this.fechaIngresoUV = fechaIngresoUV;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getNombramiento() {
        return nombramiento;
    }

    public void setNombramiento(String nombramiento) {
        this.nombramiento = nombramiento;
    }

    public String getNivelSNI() {
        return nivelSNI;
    }

    public void setNivelSNI(String nivelSNI) {
        this.nivelSNI = nivelSNI;
    }

    public String getProgramaEducativo() {
        return programaEducativo;
    }

    public void setProgramaEducativo(String programaEducativo) {
        this.programaEducativo = programaEducativo;
    }

    public String getUnidadAcademica() {
        return unidadAcademica;
    }

    public void setUnidadAcademica(String unidadAcadémica) {
        this.unidadAcademica = unidadAcadémica;
    }
    
    
}
