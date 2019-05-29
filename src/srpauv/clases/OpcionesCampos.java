/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srpauv.clases;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ferzo
 */
public class OpcionesCampos {
    //OPCIONES PARA LOS COMBOBOX------------------------------------------------
    
    public static List<String> opcionesCbxInstitucion = new ArrayList<String>();
    
    //DATOS PERSONALES----------------------------------------------------------
    public static List<String> opcionesCbxGenero = new ArrayList<String>();    
    public static List<String> opcionesCbxEdocivil = new ArrayList<String>();
    public static List<String> opcionesCbxArea = new ArrayList<String>();
    public static List<String> opcionesCbxDisciplina = new ArrayList<String>();
    public static List<String> opcionesCbxNacionalidad = new ArrayList<String>();
    //DATOS LABORALES-----------------------------------------------------------
    public static List<String> opcionesCbxDes = new ArrayList<String>();
    public static List<String> opcionesCbxUnidadA = new ArrayList<String>();
    public static List<String> opcionesCbxPrograma = new ArrayList<String>();
    public static List<String> opcionesCbxSNI = new ArrayList<String>();
    public static List<String> opcionesCbxPTC = new ArrayList<String>();
    
    //ESTUDIOS REALIZADOS-------------------------------------------------------
    public static List<String> opcionesCbxNivelEstudios = new ArrayList<String>();
    public static List<String> opcionesCbxPais = new ArrayList<String>();
    
    public OpcionesCampos(){
        this.opcionesCbxGenero.add("Masculino");
        this.opcionesCbxGenero.add("Femenino");
        this.opcionesCbxGenero.add("Otro");
        //----------------------------------------------------------------------
        this.opcionesCbxEdocivil.add("Soltero");
        this.opcionesCbxEdocivil.add("Casado");
        this.opcionesCbxEdocivil.add("Divorciado");
        this.opcionesCbxEdocivil.add("Viudo");
        //----------------------------------------------------------------------
        this.opcionesCbxDisciplina.add("Ingeniería de Software");
        this.opcionesCbxDisciplina.add("Ciencia de Datos");
        this.opcionesCbxDisciplina.add("Inteligencia Artificial");
        this.opcionesCbxDisciplina.add("Redes y Comunicaciones");
        //----------------------------------------------------------------------
        this.opcionesCbxArea.add("Diseño y Requerimientos");
        this.opcionesCbxArea.add("Metodologías de desarrollo");
        this.opcionesCbxArea.add("Machine Learning");
        this.opcionesCbxArea.add("Modelado de comunicaciones");
        this.opcionesCbxArea.add("Ingeniería de Software");
        //----------------------------------------------------------------------
        this.opcionesCbxNacionalidad.add("Argentina");
        this.opcionesCbxNacionalidad.add("Canadiense");
        this.opcionesCbxNacionalidad.add("Española");
        this.opcionesCbxNacionalidad.add("Estadounidense");
        this.opcionesCbxNacionalidad.add("Francesa");
        this.opcionesCbxNacionalidad.add("Mexicana");
        this.opcionesCbxNacionalidad.add("Portuguesa");
        //----------------------------------------------------------------------
        this.opcionesCbxUnidadA.add("Facultad de Estadística e Informática");
        //----------------------------------------------------------------------
        this.opcionesCbxPrograma.add("Ingeniería de Software");
        this.opcionesCbxPrograma.add("Tecnologías computacioneles");
        this.opcionesCbxPrograma.add("Redes y servicios de cómputo");
        this.opcionesCbxPrograma.add("Estadística");
        //----------------------------------------------------------------------
        this.opcionesCbxSNI.add("1");
        this.opcionesCbxSNI.add("2");
        this.opcionesCbxSNI.add("3");
        //----------------------------------------------------------------------
        this.opcionesCbxPTC.add("Sí");
        this.opcionesCbxPTC.add("No");
        //----------------------------------------------------------------------
        this.opcionesCbxInstitucion.add("Universidad Veracruzana");
        this.opcionesCbxInstitucion.add("Universidad Nacional Autónoma de México");
        this.opcionesCbxInstitucion.add("Instituto Politécnico Nacional");
        //----------------------------------------------------------------------
        this.opcionesCbxNivelEstudios.add("Licenciatura");
        this.opcionesCbxNivelEstudios.add("Maestría");
        this.opcionesCbxNivelEstudios.add("Doctorado");
        this.opcionesCbxNivelEstudios.add("Post-Doctorado");
        this.opcionesCbxNivelEstudios.add("Diplomado");
        //----------------------------------------------------------------------
        this.opcionesCbxPais.add("México");
        this.opcionesCbxPais.add("Canadá");
        this.opcionesCbxPais.add("Estados Unidos");
        this.opcionesCbxPais.add("Francia");
        //----------------------------------------------------------------------
        this.opcionesCbxDes.add("Económico-Administrativo");
        this.opcionesCbxDes.add("Humanidades");
        this.opcionesCbxDes.add("Biológica-Agropecuaria");
        this.opcionesCbxDes.add("Ciencias de la Salud");
        this.opcionesCbxDes.add("Técnica");
        
    }
    
