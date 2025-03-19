/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import src.dao.SalesDAO;
import src.models.Sale;
import java.util.List;

public class ReportPanel extends JPanel {
    private JTable reportTable;
    private DefaultTableModel reportTableModel;
    private JButton refreshButton, exportButton;
    private SalesDAO salesDAO = new SalesDAO();
    
    public ReportPanel() {
        setLayout(new BorderLayout());
        reportTableModel = new DefaultTableModel(new String[]{"Sale ID", "Date", "Total Amount", "Payment Method"}, 0);
        reportTable = new JTable(reportTableModel);
        add(new JScrollPane(reportTable), BorderLayout.CENTER);
        
        JPanel bottomPanel = new JPanel();
        refreshButton = new JButton("Refresh Report");
        exportButton = new JButton("Export CSV");
        bottomPanel.add(refreshButton);
        bottomPanel.add(exportButton);
        add(bottomPanel, BorderLayout.SOUTH);
        
        refreshButton.addActionListener(e -> loadReport());
        exportButton.addActionListener(e -> exportCSV());
        
        loadReport();
    }
    
    private void loadReport() {
        reportTableModel.setRowCount(0);
        List<Sale> sales = salesDAO.getAllSales();
        for (Sale sale : sales) {
            reportTableModel.addRow(new Object[]{
                sale.getId(),
                sale.getDate(),
                sale.getTotalAmount(),
                sale.getPaymentMethod()
            });
        }
    }
    
    private void exportCSV() {
    // Retrieve the sales data again (or use the already loaded data)
    List<Sale> sales = salesDAO.getAllSales();
    if (sales == null || sales.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No data to export.");
        return;
    }
    
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Save CSV Report");
    int userSelection = fileChooser.showSaveDialog(this);
    if (userSelection == JFileChooser.APPROVE_OPTION) {
        File fileToSave = fileChooser.getSelectedFile();
        // Ensure the file name ends with .csv
        if (!fileToSave.getName().toLowerCase().endsWith(".csv")) {
            fileToSave = new File(fileToSave.getAbsolutePath() + ".csv");
        }
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileToSave))) {
            // Write header
            writer.println("Sale ID,Date,Total Amount,Payment Method");
            // Write each sale record
            for (Sale sale : sales) {
                writer.printf("%d,%s,%.2f,%s%n",
                        sale.getId(),
                        sale.getDate().toString(),
                        sale.getTotalAmount(),
                        sale.getPaymentMethod());
            }
            JOptionPane.showMessageDialog(this, "CSV exported successfully to: " + fileToSave.getAbsolutePath());
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error exporting CSV: " + ex.getMessage());
        }
    }
}

}
