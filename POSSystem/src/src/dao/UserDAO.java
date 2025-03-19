package src.dao;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import src.DBConnection;

public class UserDAO {
    public boolean authenticate(String username, String password) {
        String sql = "SELECT password_hash FROM users WHERE username = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String storedHash = rs.getString("password_hash");
                    String passwordHash = hashPassword(password);
                    return storedHash.equals(passwordHash);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    private String hashPassword(String password) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("SHA-256");
    byte[] hashBytes = md.digest(password.getBytes());
    StringBuilder sb = new StringBuilder();
    for (byte b : hashBytes) {
        sb.append(String.format("%02x", b));
    }
    return sb.toString();
}

}
