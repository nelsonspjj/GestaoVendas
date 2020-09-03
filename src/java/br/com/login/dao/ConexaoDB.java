package br.com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

	private static Connection gConn = null;
	public static Connection getConnection()
	{
            if(gConn != null) 
                return gConn;
            else
            {
                try
                {
                    String lURL = "jdbc:sqlserver://localhost:65070"+";databaseName=JUser";

                    String lDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                    String lDBUsuario = "sa";
                    String lDBSenha = "King123";
                    Class.forName(lDriver);
                    gConn = DriverManager.getConnection(lURL, lDBUsuario, lDBSenha);
                }
                catch (ClassNotFoundException e) 
                {
                    e.printStackTrace();
                }
                catch (SQLException e) 
                {
                    e.printStackTrace();

                }
                return gConn;
            }
		
	}
}