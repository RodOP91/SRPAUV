package DAO;

import srpauv.clases.Proyecto;

/**
 *
 * @author edson
 */
public class ProyectoDAO {
    public static boolean registrar(Proyecto proyecto){
        Conexion conn = new Conexion();
        String sql = "INSERT INTO `proyecto`(`fechaInicio`, `fechaFin`, `ca`, "
                + "`lgac`, `patrocinador`, `numMiembros`, `tipoPatrocinador`, "
                + "`tituloProyecto`, `idIntegrante`) VALUES "
                + "( '"+proyecto.getFechaInicio()+"','"+proyecto.getFechaFin()+"'"
                + ","+proyecto.isCa()+",'"+proyecto.getLgac()+"','"+proyecto.getPatrocinador()+"'"
                + ","+proyecto.getNumMiembros()+",'"+proyecto.getTipoPatrocinador()+"'"
                + ",'"+proyecto.getTituloProyecto()+"',"+proyecto.getIdIntegrante()+")";
        int flag = conn.ejecutar(sql);
        conn.cerrar();
        return flag == 0;
    }
}
