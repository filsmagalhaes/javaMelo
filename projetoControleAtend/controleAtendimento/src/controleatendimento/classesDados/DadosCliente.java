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
     * @param client
     * @throws java.sql.SQLException
     */
    
  public void cadastrarCliente(Cliente client) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "INSERT INTO cliente (cpf_cli, idade, idade_corrigida, "
        + "data_nasc, nome_cli, idResp)  ";
        sql += " VALUES (?,?,?,?,?,?)";
        //preparando a instrução
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setString(1, client.getCpf());
        preparedStatement.setString(2, client.getIdade());
        preparedStatement.setString(3, client.getIdade_corrigida());
        preparedStatement.setDate(4, client.getData_nasc());
        preparedStatement.setString(5, client.getNome());
        preparedStatement.setInt(6, client.getResponsavel().getId());
        
                
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.desconectar();
    }  
  
  /**
     * Criando CRUD: Delete
     * @param client
     * @throws java.sql.SQLException
     */
  
  public void removerCliente (Cliente client) throws SQLException, Exception {        
        String sql = "DELETE FROM cliente WHERE IdCli = ? ";        
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);        
        
        preparedStatement.setInt(1, client.getId());        
        
        preparedStatement.executeUpdate();        
        super.desconectar();
    }
  
   /**
     * Criando CRUD: Update
     * @param client
     * @throws java.sql.SQLException
     */
  
      public void atualizarCliente(Cliente client) throws SQLException, Exception {       
        String sql = "UPDATE cliente SET nome_cli = ? WHERE IdCli = ? ";        
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        
        preparedStatement.setString(1, client.getCpf());
        preparedStatement.setString(2, client.getIdade());
        preparedStatement.setString(3, client.getIdade_corrigida());
        preparedStatement.setDate(4, client.getData_nasc());
        preparedStatement.setString(5, client.getNome());
                
        preparedStatement.executeUpdate();        
        super.desconectar();
    }
  
       /**
     * Criando SELECT
     * @param filtro
     * @return 
     * @throws java.lang.Exception
     */
      
 public ArrayList<Cliente> listar(Cliente filtro) throws Exception {
        ArrayList<Cliente> retorno = new ArrayList<>();

        //instrução sql correspondente a inserção do cliente
        String sql = " select c.idCli, c.cpf_cli, c.idade, c.idade_corrigida, "
                + "c.data_nasc, c.nome_cli, c.idResp, r.idResp, r.nome_resp ";
        sql += " from cliente as c " ;
        sql += " inner join responsavel as r ";
        sql += " on c.idResp = r.idResp ";
        sql += " where idCli > 0";
        
        if (filtro.getId() > 0) {
            sql += " and cliente.idCli = ? ";
        }
        
        //preparando a instrução
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        if (filtro.getId() > 0) {
        preparedStatement.setInt(1, filtro.getId());
       
            
        }
        //executando a instrução sql
        ResultSet leitor = preparedStatement.executeQuery();
        //lendo os resultados
        while (leitor.next()) {
            Cliente client = new Cliente();
            client.setId(leitor.getInt("idCli"));
            client.setCpf(leitor.getString("cpf_cli"));
            client.setIdade(leitor.getString("idade"));
            client.setIdade_corrigida(leitor.getString("idade_corrigida"));
            client.setData_nasc(leitor.getDate("data_nasc"));
            client.setNome(leitor.getString("nome_cli"));
            client.getResponsavel().setId(leitor.getInt("idResp"));
            client.getResponsavel().setNome(leitor.getString("nome_resp"));
            retorno.add(client);
        }      
                    
         
        //fechando a conexão com o banco de dados
        super.desconectar();
        return retorno;
    }
    
}
