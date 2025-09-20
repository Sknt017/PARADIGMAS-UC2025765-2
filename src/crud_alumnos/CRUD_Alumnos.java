package crud_alumnos;

import crud_alumnos.Vista.frmEstudiantes;
import crud_alumnos.controlador.Conexion;

/**
 * @author dasan
 */
public class CRUD_Alumnos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        System.out.println("YATAAAAA!!!111");
        Conexion cn = new Conexion();
        
        cn.conectar();
        frmEstudiantes frmEst= new frmEstudiantes();
        frmEst.setVisible(true);
    }
    
}
