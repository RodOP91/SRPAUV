/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srpauv.clases;

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
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private LocalDate fechaObtencionTitulo;
    private String grado;
    private String institucionOtorgante;
    private String pais;
    
    public EstudiosRealizados(){}
    public EstudiosRealizados(int id, String area, String disciplina, String estudiosEn,
            LocalDate fechainicio, LocalDate fechafin, LocalDate fechaobtencion, 
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

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public LocalDate getFechaObtencionTitulo() {
        return fechaObtencionTitulo;
    }

    public void setFechaObtencionTitulo(LocalDate fechaObtencionTitulo) {
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
    
}
