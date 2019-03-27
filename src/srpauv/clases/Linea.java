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
public class Linea {
    private int idLinea;
    private String nombre;
    private String idCA;

    /**
     * @return the idLinea
     */
    public int getIdLinea() {
        return idLinea;
    }

    /**
     * @param idLinea the idLinea to set
     */
    public void setIdLinea(int idLinea) {
        this.idLinea = idLinea;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the idCA
     */
    public String getIdCA() {
        return idCA;
    }

    /**
     * @param idCA the idCA to set
     */
    public void setIdCA(String idCA) {
        this.idCA = idCA;
    }
}
