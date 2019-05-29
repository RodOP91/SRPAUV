/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srpauv.clases;

import DAO.IntegranteDAO;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author edson
 */
public class Integrante {
    private int idIntegrante;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String genero;
    private Date fechanacimiento;
    private String area;
    private String correoUV;
    private String correoAdicional;
    private String CURP;
    private String disciplina;
    private String estadoCivil;
    private String nacionalidad;
    private String noPersonal;
    private String rfc;
    private String telefonoCasa;
    private String telefonoTrabajo;
    
    private String usuario;
    private String password;
    private int responsable;

    public Integrante(int idIntegrante, String apellidoM, String apellidoP, String nombre, String genero,
            Date fechanacimiento, String area, String correoUV,String correoAdicional, 
            String curp, String disciplina, String edoCivil, String nacionalidad, String noPersonal,
            String rfc, String telcasa, String teltrabajo, String usuario, String password, int responsable){
        this.idIntegrante = idIntegrante;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.genero = genero;
        this.fechanacimiento = fechanacimiento;
        this.area = area;
        this.correoUV = correoUV;
        this.correoAdicional = correoAdicional;
        this.CURP = curp;
        this.disciplina = disciplina;
        this.estadoCivil = edoCivil;
        this.nacionalidad = nacionalidad;
        this.noPersonal = noPersonal;
        this.rfc = rfc;
        this.telefonoCasa = telcasa;
        this.telefonoTrabajo = teltrabajo;
        this.usuario = usuario;
        this.password = password;
        this.responsable = responsable;
    }

    public Integrante(int idIntegrante, String usuario) {
        this.idIntegrante = idIntegrante;
        this.usuario = usuario;
    }

    public Integrante(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }
    
    public Integrante(int idIntegrante, String nombre, String apellidoP, String apellidoM) {
        this.idIntegrante = idIntegrante;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
    }

    public Integrante(int idIntegrante, String nombre, String apellidoP) {
        this.idIntegrante = idIntegrante;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
    }

    public Integrante(String nombre, String apellidoP, String apellidoM, String usuario, String password) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.usuario = usuario;
        this.password = password;
    }
    
    public Integrante(String nombre, String apellidoP, String usuario, String password) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.usuario = usuario;
        this.password = password;
    }

    public Integrante(int idIntegrante, String nombre, String apellidoP, String apellidoM, String usuario, String password, int responsable) {
        this.idIntegrante = idIntegrante;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.usuario = usuario;
        this.password = password;
        this.responsable = responsable;
    }
    
    
    
    public boolean registrarIntegrante(){
        return IntegranteDAO.registrar(this);
    }
    
    
    @Override
    public String toString(){
        if(apellidoM == null){
            return nombre + " " + apellidoP;
        } else {
            return nombre + " " + apellidoP + " " + apellidoM;
        }
    }

    /**
     * @return the idIntegrante
     */
    public int getIdIntegrante() {
        return idIntegrante;
    }

    /**
     * @param idIntegrante the idIntegrante to set
     */
    public void setIdIntegrante(int idIntegrante) {
        this.idIntegrante = idIntegrante;
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
     * @return the apellidoP
     */
    public String getApellidoP() {
        return apellidoP;
    }

    /**
     * @param apellidoP the apellidoP to set
     */
    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    /**
     * @return the apellidoM
     */
    public String getApellidoM() {
        return apellidoM;
    }

    /**
     * @param apellidoM the apellidoM to set
     */
    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    
    
    /**
     * @return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return the correoUV
     */
    public String getCorreoUV() {
        return correoUV;
    }

    /**
     * @param correoUV the correoUV to set
     */
    public void setCorreoUV(String correoUV) {
        this.correoUV = correoUV;
    }

    /**
     * @return the correoAdicional
     */
    public String getCorreoAdicional() {
        return correoAdicional;
    }

    /**
     * @param correoAdicional the correoAdicional to set
     */
    public void setCorreoAdicional(String correoAdicional) {
        this.correoAdicional = correoAdicional;
    }

    /**
     * @return the CURP
     */
    public String getCURP() {
        return CURP;
    }

    /**
     * @param CURP the CURP to set
     */
    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    /**
     * @return the disciplina
     */
    public String getDisciplina() {
        return disciplina;
    }

    /**
     * @param disciplina the disciplina to set
     */
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    /**
     * @return the estadoCivil
     */
    public String getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * @param estadoCivil the estadoCivil to set
     */
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    /**
     * @return the nacionalidad
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * @param nacionalidad the nacionalidad to set
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     * @return the noPersonal
     */
    public String getNoPersonal() {
        return noPersonal;
    }

    /**
     * @param noPersonal the noPersonal to set
     */
    public void setNoPersonal(String noPersonal) {
        this.noPersonal = noPersonal;
    }

    /**
     * @return the rfc
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * @param rfc the rfc to set
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * @return the telefonoCasa
     */
    public String getTelefonoCasa() {
        return telefonoCasa;
    }

    /**
     * @param telefonoCasa the telefonoCasa to set
     */
    public void setTelefonoCasa(String telefonoCasa) {
        this.telefonoCasa = telefonoCasa;
    }

    /**
     * @return the telefonoTrabajo
     */
    public String getTelefonoTrabajo() {
        return telefonoTrabajo;
    }

    /**
     * @param telefonoTrabajo the telefonoTrabajo to set
     */
    public void setTelefonoTrabajo(String telefonoTrabajo) {
        this.telefonoTrabajo = telefonoTrabajo;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the responsable
     */
    public int getResponsable() {
        return responsable;
    }

    /**
     * @param responsable the responsable to set
     */
    public void setResponsable(int responsable) {
        this.responsable = responsable;
    }
}
