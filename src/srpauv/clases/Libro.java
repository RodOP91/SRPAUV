/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srpauv.clases;

import DAO.ProductosDAO;

/**
 *
 * @author edson
 */
public class Libro extends Producto{
    
    private String autor_es;
    private String editorial;
    private String pais;
    private String año;
    private String proposito;
    private int noEdiciones;
    private int totalEjemplares;
    private String ISBN;

    public Libro(String autor_es, String editorial, String pais, String año, 
            String proposito, int noEdiciones, int totalEjemplares, String ISBN, 
            int idProducto, boolean considerarCA, String lgac, String titulo, 
            String estado, int idProyecto, String tipoProducto) {
        super(idProducto, considerarCA, lgac, titulo, estado, idProyecto, tipoProducto);
        this.autor_es = autor_es;
        this.editorial = editorial;
        this.pais = pais;
        this.año = año;
        this.proposito = proposito;
        this.noEdiciones = noEdiciones;
        this.totalEjemplares = totalEjemplares;
        this.ISBN = ISBN;
    }
    
    public Libro(int id, String lgac, String titulo, Integrante integrante){
        super(id, lgac, titulo, integrante);
        this.setTipoProducto("libro");
    }
    
    public Libro(){
        this.setTipoProducto("libro");
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
     * @return the autor_es
     */
    public String getAutor_es() {
        return autor_es;
    }

    /**
     * @param autor_es the autor_es to set
     */
    public void setAutor_es(String autor_es) {
        this.autor_es = autor_es;
    }

    /**
     * @return the editorial
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * @param editorial the editorial to set
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @return the año
     */
    public String getAño() {
        return año;
    }

    /**
     * @param año the año to set
     */
    public void setAño(String año) {
        this.año = año;
    }

    /**
     * @return the proposito
     */
    public String getProposito() {
        return proposito;
    }

    /**
     * @param proposito the proposito to set
     */
    public void setProposito(String proposito) {
        this.proposito = proposito;
    }

    /**
     * @return the noEdiciones
     */
    public int getNoEdiciones() {
        return noEdiciones;
    }

    /**
     * @param noEdiciones the noEdiciones to set
     */
    public void setNoEdiciones(int noEdiciones) {
        this.noEdiciones = noEdiciones;
    }

    /**
     * @return the totalEjemplares
     */
    public int getTotalEjemplares() {
        return totalEjemplares;
    }

    /**
     * @param totalEjemplares the totalEjemplares to set
     */
    public void setTotalEjemplares(int totalEjemplares) {
        this.totalEjemplares = totalEjemplares;
    }

    /**
     * @return the ISBN
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * @param ISBN the ISBN to set
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
