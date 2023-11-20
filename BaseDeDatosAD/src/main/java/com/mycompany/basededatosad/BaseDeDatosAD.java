package com.mycompany.basededatosad;

import java.sql.*;

public class BaseDeDatosAD {

    static final String DB_URL = "jdbc:mysql://localhost:3306/jcvd";
    static final String USER = "dam2";
    static final String PASS = "1234";
    static final String QUERY = "SELECT * FROM videojuegos";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            String insertQuery = "INSERT INTO videojuegos "
            + "(Nombre, Genero, FechaLanzamiento, Compañia, Precio) VALUES "
            + "('Pokemon', 'Plataforma', '2018-06-01', 'Nintendo', 19.99)";
            stmt.executeUpdate(insertQuery);

            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                System.out.println("-ID:" + rs.getInt("id"));
                System.out.println(", Nombre:" + rs.getString("Nombre"));
                System.out.println(", Genero:" + rs.getString("Genero"));
                System.out.println(", FechaLanzamiento:" + rs.getDate("FechaLanzamiento"));
                System.out.println(", Compañia:" + rs.getString("Compañia"));
                System.out.println(", Precio:" + rs.getFloat("Precio"));
            }
          stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
