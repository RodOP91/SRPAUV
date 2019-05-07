/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srpauv.clases;

import DAO.ProductosDAO;

/**
 *
 * @author ferzo
 */
public class ArticuloIndexado extends Producto{
    
    private String autor;
    private String descripcion;
    private String nomrevista;
    private String editorial;
    private String volumen;
    private String issn;
    private String pags;
    private String ano;
    private String direlectronica;
    private String proposito;
    private String pais;

    public ArticuloIndexado(int id, String lgac, String titulo, Integrante integrante){
        super(id, lgac, titulo, integrante);
        this.setTipoProducto("articuloIndexado");
    }
    
    public ArticuloIndexado(){
        this.setTipoProducto("articuloIndexado");
    }

    @Override
    public int actualizarProducto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNomrevista() {
        return nomrevista;
    }

    public void setNomrevista(String nomrevista) {
        this.nomrevista = nomrevista;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }
    
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getPags() {
        return pags;
    }

    public void setPags(String pags) {
        this.pags = pags;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getDirelectronica() {
        return direlectronica;
    }

    public void setDirelectronica(String direlectronica) {
        this.direlectronica = direlectronica;
    }

    public String getProposito() {
        return proposito;
    }

    public void setProposito(String proposito) {
        this.proposito = proposito;
    }
    
}