    //SETTERS & GETTERS---------------------------------------------------------

    public static List<String> getOpcionesCbxInstitucion() {
        return opcionesCbxInstitucion;
    }

    public static void setOpcionesCbxInstitucion(List<String> opcionesCbxInstitucion) {
        OpcionesCampos.opcionesCbxInstitucion = opcionesCbxInstitucion;
    }

    public static List<String> getOpcionesCbxGenero() {
        return opcionesCbxGenero;
    }

    public static void setOpcionesCbxGenero(List<String> opcionesCbxGenero) {
        OpcionesCampos.opcionesCbxGenero = opcionesCbxGenero;
    }

    public static List<String> getOpcionesCbxEdocivil() {
        return opcionesCbxEdocivil;
    }

    public static void setOpcionesCbxEdocivil(List<String> opcionesCbxEdocivil) {
        OpcionesCampos.opcionesCbxEdocivil = opcionesCbxEdocivil;
    }

    public static List<String> getOpcionesCbxArea() {
        return opcionesCbxArea;
    }

    public static void setOpcionesCbxArea(List<String> opcionesCbxArea) {
        OpcionesCampos.opcionesCbxArea = opcionesCbxArea;
    }

    public static List<String> getOpcionesCbxDisciplina() {
        return opcionesCbxDisciplina;
    }

    public static void setOpcionesCbxDisciplina(List<String> opcionesCbxDisciplina) {
        OpcionesCampos.opcionesCbxDisciplina = opcionesCbxDisciplina;
    }

    public static List<String> getOpcionesCbxNacionalidad() {
        return opcionesCbxNacionalidad;
    }

    public static void setOpcionesCbxNacionalidad(List<String> opcionesCbxNacionalidad) {
        OpcionesCampos.opcionesCbxNacionalidad = opcionesCbxNacionalidad;
    }

    public static List<String> getOpcionesCbxUnidadA() {
        return opcionesCbxUnidadA;
    }

    public static void setOpcionesCbxUnidadA(List<String> opcionesCbxUnidadA) {
        OpcionesCampos.opcionesCbxUnidadA = opcionesCbxUnidadA;
    }

    public static List<String> getOpcionesCbxPrograma() {
        return opcionesCbxPrograma;
    }

    public static void setOpcionesCbxPrograma(List<String> opcionesCbxPrograma) {
        OpcionesCampos.opcionesCbxPrograma = opcionesCbxPrograma;
    }

    public static List<String> getOpcionesCbxSNI() {
        return opcionesCbxSNI;
    }

    public static void setOpcionesCbxSNI(List<String> opcionesCbxSNI) {
        OpcionesCampos.opcionesCbxSNI = opcionesCbxSNI;
    }

    public static List<String> getOpcionesCbxPTC() {
        return opcionesCbxPTC;
    }

    public static void setOpcionesCbxPTC(List<String> opcionesCbxPTC) {
        OpcionesCampos.opcionesCbxPTC = opcionesCbxPTC;
    }

    public static List<String> getOpcionesCbxNivelEstudios() {
        return opcionesCbxNivelEstudios;
    }

    public static void setOpcionesCbxNivelEstudios(List<String> opcionesCbxNivelEstudios) {
        OpcionesCampos.opcionesCbxNivelEstudios = opcionesCbxNivelEstudios;
    }

    public static List<String> getOpcionesCbxPais() {
        return opcionesCbxPais;
    }

    public static void setOpcionesCbxPais(List<String> opcionesCbxPais) {
        OpcionesCampos.opcionesCbxPais = opcionesCbxPais;
    }

    public static List<String> getOpcionesCbxDes() {
        return opcionesCbxDes;
    }

    public static void setOpcionesCbxDes(List<String> opcionesCbxDes) {
        OpcionesCampos.opcionesCbxDes = opcionesCbxDes;
    }
    
    
}
