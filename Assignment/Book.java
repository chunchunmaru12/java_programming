package Assignment;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Book extends JFrame {

    private JComboBox<String> categoryComboBox;
    private JTable bookTable;
    private DefaultTableModel tableModel;
    private Connection connection;

    public Book() {
        setTitle("Book Category Application");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        connectToDatabase();
        categoryComboBox = new JComboBox<>();
        loadCategories();

        categoryComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadBooksByCategory((String) categoryComboBox.getSelectedItem());
            }
        });
        add(categoryComboBox, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new String[] { "Book ID", "Title", "Author", "ISBN" }, 0);
        bookTable = new JTable(tableModel);
        add(new JScrollPane(bookTable), BorderLayout.CENTER);

        setVisible(true);
    }

    private void loadCategories() {
        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT DISTINCT name FROM category")) {
            while (rs.next()) {
                categoryComboBox.addItem(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void connectToDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadBooksByCategory(String category) {
        tableModel.setRowCount(0);
        String query = "SELECT b.id, b.title, b.author, b.isbn FROM book b JOIN category c ON b.category_id = c.id WHERE c.name = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, category);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tableModel.addRow(new Object[] { rs.getInt("id"), rs.getString("title"), rs.getString("author"),
                        rs.getString("isbn") });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Book::new);
    }
}