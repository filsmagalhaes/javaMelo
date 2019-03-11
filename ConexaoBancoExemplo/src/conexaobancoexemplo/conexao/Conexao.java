/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaobancoexemplo.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author aluno
 */
public class Conexao {
    private Statement stmt;
    public Connection conn;
    private final String DRIVER_MYSQL = "com.mysql.jdbc.Driver";
    private final String DRIVER_POSTGRESQL = "org.postgresql.Driver";
    private final String DRIVER_SQLSERVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String LOCAL_SERVIDOR = "localhost";
    private final String BANCO_DE_DADOS = "TeAmoProfessorMelo";
    private final String PORTA_BANCO = "3306";
    private final String USUARIO = "root";
    private final String SENHA = "";

    public Connection conectar() throws Exception {
        return this.conectarMySql();
    }

    public void desconectar() throws SQLException {
        conn.close();
    }

    private Connection conectarPostGreSql() throws Exception {
        Class.forName(DRIVER_POSTGRESQL);
        String url = "jdbc:postgresql://"+ LOCAL_SERVIDOR + "/" + BANCO_DE_DADOS+ "?charSet=LATIN1";
        conn = DriverManager.getConnection(url, USUARIO, SENHA);
        return conn;
    }

    private Connection conectarSqlServer() throws Exception {
        Class.forName(DRIVER_SQLSERVER);
        String url = "jdbc:sqlserver://"+LOCAL_SERVIDOR+":"+PORTA_BANCO+";DatabaseName="+BANCO_DE_DADOS;
        conn = DriverManager.getConnection(url, USUARIO, SENHA);
        return conn;
    }

    private Connection conectarMySql() throws Exception {
        Class.forName(DRIVER_MYSQL).newInstance();
        String url = "jdbc:mysql://"+LOCAL_SERVIDOR+":"+PORTA_BANCO+"/"+BANCO_DE_DADOS;
        conn = (Connection) DriverManager.getConnection(url , USUARIO, SENHA);
        return conn;
    }
}
