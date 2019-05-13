/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleatendimento.classesDados;

import controleatendimento.classesBasicas.Cliente;
import controleatendimento.conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class DadosCliente extends Conexao{
    
    //cpf, idade, idade_corrigida, descricao_diagnostico, data_nasc, nome
    
      
    /**
     * Criando CRUD: Insert
     */
    
  public void cadastrarCliente(Cliente client) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "INSERT INTO cliente (cpf_cli, idade, idade_corrigida, "
        + "data_nasc, nome_cli)  ";
        sql += " VALUES (?,?)";
        //preparando a instrução
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setInt(1, client.getCpf());
        preparedStatement.setString(2, client.getIdade());
        preparedStatement.setString(3, client.getIdade_corrigida());
        preparedStatement.setDate(4, client.getData_nasc());
        preparedStatement.setString(5, client.getNome());
                
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.desconectar();
    }  
  
  /**
     * Criando CRUD: Delete
     */
  
  public void removerCliente (Cliente client) throws SQLException, Exception {        
        String sql = "DELETE FROM cliente WHERE cpf_cli = ? ";        
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);        
        
        preparedStatement.setInt(1, client.getCpf());        
        
        preparedStatement.executeUpdate();        
        super.desconectar();
    }
  
   /**
     * Criando CRUD: Update
     */
  
      public void atualizarCliente(Cliente client) throws SQLException, Exception {       
        String sql = "UPDATE cliente SET nome_cli = ? WHERE cpf_cli = ? ";        
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        
        preparedStatement.setInt(1, client.getCpf());
        preparedStatement.setString(2, client.getIdade());
        preparedStatement.setString(3, client.getIdade_corrigida());
        preparedStatement.setDate(4, client.getData_nasc());
        preparedStatement.setString(5, client.getNome());
                
        preparedStatement.executeUpdate();        
        super.desconectar();
    }
  
       /**
     * Criando SELECT
     */
      
 public ArrayList<Cliente> listar(Cliente filtro) throws Exception {
        ArrayList<Cliente> retorno = new ArrayList<>();

        //instrução sql correspondente a inserção do aluno
        String sql = " select cpf_cli, idade, idade_corrigida, "
                + "data_nasc, nome, fk_cpf_resp";
        sql += " from client as cliente " ;
        sql += " where client.cpf > 0";
        
        if (filtro.getCpf() > 0) {
            sql += " and cliente.cpf_cli = ? ";
        }
        
        //preparando a instrução
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        if (filtro.getCpf() > 0) {
            preparedStatement.setInt(1, filtro.getCpf());
        }
        //executando a instrução sql
        ResultSet leitor = preparedStatement.executeQuery();
        //lendo os resultados
        while (leitor.next()) {
            Cliente client = new Cliente();
            client.setCpf(leitor.getInt("cpf_cli"));
            client.setIdade(leitor.getString("idade"));
            client.setIdade_corrigida(leitor.getString("idade_corrigida"));
            client.setData_nasc(leitor.getDate("data_nasc"));
            client.setNome(leitor.getString("nome_cli"));
            retorno.add(client);
        }      
                    
         
        //fechando a conexão com o banco de dados
        super.desconectar();
        return retorno;
    }
    
}
