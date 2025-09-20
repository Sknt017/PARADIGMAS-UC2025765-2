
package crud_alumnos.Modelo;

import crud_alumnos.controlador.Conexion;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author dasan
 */
public class cActualizar {
    public void actualizar(String idf,String nomf,String apef, String celf, String corf,String progf,String semf){
        int intidf = Integer.parseInt(idf);
        Conexion objcn = new Conexion();
        String sql = "";
        sql = "UPDATE T_Alumnos SET nombre=?, apellido=?, Celular=? , Correo=?, programa=?, Semestre=? WHERE ID=  ?";
        try{
            PreparedStatement pst = objcn.conectar().prepareStatement(sql);
            //reemplazando los signos de interrogacion
            pst.setString(1,nomf);
            pst.setString(2,apef);
            pst.setString(3,celf);
            pst.setString(4,corf);
            pst.setString(5,progf);
            pst.setString(6,semf);
            pst.setString(7,idf);
            // ejecutar
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "registro actualizado. ");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "error en actualizacion de registro"+e);
        }
    
    }    
}
