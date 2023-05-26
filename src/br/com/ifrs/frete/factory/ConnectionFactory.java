package br.com.ifrs.frete.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;

public class ConnectionFactory {
    public Connection getConnection() {
        String ip = "20.20.0.1";
        String port = "3306";
        String database = "db";
        String drive = "mysql";
        try {
            // drive MySql Conector 5.0
            Class.forName("com.mysql.jdbc.Driver");
            // drive MySql Conector 8.0.30
            //Class.forName("com.mysql.cj.jdbc.Driver");
            String urlBD="jdbc:"+drive+"://"+ip+":"+port+"/"+database;
            return DriverManager.getConnection(urlBD, "leo", "leo");
        } catch (SQLTimeoutException e){
            System.out.println("Excedeu o tempo limite: Time-out" + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Exceção SQL " + e.getMessage());
        } catch(ClassNotFoundException e){
            System.out.println("Exceção driver não encontrado");
        }
        return null;
    }
}
