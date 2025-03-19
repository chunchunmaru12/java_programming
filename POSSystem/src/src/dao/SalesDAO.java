 
package src.dao;

import java.sql.*;
import src.models.Sale;
import src.models.SaleItem;
import java.util.List;
import java.util.ArrayList;
import src.DBConnection;

public class SalesDAO {
    public int insertSale(Sale sale) {
        String sql = "INSERT INTO sales (total_amount, payment_method) VALUES (?, ?)";
        int saleId = -1;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
             
            pstmt.setDouble(1, sale.getTotalAmount());
            pstmt.setString(2, sale.getPaymentMethod());
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        saleId = rs.getInt(1);
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return saleId;
    }
    
    public boolean insertSaleItems(List<SaleItem> saleItems) {
        String sql = "INSERT INTO sales_items (sale_id, product_id, quantity, subtotal) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            for (SaleItem item : saleItems) {
                pstmt.setInt(1, item.getSaleId());
                pstmt.setInt(2, item.getProductId());
                pstmt.setInt(3, item.getQuantity());
                pstmt.setDouble(4, item.getSubtotal());
                pstmt.addBatch();
            }
            int[] rows = pstmt.executeBatch();
            for (int row : rows) {
                if (row == Statement.EXECUTE_FAILED) {
                    return false;
                }
            }
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public List<Sale> getAllSales() {
        List<Sale> sales = new ArrayList<>();
        String sql = "SELECT * FROM sales";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
             
            while(rs.next()){
                Sale sale = new Sale(
                    rs.getInt("id"),
                    rs.getTimestamp("date"),
                    rs.getDouble("total_amount"),
                    rs.getString("payment_method")
                );
                sales.add(sale);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return sales;
    }
}
