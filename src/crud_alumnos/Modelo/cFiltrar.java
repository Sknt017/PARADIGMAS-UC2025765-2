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
        //Crear la instrucción SQL
//        switch (Opcion) {
//            case "ID":
//            case "Nombre":
//            case "Apellido":
//            case "Correo":
//            case "Celular":
//            case "Programa":
//            case "Semestre":
//                
//                break;
//            default:
//                throw new AssertionError();
//        }
        sql = "SELECT * FROM Estudiantes WHERE "+ Opcion + " LIKE '%"+valorEspecifico+"%';";
        //Crear un vector para guardar los campos de cada registro de la BD
        System.out.println(sql);
        //Crear una variable tipo statement
        Statement st;
        try{
            //PreparedStatement pst = objcn.conectar().prepareStatement(sql);            
            //reemplazando los signos de interrogacion
//            pst.setString(1,Opcion);
            st = cn.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);//st.executeQuery(sql);
            String [] datos = new String[rs.getFetchSize()];
            //Recorrer el paquete de datos que esta en rs  y cargamos el vector 
//            System.out.println(rs.getString(1));
            System.out.println(rs.getFetchSize());
            
            while (rs.next()){
                for(int i = 0; i<rs.getFetchSize();i++){
                    datos[i] = rs.getString(i+1);
                    modelo.addRow(datos);
                }
//                datos[0] = rs.getString(1);
//                datos[1] = rs.getString(2);
//                datos[2] = rs.getString(3);
//                datos[3] = rs.getString(4);
//                datos[4] = rs.getString(5);
//                datos[5] = rs.getString(6);
//                datos[6] = rs.getString(7);
//                modelo.addRow(datos);
            }
            tblEstudiantes.setModel(modelo);
        }catch(Exception er)
        {
            JOptionPane.showMessageDialog(null,"Error: " + er.getMessage());
        }
        
    }

}
