/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srpauv.clases;

import java.util.List;

/**
 *
 * @author edson
 */
public abstract class Producto {
    private int idProducto;
    private  boolean considerarCA;
    private String lgac;
    private String titulo;
    private boolean validadoCA;
    private String estado;
    private int idProyecto;
    
    private Proyecto proyectoAsociado;
    private Integrante IntegranteR; //integrante que registra el producto
    private List<Colaborador> colaboradores;
    private List<Integrante> integrantes;
    
    private String tipoProducto;

    public Producto(int idProducto, boolean considerarCA, String lgac, String titulo, String estado, int idProyecto, String tipoProducto) {
        this.idProducto = idProducto;
        this.considerarCA = considerarCA;
        this.lgac = lgac;
        this.titulo = titulo;
        this.estado = estado;
        this.idProyecto = idProyecto;
        this.tipoProducto = tipoProducto;
    }
    
    

    public Producto(int idProducto, String lgac, String titulo, Integrante integrante) {
        this.idProducto = idProducto;
        this.lgac = lgac;
        this.titulo = titulo;
        this.IntegranteR = integrante;
    }
    
    public Producto(){}
    
    public abstract int actualizarProducto();
    public abstract int eliminarProducto();
    public abstract int recuperarProducto();
    public abstract int registrarProducto();
    
    @Override
    public String toString(){
        return titulo;
    }

    /**
     * @return the idProducto
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * @return the considerarCA
     */
    public boolean isConsiderarCA() {
        return considerarCA;
    }

    /**
     * @param considerarCA the considerarCA to set
     */
    public void setConsiderarCA(boolean considerarCA) {
        this.considerarCA = considerarCA;
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
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the validadoCA
     */
    public boolean isValidadoCA() {
        return validadoCA;
    }

    /**
     * @param validadoCA the validadoCA to set
     */
    public void setValidadoCA(boolean validadoCA) {
        this.validadoCA = validadoCA;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the tipoProducto
     */
    public String getTipoProducto() {
        return tipoProducto;
    }

    /**
     * @param tipoProducto the tipoProducto to set
     */
    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
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
     * @return the proyectoAsociado
     */
    public Proyecto getProyectoAsociado() {
        return proyectoAsociado;
    }

    /**
     * @param proyectoAsociado the proyectoAsociado to set
     */
    public void setProyectoAsociado(Proyecto proyectoAsociado) {
        this.proyectoAsociado = proyectoAsociado;
    }

    /**
     * @return the IntegranteR
     */
    public Integrante getIntegranteR() {
        return IntegranteR;
    }

    /**
     * @param IntegranteR the IntegranteR to set
     */
    public void setIntegranteR(Integrante IntegranteR) {
        this.IntegranteR = IntegranteR;
    }

    /**
     * @return the colaboradores
     */
    public List<Colaborador> getColaboradores() {
        return colaboradores;
    }

    /**
     * @param colaboradores the colaboradores to set
     */
    public void setColaboradores(List<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }

    /**
     * @return the integrantes
     */
    public List<Integrante> getIntegrantes() {
        return integrantes;
    }

    /**
     * @param integrantes the integrantes to set
     */
    public void setIntegrantes(List<Integrante> integrantes) {
        this.integrantes = integrantes;
    }
}
