/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srpauv.clases;

import java.time.LocalDate;

/**
 *
 * @author edson
 */
public class Proyecto {
    private int idProyecto;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private boolean ca;
    private String lgac;
    private String patrocinador;
    private String tipoPatrocinador;
    private int numMiembros;
    private String tituloProyecto;
    private int idIntegrante;

    public Proyecto(int idProyecto, String tituloProyecto) {
        this.idProyecto = idProyecto;
        this.tituloProyecto = tituloProyecto;
    }
    
    @Override
    public String toString(){
        return this.tituloProyecto;
    }
}
