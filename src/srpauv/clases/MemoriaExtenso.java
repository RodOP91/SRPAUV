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
public class MemoriaExtenso extends Producto{
    private String autor;    
    private String congreso;
    private String estado;
    private String ciudad;
    private String rangopags;
    private String pais;
    private String ano;
    private String proposito;
    
    public MemoriaExtenso(){
        this.setTipoProducto("memoriaExtenso");
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

    public String getCongreso() {
        return congreso;
    }

    public void setCongreso(String congreso) {
        this.congreso = congreso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRangopags() {
        return rangopags;
    }

    public void setRangopags(String rangopags) {
        this.rangopags = rangopags;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getProposito() {
        return proposito;
    }

    public void setProposito(String proposito) {
        this.proposito = proposito;
    }
    
}
