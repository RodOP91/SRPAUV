/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srpauv.clases;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author ferzo
 */
public class EstudiosRealizados {
    private int idIntegrante;
    private String area;
    private String disciplina;
    private String estudiosEn;
    private Date fechaInicio;
    private Date fechaFin;
    private Date fechaObtencionTitulo;
    private String grado;
    private String institucionOtorgante;
    private String pais;
    private int idEstudio;
    
    public EstudiosRealizados(){}
    
    public EstudiosRealizados(int id, String area, String disciplina, String estudiosEn,
            Date fechainicio, Date fechafin, Date fechaobtencion, 
            String grado, String institucion, String pais){
        this.idIntegrante = id;
        this.area = area;
        this.disciplina = disciplina;
        this.estudiosEn = estudiosEn;
        this.fechaInicio = fechainicio;
        this.fechaFin = fechafin;
        this.fechaObtencionTitulo = fechaobtencion;
        this.grado = grado;
        this.institucionOtorgante = institucion;
        this.pais = pais;
        this.idEstudio= idEstudio;
    }
    public EstudiosRealizados(int id, String area, String disciplina, String estudiosEn,
            Date fechainicio, Date fechafin, Date fechaobtencion, 
            String grado, String institucion, String pais, int idEstudio){
        this.idIntegrante = id;
        this.area = area;
        this.disciplina = disciplina;
        this.estudiosEn = estudiosEn;
        this.fechaInicio = fechainicio;
        this.fechaFin = fechafin;
        this.fechaObtencionTitulo = fechaobtencion;
        this.grado = grado;
        this.institucionOtorgante = institucion;
        this.pais = pais;
        this.idEstudio= idEstudio;
    }
    
    
    
    
    //SETTERS & GETTERS---------------------------------------------------------

    public int getIdIntegrante() {
        return idIntegrante;
    }

    public void setIdIntegrante(int idIntegrante) {
        this.idIntegrante = idIntegrante;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getEstudiosEn() {
        return estudiosEn;
    }

    public void setEstudiosEn(String estudiosEn) {
        this.estudiosEn = estudiosEn;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaObtencionTitulo() {
        return fechaObtencionTitulo;
    }

    public void setFechaObtencionTitulo(Date fechaObtencionTitulo) {
        this.fechaObtencionTitulo = fechaObtencionTitulo;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getInstitucionOtorgante() {
        return institucionOtorgante;
    }

    public void setInstitucionOtorgante(String institucionOtorgante) {
        this.institucionOtorgante = institucionOtorgante;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getIdEstudio() {
        return idEstudio;
    }

    public void setIdEstudio(int idEstudio) {
        this.idEstudio = idEstudio;
    }
    
    
    
}
