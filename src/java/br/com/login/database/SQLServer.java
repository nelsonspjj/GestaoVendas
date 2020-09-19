package br.com.login.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLServer {
    
    private Connection connection = null;

    public Connection getConnection() {
        String usuario = "sa";
        String senha = "";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=DeliveryDB;user=" + usuario + ";password=" + senha);
            if (connection != null) {
                System.out.println("CONECTADO COM SUCESSO!");
            } else {
                System.out.println("NÃO FOI POSSÍVEL CONECTAR AO BANCO DE DADOS.");
            }
            return connection;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }
}
