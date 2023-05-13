package br.com.ifrs.frete.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() {
        try {
            // drive MySql Conector 5.0
            //Class.forName("com.mysql.jdbc.Driver");
            // drive MySql Conector 8.0.30
            Class.forName("com.mysql.cj.jdbc.Driver");
            String urlBD="jdbc:mysql://172.17.0.1:3306/db";
            return DriverManager.getConnection(urlBD, "leo", "leo");
        } catch (SQLException e) {
            System.out.println("Exceção SQL" + e.getMessage());
        } catch(ClassNotFoundException e){
            System.out.println("Exceção Classe não encontrada");
        }
        return null;
    }
}
