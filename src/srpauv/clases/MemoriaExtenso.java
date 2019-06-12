package srpauv.clases;

import DAO.ProductosDAO;

/**
 *
 * @author ferzo
 */
public class MemoriaExtenso extends Producto{
    private String autor; 
    private String congreso;
    private String estadoGeo;
    private String ciudad;
    private String rangopags;
    private String pais;
    private String ano;
    private String proposito;

    public MemoriaExtenso(String autor, String congreso, String estadoGeo, 
            String ciudad, String rangopags, String pais, String ano, 
            String proposito, int idProducto, boolean considerarCA, String lgac, 
            String titulo, String estado, int idProyecto, String tipoProducto) {
        super(idProducto, considerarCA, lgac, titulo, estado, idProyecto, tipoProducto);
        this.autor = autor;
        this.congreso = congreso;
        this.estadoGeo = estadoGeo;
        this.ciudad = ciudad;
        this.rangopags = rangopags;
        this.pais = pais;
        this.ano = ano;
        this.proposito = proposito;
    }
    
    public MemoriaExtenso(int id, String lgac, String titulo, Integrante integrante){
        super(id, lgac, titulo, integrante);
        this.setTipoProducto("memoriaExtenso");
    }
    
    public MemoriaExtenso(){
        this.setTipoProducto("memoriaExtenso");
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

    public String getCongreso() {
        return congreso;
    }

    public void setCongreso(String congreso) {
        this.congreso = congreso;
    }

    public String getEstadoG() {
        return getEstadoGeo();
    }

    public void setEstadoG(String estado) {
        this.setEstadoGeo(estado);
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

    /**
     * @return the estadoGeo
     */
    public String getEstadoGeo() {
        return estadoGeo;
    }

    /**
     * @param estadoGeo the estadoGeo to set
     */
    public void setEstadoGeo(String estadoGeo) {
        this.estadoGeo = estadoGeo;
    }
    
}
