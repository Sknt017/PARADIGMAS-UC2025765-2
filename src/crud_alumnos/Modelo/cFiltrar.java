/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud_alumnos.Modelo;

import crud_alumnos.controlador.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dasan
 */
public class cFiltrar {
    //Crear un Método para Mostrar los Estudiantes de la BD
    public void mostrarEstudiantes(JTable tblEstudiantes, String valorEspecifico, String Opcion){
        //Conectar con la BD
        Conexion cn = new Conexion();
        //Crear un objeto para manejar la tabla
        DefaultTableModel modelo = new DefaultTableModel();
        //Crear una variable para el manejo de la instrucción SQL
        String sql;
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
        sql = "SELECT * FROM Estudiantes WHERE "+ Opcion + " LIKE '%"+valorEspecifico+"%';";
        //Crear un vector para guardar los campos de cada registro de la BD
        System.out.println(sql);
        //Crear una variable tipo statement
        Statement st;
        try{
            st = cn.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);//st.executeQuery(sql);
            String [] datos = new String[rs.getFetchSize()];
            //Recorrer el paquete de datos que esta en rs  y cargamos el vector             
            while (rs.next()){
                for(int i = 0; i<rs.getFetchSize();i++){
                    datos[i] = rs.getString(i+1);
                    modelo.addRow(datos);
                }
            }
            tblEstudiantes.setModel(modelo);
        }catch(Exception er)
        {
            JOptionPane.showMessageDialog(null,"Error: " + er.getMessage());
        }        
    }
}
