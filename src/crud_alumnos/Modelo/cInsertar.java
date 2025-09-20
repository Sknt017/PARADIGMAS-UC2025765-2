package crud_alumnos.Modelo;

import crud_alumnos.controlador.Conexion;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 * @author dasan
 */
public class cInsertar {
    public void Adicion(String idf, String nfr, String afr, String cefr, String cofr, String pfr, String sfr){
        Conexion cn = new Conexion();
        //variable para construir la instruccion SQL
        String sql = "INSERT INTO T_Alumnos (ID,Nombre,Apellido,Celular,Correo,Programa,Semestre)VALUES(?,?,?,?,?,?,?)";
        //prepara la conexion para la instruccion sql
        try{
            //prepara instruccion como instruccion sql
            PreparedStatement pst = cn.conectar().prepareStatement(sql);
            //asignar las ariables que remplazaran los signos de interrogacion
            pst.setString(1, idf);
            pst.setString(2, nfr);
            pst.setString(3, afr);
            pst.setString(4, cefr);
            pst.setString(5, cofr);
            pst.setString(6, pfr);
            pst.setString(7, sfr);
            //Ejecutar la instruccion sql:
            pst.execute();
            JOptionPane.showMessageDialog(null, "¡OK! Registro ingresado");
            cn.desconectar();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error en insercion de registro: " + e);
        }
        
    }
    
}
