package collections;

import java.sql.*;

public class ConnectionMod {
    public Connection conecta() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/highlux", "root", "root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
