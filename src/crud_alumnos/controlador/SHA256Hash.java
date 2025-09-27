/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud_alumnos.controlador;

import java.security.MessageDigest;

/**
 *
 * @author dasan
 */
public class SHA256Hash {
    public static String hashWithSHA256(String input) {
        try {
            // Get an instance of the SHA-256 algorithm
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            
            // Perform the hashing
            byte[] hashBytes = digest.digest(input.getBytes("UTF-8"));
            
            // Convert the byte array into a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error while hashing with SHA-256", e);
        }
    }

}
