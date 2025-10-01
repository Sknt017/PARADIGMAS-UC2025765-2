package crud_alumnos.Modelo;
import crud_alumnos.controlador.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.swing.JOptionPane;
/**
 * @author dasan
 */
public class cInsertar {
    public void Adicion(String idf, String nfr, String afr, String cefr, String cofr, String pfr, String sfr){
        Conexion cn = new Conexion();

        // 1. Validación de campos vacíos
        if (idf == null || idf.trim().isEmpty() ||
            nfr == null || nfr.trim().isEmpty() ||
            afr == null || afr.trim().isEmpty() ||
            cefr == null || cefr.trim().isEmpty() ||
            cofr == null || cofr.trim().isEmpty() ||
            pfr == null || pfr.trim().isEmpty() ||
            sfr == null || sfr.trim().isEmpty()) {

            JOptionPane.showMessageDialog(null, 
                "No se permiten campos vacíos. Verifique los datos.", 
                "Error de validación", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 2. Validación de duplicados por ID
        try (Connection con = cn.conectar();
             PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM T_Alumnos WHERE ID = ?")) {
            
            ps.setString(1, idf);
            ResultSet rs = ps.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(null, 
                    "El ID ya existe en la base de datos.", 
                    "Error de duplicado", 
                    JOptionPane.ERROR_MESSAGE);
                cn.desconectar();
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                "Error al validar duplicados: " + e, 
                "Error de BD", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 3. Si pasa las validaciones, ejecutar el INSERT
        String sql = "INSERT INTO T_Alumnos (ID,Nombre,Apellido,Celular,Correo,Programa,Semestre) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.conectar().prepareStatement(sql);
            pst.setString(1, idf);
            pst.setString(2, nfr);
            pst.setString(3, afr);
            pst.setString(4, cefr);
            pst.setString(5, cofr);
            pst.setString(6, pfr);
            pst.setString(7, sfr);
            pst.execute();
            JOptionPane.showMessageDialog(null, "¡OK! Registro ingresado");
            cn.desconectar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en inserción de registro: " + e);
        }
    }
}