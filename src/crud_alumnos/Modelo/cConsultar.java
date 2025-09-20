package crud_alumnos.Modelo;
//@author GNT

//import crud_alumnos.Controlador.Conexion;
import crud_alumnos.controlador.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class cConsultar {
    //Crear un Método para Mostrar los Estudiantes de la BD
    public void mostrarEstudiantes(JTable tblEstudiantes)
    {
        //Conectar con la BD
        Conexion cn = new Conexion();
        //Crear un objeto para manejar la tabla
        DefaultTableModel modelo = new DefaultTableModel();
        //Crear una variable para el manejo de la instrucción SQL
        String sql = "";
        //Crear títulos de las columnas de la Tabla
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Celular");
        modelo.addColumn("Correo");
        modelo.addColumn("Programa");
        modelo.addColumn("Semestre");
        //Llevar los titulos a la tabla como tal
        tblEstudiantes.setModel(modelo);
        //Crear la instrucción SQL
        sql = "SELECT * FROM T_Alumnos";
        //Crear un vector para guardar los campos de cada registro de la BD
        String [] datos = new String[7];
        //Crear una variable tipo statement
        Statement st;
        try
        {
            st = cn.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            //Recorrer el paquete de datos que esta en rs  y cargamos el vector 
            while (rs.next())
            {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                modelo.addRow(datos);
            }
            tblEstudiantes.setModel(modelo);
        }catch(Exception er)
        {
            JOptionPane.showMessageDialog(null,"Error!! No se encontro la tabla/BD " + er.getMessage());
        }
        
    }
    
}
