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
        String sql = "INSERT INTO cliente (cpf, idade, idade_corrigida, descricao_diagnostico, "
        + "data_nasc, nome)  ";
        sql += " VALUES (?,?)";
        //preparando a instrução
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setInt(1, client.getCpf_client());
        preparedStatement.setInt(2, client.getIdade());
        preparedStatement.setInt(3, client.getIdade_corrigida());
        preparedStatement.setString(4, client.getDescricao_diagnostico());
        preparedStatement.setDate(5, client.getData_nasc());
        preparedStatement.setString(6, client.getNome_client());
                
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.desconectar();
    }  
  
  /**
     * Criando CRUD: Delete
     */
  
  public void removerCliente (Cliente client) throws SQLException, Exception {        
        String sql = "DELETE FROM cliente WHERE cpf = ? ";        
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);        
        
        preparedStatement.setInt(1, client.getCpf_client());        
        
        preparedStatement.executeUpdate();        
        super.desconectar();
    }
  
   /**
     * Criando CRUD: Update
     */
  
      public void atualizarCliente(Cliente client) throws SQLException, Exception {       
        String sql = "UPDATE cliente SET nome = ? WHERE cpf = ? ";        
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        
        preparedStatement.setInt(1, client.getCpf_client());
        preparedStatement.setInt(2, client.getIdade());
        preparedStatement.setInt(3, client.getIdade_corrigida());
        preparedStatement.setString(4, client.getDescricao_diagnostico());
        preparedStatement.setDate(5, client.getData_nasc());
        preparedStatement.setString(6, client.getNome_client());
                
        preparedStatement.executeUpdate();        
        super.desconectar();
    }
  
       /**
     * Criando SELECT
     */
      
 public ArrayList<Cliente> listar(Cliente filtro) throws Exception {
        ArrayList<Cliente> retorno = new ArrayList<>();

        //instrução sql correspondente a inserção do aluno
        String sql = " select cpf, idade, idade_corrigida, descricao_diagnostico, "
                + "data_nasc, nome, fk_cpf_resp";
        sql += " from client as cliente " ;
        sql += " where client.cpf > 0";
        
        if (filtro.getCpf_client() > 0) {
            sql += " and resp.cpf = ? ";
        }
        
        //preparando a instrução
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        if (filtro.getCpf_client() > 0) {
            preparedStatement.setInt(1, filtro.getCpf_client());
        }
        //executando a instrução sql
        ResultSet leitor = preparedStatement.executeQuery();
        //lendo os resultados
        while (leitor.next()) {
            Cliente client = new Cliente();
            client.setCpf_client(leitor.getInt("cpf"));
            client.setIdade(leitor.getInt("idade"));
            client.setIdade_corrigida(leitor.getInt("idade_corrigida"));
            client.setDescricao_diagnostico(leitor.getString("descricao_diagnostico"));
            client.setData_nasc(leitor.getDate("data_nasc"));
            client.setNome_client(leitor.getString("nome"));
            retorno.add(client);
        }      
                    
         
        //fechando a conexão com o banco de dados
        super.desconectar();
        return retorno;
    }
    
}
