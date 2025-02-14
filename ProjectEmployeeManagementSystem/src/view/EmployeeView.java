package view;

import controller.EmployeeController;
import model.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class EmployeeView extends JFrame {
    private EmployeeController controller = new EmployeeController();
    
    private JTextField txtId, txtName, txtDepartment, txtSalary;
    private JTextArea txtAreaDisplay;
    
    public EmployeeView() {
        setTitle("Employee Management System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Top Panel: Form Inputs
        JPanel panelInput = new JPanel(new GridLayout(5, 2, 5, 5));
        panelInput.setBorder(BorderFactory.createTitledBorder("Employee Details"));
        
        panelInput.add(new JLabel("ID:"));
        txtId = new JTextField();
        panelInput.add(txtId);
        
        panelInput.add(new JLabel("Name:"));
        txtName = new JTextField();
        panelInput.add(txtName);
        
        panelInput.add(new JLabel("Department:"));
        txtDepartment = new JTextField();
        panelInput.add(txtDepartment);
        
        panelInput.add(new JLabel("Salary:"));
        txtSalary = new JTextField();
        panelInput.add(txtSalary);
        
        add(panelInput, BorderLayout.NORTH);
        
        // Center Panel: Display Area
        txtAreaDisplay = new JTextArea();
        txtAreaDisplay.setEditable(false);
        add(new JScrollPane(txtAreaDisplay), BorderLayout.CENTER);
        
        // Bottom Panel: Buttons
        JPanel panelButtons = new JPanel(new GridLayout(1, 5, 5, 5));
        
        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(this::addEmployee);
        panelButtons.add(btnAdd);
        
        JButton btnView = new JButton("View");
        btnView.addActionListener(this::viewEmployee);
        panelButtons.add(btnView);
        
        JButton btnViewAll = new JButton("View All");
        btnViewAll.addActionListener(this::viewAllEmployees);
        panelButtons.add(btnViewAll);
        
        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(this::updateEmployee);
        panelButtons.add(btnUpdate);
        
        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(this::deleteEmployee);
        panelButtons.add(btnDelete);
        
        add(panelButtons, BorderLayout.SOUTH);
    }
    
    private void addEmployee(ActionEvent e) {
        String name = txtName.getText();
        String department = txtDepartment.getText();
        double salary = Double.parseDouble(txtSalary.getText());
        controller.addEmployee(name, department, salary);
        txtAreaDisplay.setText("Employee Added Successfully!");
    }
    
    private void viewEmployee(ActionEvent e) {
        int id = Integer.parseInt(txtId.getText());
        Employee emp = controller.getEmployee(id);
        if (emp != null) {
            txtAreaDisplay.setText("ID: " + emp.getId() + "\nName: " + emp.getName() + 
                                   "\nDepartment: " + emp.getDepartment() + "\nSalary: " + emp.getSalary());
        } else {
            txtAreaDisplay.setText("Employee not found!");
        }
    }
    
    private void viewAllEmployees(ActionEvent e) {
        List<Employee> employees = controller.getAllEmployees();
        StringBuilder sb = new StringBuilder();
        for (Employee emp : employees) {
            sb.append(emp.getId()).append(" - ").append(emp.getName()).append(" - ")
              .append(emp.getDepartment()).append(" - ").append(emp.getSalary()).append("\n");
        }
        txtAreaDisplay.setText(sb.toString());
    }
    
    private void updateEmployee(ActionEvent e) {
        int id = Integer.parseInt(txtId.getText());
        String name = txtName.getText();
        String department = txtDepartment.getText();
        double salary = Double.parseDouble(txtSalary.getText());
        controller.updateEmployee(id, name, department, salary);
        txtAreaDisplay.setText("Employee Updated Successfully!");
    }
    
    private void deleteEmployee(ActionEvent e) {
        int id = Integer.parseInt(txtId.getText());
        controller.deleteEmployee(id);
        txtAreaDisplay.setText("Employee Deleted Successfully!");
    }
    
    
}
