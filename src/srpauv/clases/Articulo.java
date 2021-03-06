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
public class Articulo extends Producto{
    
    private String autor;
    private String nomrevista;
    private String editorial;
    private String volumen;
    private String issn;
    private String paginas;
    private String pais;
    private String ano;
    private String proposito;

    public Articulo(String autor, String nomrevista, String editorial, String volumen, 
            String issn, String paginas, String pais, String ano, String proposito, 
            int idProducto, boolean considerarCA, String lgac, String titulo, 
            String estado, int idProyecto, String tipoProducto) {
        super(idProducto, considerarCA, lgac, titulo, estado, idProyecto, tipoProducto);
        this.autor = autor;
        this.nomrevista = nomrevista;
        this.editorial = editorial;
        this.volumen = volumen;
        this.issn = issn;
        this.paginas = paginas;
        this.pais = pais;
        this.ano = ano;
        this.proposito = proposito;
    }
   
    public Articulo(int id, String lgac, String titulo, Integrante integrante){
        super(id, lgac, titulo, integrante);
        this.setTipoProducto("articulo");
    }
    
    public Articulo(){
        this.setTipoProducto("articulo");
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
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

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getPaginas() {
        return paginas;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
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
