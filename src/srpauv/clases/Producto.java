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
    protected int idProducto;
    protected  boolean considerarCA;
    protected String lgac;
    //protected IntegranteCA integrantesCA;
    protected String titulo;
    //protected Colaborador colaboradorExterno;
    protected boolean validadoCA;
    
    protected abstract int actualizarProducto();
    protected abstract int eliminarProducto();
    protected abstract int recuperarProducto();
    protected abstract int registrarProducto();
}
