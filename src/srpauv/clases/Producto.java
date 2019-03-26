/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srpauv.clases;

/**
 *
 * @author edson
 */
public abstract class Producto {
    private int idProducto;
    private  boolean considerarCA;
    private String lgac;
    //protected IntegranteCA integrantesCA;
    private String titulo;
    //protected Colaborador colaboradorExterno;
    private boolean validadoCA;
    
    protected abstract int actualizarProducto();
    protected abstract int eliminarProducto();
    protected abstract int recuperarProducto();
    protected abstract int registrarProducto();

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
}
