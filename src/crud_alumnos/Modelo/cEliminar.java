package crud_alumnos.Modelo;

import crud_alumnos.controlador.Conexion;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 * @author dasan
 */
public class cEliminar {
    public void Eliminando(String idf){
        String sql ="";
        sql ="DELETE FROM T_Alumnos WHERE ID = ?";
        // conectando a la bd
        Conexion objcn = new Conexion();
        try{
            PreparedStatement pst = objcn.conectar().prepareStatement(sql);
            pst.setString(1, idf);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "registro con id"+ idf + "eliminado");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error en la conexion xd: "+e);
        }
        
    }
}
