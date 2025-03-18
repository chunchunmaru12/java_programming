
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BillingSystem {

    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;
    private JTextField searchField, nameField, priceField, qtyField, totalField;
    private JButton addButton, createBillButton, resetButton, searchButton;
    private Connection conn;

    public BillingSystem() {
        initializeUI();
        connectDatabase();
        addActionListeners();
    }

    private void initializeUI() {
        frame = new JFrame("Billing System");
        frame.setSize(800, 600);
        frame.setLayout(null);

        // Search components
        JLabel lblSearch = new JLabel("Search ID:");
        lblSearch.setBounds(500, 20, 80, 25);
        frame.add(lblSearch);

        searchField = new JTextField();
        searchField.setBounds(580, 20, 100, 25);
        frame.add(searchField);

        searchButton = new JButton("Search");
        searchButton.setBounds(690, 20, 80, 25);
        frame.add(searchButton);

        // Product details fields
        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(500, 60, 80, 25);
        frame.add(lblName);

        nameField = new JTextField();
        nameField.setBounds(580, 60, 150, 25);
        frame.add(nameField);

        JLabel lblPrice = new JLabel("Price:");
        lblPrice.setBounds(500, 100, 80, 25);
        frame.add(lblPrice);

        priceField = new JTextField();
        priceField.setBounds(580, 100, 150, 25);
        frame.add(priceField);

        JLabel lblQty = new JLabel("Quantity:");
        lblQty.setBounds(500, 140, 80, 25);
        frame.add(lblQty);

        qtyField = new JTextField();
        qtyField.setBounds(580, 140, 150, 25);
        frame.add(qtyField);

        // Table setup
        model = new DefaultTableModel(new String[]{"S.N.", "Item", "Price", "Qty", "Tax", "Subtotal"}, 0);
        table = new JTable(model);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(20, 20, 450, 400);
        frame.add(pane);

        // Buttons
        addButton = new JButton("Add");
        addButton.setBounds(500, 220, 80, 25);
        frame.add(addButton);

        createBillButton = new JButton("Create BILL");
        createBillButton.setBounds(20, 450, 150, 30);
        frame.add(createBillButton);

        resetButton = new JButton("Reset");
        resetButton.setBounds(200, 450, 150, 30);
        resetButton.addActionListener(e -> resetFields());
        frame.add(resetButton);

        frame.setVisible(true);
    }

    private void connectDatabase() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/billing_db", "root", "noorkhan786");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "Database connection failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addActionListeners() {
        searchButton.addActionListener(e -> searchProduct());
        addButton.addActionListener(e -> addProduct());
        createBillButton.addActionListener(e -> createBill());
    }

    private void searchProduct() {
    String id = searchField.getText().trim();
    if (id.isEmpty()) {
        JOptionPane.showMessageDialog(frame, "Please enter a product ID.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        int productId = Integer.parseInt(id); // Ensure the ID is a valid integer
        String query = "SELECT * FROM products WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, productId);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            // Debug: Print fetched product details
            System.out.println("Product found: " + rs.getString("name") + ", " + rs.getDouble("price"));
            nameField.setText(rs.getString("name"));
            priceField.setText(String.format("%.2f", rs.getDouble("price")));
        } else {
            JOptionPane.showMessageDialog(frame, "Product not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(frame, "Invalid product ID. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(frame, "Error searching product: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    private void addProduct() {
        try {
            double price = Double.parseDouble(priceField.getText());
            int qty = Integer.parseInt(qtyField.getText());
            double tax = price * qty * 0.1;
            double subtotal = (price * qty) + tax;

            model.addRow(new Object[]{
                model.getRowCount() + 1,
                nameField.getText(),
                price,
                qty,
                tax,
                subtotal
            });
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid price or quantity.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createBill() {
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(frame, "No items to create bill.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double totalAmount = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            totalAmount += (double) model.getValueAt(i, 5);
        }

        try {
            conn.setAutoCommit(false);

            // Insert bill
            String billSql = "INSERT INTO bills (total_amount) VALUES (?)";
            PreparedStatement billStmt = conn.prepareStatement(billSql, Statement.RETURN_GENERATED_KEYS);
            billStmt.setDouble(1, totalAmount);
            billStmt.executeUpdate();

            // Get generated bill ID
            int billId;
            try (ResultSet rs = billStmt.getGeneratedKeys()) {
                if (rs.next()) {
                    billId = rs.getInt(1);
                } else {
                    throw new SQLException("Creating bill failed, no ID obtained.");
                }
            }

            // Insert bill items
            String itemSql = "INSERT INTO bill_items (bill_id, product_name, price, quantity, tax, subtotal) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement itemStmt = conn.prepareStatement(itemSql);

            for (int i = 0; i < model.getRowCount(); i++) {
                String productName = (String) model.getValueAt(i, 1);
                double price = (double) model.getValueAt(i, 2);
                int quantity = (int) model.getValueAt(i, 3);
                double tax = (double) model.getValueAt(i, 4);
                double subtotal = (double) model.getValueAt(i, 5);

                itemStmt.setInt(1, billId);
                itemStmt.setString(2, productName);
                itemStmt.setDouble(3, price);
                itemStmt.setInt(4, quantity);
                itemStmt.setDouble(5, tax);
                itemStmt.setDouble(6, subtotal);
                itemStmt.addBatch();
            }

            itemStmt.executeBatch();
            conn.commit();

            // Display bill details
            showBillDetails(billId, totalAmount);

            JOptionPane.showMessageDialog(frame, "Bill created successfully! Bill ID: " + billId, "Success", JOptionPane.INFORMATION_MESSAGE);
            resetFields();

            billStmt.close();
            itemStmt.close();
        } catch (SQLException ex) {
            try {
                conn.rollback();
                JOptionPane.showMessageDialog(frame, "Error creating bill: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void showBillDetails(int billId, double totalAmount) {
        JFrame billFrame = new JFrame("Bill Details - ID: " + billId);
        billFrame.setSize(600, 400);
        billFrame.setLayout(new BorderLayout());

        DefaultTableModel billModel = new DefaultTableModel(new String[]{"Item", "Price", "Qty", "Tax", "Subtotal"}, 0);
        for (int i = 0; i < model.getRowCount(); i++) {
            billModel.addRow(new Object[]{
                model.getValueAt(i, 1),
                model.getValueAt(i, 2),
                model.getValueAt(i, 3),
                model.getValueAt(i, 4),
                model.getValueAt(i, 5)
            });
        }

        JTable billTable = new JTable(billModel);
        JScrollPane scrollPane = new JScrollPane(billTable);
        billFrame.add(scrollPane, BorderLayout.CENTER);

        JLabel totalLabel = new JLabel(String.format("Total Amount: $%.2f", totalAmount));
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(totalLabel);
        billFrame.add(bottomPanel, BorderLayout.SOUTH);

        billFrame.setVisible(true);
    }

    private void resetFields() {
        model.setRowCount(0);
        searchField.setText("");
        nameField.setText("");
        priceField.setText("");
        qtyField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BillingSystem::new);
    }
}
