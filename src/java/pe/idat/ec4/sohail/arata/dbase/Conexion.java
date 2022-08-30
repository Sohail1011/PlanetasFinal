package pe.idat.ec4.sohail.arata.dbase;

import java.sql.*;

public class Conexion {

    public static Connection MyConnect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema", "root", "admin");
        return c;
    }
}
