/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud_alumnos.controlador;

import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author dasan
 */
public class exportarCSV {
    public static void exportToCSV(JTable table, String filePath) {
        try (FileWriter csvWriter = new FileWriter(filePath)) {
            TableModel model = table.getModel();

            // Write column headers
            for (int i = 0; i < model.getColumnCount(); i++) {
                csvWriter.write(model.getColumnName(i) + (i < model.getColumnCount() - 1 ? "," : ""));
            }
            csvWriter.write("\n");

            // Write rows
            for (int row = 0; row < model.getRowCount(); row++) {
                for (int col = 0; col < model.getColumnCount(); col++) {
                    csvWriter.write(model.getValueAt(row, col).toString() + (col < model.getColumnCount() - 1 ? "," : ""));
                }
                csvWriter.write("\n");
            }

            csvWriter.flush();
            JOptionPane.showMessageDialog(null, "Datos exportados a  " + filePath);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error exportando los datos: " + e.getMessage());
        }
    }
}
