package com.mycompany.basededatosad;

import java.sql.*;

public class BaseDeDatosAD {

    //Declaro constantes para la URL de la base de datos
    static final String DB_URL = "jdbc:mysql://localhost:3306/jcvd";
    static final String USER = "dam2";
    static final String PASS = "1234";
    static final String QUERY = "SELECT * FROM videojuegos";

    public static void main(String[] args) {
        //Establezco la conexion con la base de datos
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
             //Creo un objeto Statement para enviar consultas a la base de datos
             Statement stmt = conn.createStatement()) {

            //Creo una consulta SQL para insertar un nuevo registro en la tabla videojuegos
            String insertQuery = "INSERT INTO videojuegos "
            + "(Nombre, Genero, FechaLanzamiento, Compañia, Precio) VALUES "
            + "('Pokemon', 'Plataforma', '2018-06-01', 'Nintendo', 19.99)";
            stmt.executeUpdate(insertQuery); //Ejecuto la consulta de inserción
            //Ejecuto la consulta QUERY y guarda el resultado en rs
            ResultSet rs = stmt.executeQuery(QUERY); 
            while (rs.next()) {
                //Imprimo los datos de cada columna de la fila actual
                System.out.println("-ID:" + rs.getInt("id"));
                System.out.println(", Nombre:" + rs.getString("Nombre"));
                System.out.println(", Genero:" + rs.getString("Genero"));
                System.out.println(", FechaLanzamiento:" + rs.getDate("FechaLanzamiento"));
                System.out.println(", Compañia:" + rs.getString("Compañia"));
                System.out.println(", Precio:" + rs.getFloat("Precio"));
            }
          stmt.close(); //Cierro el objeto Statement
        } catch (SQLException e) {
            e.printStackTrace(); //Imprimo la excepción en caso de error
        }
    }
}
