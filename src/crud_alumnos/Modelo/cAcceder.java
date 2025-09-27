/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud_alumnos.Modelo;

import crud_alumnos.controlador.Conexion;
import javax.swing.JOptionPane;

/**
 *
 * @author LEXFORGAR
 */
public class cAcceder {

    public void validarAcceso(String userName, String passw) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String sql = "";
        Conexion cn = new Conexion();
        try {
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error en base de datos: "+ e);
        }
    }
    
}
