/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srpauv.clases;

import DAO.ProductosDAO;
import java.sql.Date;

/**
 *
 * @author ferzo
 */
public class ProduccionInnovadora extends Producto {
    
    private String participante;
    private String descripcion;
    private String pais;
    private String proposito;
    private String clasifinternacional;
    private Date fechapub;
    private String numregistro;
    private String usuario;

    public ProduccionInnovadora(String participante, String descripcion, 
            String pais, String proposito, String clasifinternacional, 
            Date fechapub, String numregistro, String usuario, int idProducto, 
            boolean considerarCA, String lgac, String titulo, String estado, 
            int idProyecto, String tipoProducto) {
        super(idProducto, considerarCA, lgac, titulo, estado, idProyecto, tipoProducto);
        this.participante = participante;
        this.descripcion = descripcion;
        this.pais = pais;
        this.proposito = proposito;
        this.clasifinternacional = clasifinternacional;
        this.fechapub = fechapub;
        this.numregistro = numregistro;
        this.usuario = usuario;
    }
    
    public ProduccionInnovadora(int id, String lgac, String titulo, Integrante integrante){
        super(id, lgac, titulo, integrante);
        this.setTipoProducto("produccionInnovadora");
    }
    
    public ProduccionInnovadora() {
        this.setTipoProducto("produccionInnovadora");
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getParticipante() {
        return participante;
    }

    public void setParticipante(String participante) {
        this.participante = participante;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getProposito() {
        return proposito;
    }

    public void setProposito(String proposito) {
        this.proposito = proposito;
    }

    public String getClasifinternacional() {
        return clasifinternacional;
    }

    public void setClasifinternacional(String clasifinternacional) {
        this.clasifinternacional = clasifinternacional;
    }

    public Date getFechapub() {
        return fechapub;
    }

    public void setFechapub(Date fechapub) {
        this.fechapub = fechapub;
    }

    public String getNumregistro() {
        return numregistro;
    }

    public void setNumregistro(String numregistro) {
        this.numregistro = numregistro;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
