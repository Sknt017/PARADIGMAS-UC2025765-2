/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud_alumnos.Modelo;

import crud_alumnos.Vista.frmEstudiantes;
import crud_alumnos.controlador.Conexion;
import crud_alumnos.controlador.SHA256Hash;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author LEXFORGAR
 */
public class cAcceder {

    public boolean validarAcceso(String userName, String passw) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        //SHA256Hash hs = new SHA256Hash();
        String sql = "SELECT * FROM Usuarios WHERE Usuario = ?";
        Conexion cn = new Conexion();
        try {
            PreparedStatement pst = cn.conectar().prepareStatement(sql);
            pst.setString(1,userName);
            pst.execute();
            ResultSet resultSet = pst.getResultSet();
            String passwHashed = SHA256Hash.hashWithSHA256(passw);
            String bdpass = resultSet.getString(3);
//            System.out.println("bdpass:      "+resultSet.getString(3));
//            System.out.println("passwHashed: "+SHA256Hash.hashWithSHA256(passw));
            if(passwHashed.equals(bdpass)){
                JOptionPane.showMessageDialog(null, "acceso correcto");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "validar datos ingresados");
                return false;
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "error en base de datos: "+ e);
            return false;
        }
    }
    
}
