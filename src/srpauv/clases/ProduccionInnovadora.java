/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srpauv.clases;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author ferzo
 */
public class ProduccionInnovadora extends Producto {

    public ProduccionInnovadora() {

    }
    private String participante;

    
    private String descripcion;
    private String pais;
    private String proposito;
    private String clasifinternacional;
    private LocalDate fechapub;
    private String numregistro;
    private String usuario;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public LocalDate getFechapub() {
        return fechapub;
    }

    public void setFechapub(LocalDate fechapub) {
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
