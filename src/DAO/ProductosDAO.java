/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import srpauv.clases.Producto;
import srpauv.clases.Tesis;

/**
 *
 * @author edson
 */
public class ProductosDAO {
    public static int registrar(Producto producto){
        if(producto.getTipoProducto().equals("tesis")){
            System.out.println("registro tesis");
            Tesis tesis = (Tesis) producto;
            System.out.println(tesis.getTitulo());
        }
        return 1;
    }
}
