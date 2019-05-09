/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleatendimento.conexao;

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
    private final String LOCAL_SERVIDOR = "localhost";
    private final String BANCO_DE_DADOS = "controleatendimento";
    private final String PORTA_BANCO = "3306";
    private final String USUARIO = "root";
    private final String SENHA = "4321";

    public Connection conectar() throws Exception {
        return this.conectarMySql();
    }

    public void desconectar() throws SQLException {
        conn.close();
    }
    
    
     private Connection conectarMySql() throws Exception {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://"+"localhost"+":"+"3306"+"/"+"controleatendimento";
        conn = (Connection) DriverManager.getConnection(url , "root", "4321");
        return conn;
    }
     
 }
  
     
     
     //OUTRAS FORMAS DE CONEXÃO:
     
     /*
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
    } */

   
    
 