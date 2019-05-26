/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleatendimento.classesDados;
import controleatendimento.classesBasicas.Responsavel;
import controleatendimento.conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author aluno
 */
public class DadosResponsavel extends Conexao{
    
    /**
     * Criando CRUD: Insert
     */
    
  public void cadastrarResponsavel(Responsavel resp) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "INSERT INTO responsavel (cpf_resp, nome_resp, data_nasc, telefone, email, endereco, cidade, "
        + "bairro, complemento, cep, banco, agencia, conta)  ";
        sql += " VALUES (?,?)";
        //preparando a instrução
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setLong(1, resp.getCpf());
        preparedStatement.setString(2, resp.getNome());
        preparedStatement.setDate(3, resp.getData_nasc());
        preparedStatement.setString(4, resp.getTelefone());
        preparedStatement.setString(5, resp.getEmail());
        preparedStatement.setString(6, resp.getEndereco());
        preparedStatement.setString(7, resp.getCidade());
        preparedStatement.setString(8, resp.getBairro());
        preparedStatement.setString(9, resp.getComplemento());
        preparedStatement.setInt(10, resp.getCep());
        preparedStatement.setString(11, resp.getBanco());
        preparedStatement.setInt(12, resp.getAgencia());
        preparedStatement.setInt(13, resp.getConta());
        
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.desconectar();
    }  
  
  /**
     * Criando CRUD: Delete
     */
  
  public void removerResponsavel (Responsavel resp) throws SQLException, Exception {        
        String sql = "DELETE FROM responsavel WHERE cpf_resp = ? ";        
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);        
        
        preparedStatement.setLong(1, resp.getCpf());        
        
        preparedStatement.executeUpdate();        
        super.desconectar();
    }
  
   /**
     * Criando CRUD: Update
     */
  
      public void atualizarResponsavel(Responsavel resp) throws SQLException, Exception {       
        String sql = "UPDATE responsavel SET nome_resp = ? WHERE cpf_resp = ? ";        
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        
        preparedStatement.setLong(1, resp.getCpf());
        preparedStatement.setString(2, resp.getNome());
        preparedStatement.setDate(2, resp.getData_nasc());
        preparedStatement.setString(3, resp.getTelefone());
        preparedStatement.setString(4, resp.getEmail());
        preparedStatement.setString(5, resp.getEndereco());
        preparedStatement.setString(6, resp.getCidade());
        preparedStatement.setString(7, resp.getBairro());
        preparedStatement.setString(8, resp.getComplemento());
        preparedStatement.setInt(9, resp.getCep());
        preparedStatement.setString(10, resp.getBanco());
        preparedStatement.setInt(11, resp.getAgencia());
        preparedStatement.setInt(12, resp.getConta());
        
        preparedStatement.executeUpdate();        
        super.desconectar();
    }
  
       /**
     * Criando SELECT
     * @param filtro
     * @return 
     * @throws java.lang.Exception
     */
      
 public ArrayList<Responsavel> listar(Responsavel filtro) throws Exception {
        ArrayList<Responsavel> retorno = new ArrayList<>();

        //instrução sql correspondente a inserção do aluno
        String sql = " select cpf_resp, nome_resp, data_nasc, telefone, email, endereco, cidade, "
        + "bairro, complemento, cep, banco, agencia, conta ";
        sql += " from responsavel as resp " ;
        sql += " where resp.cpf_resp > 0";
        
        if (filtro.getCpf() > 0) {
            sql += " and resp.cpf_resp = ? ";
        }
        
        //preparando a instrução
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        if (filtro.getCpf() > 0) {
            preparedStatement.setLong(1, filtro.getCpf());
        }
        //executando a instrução sql
        ResultSet leitor = preparedStatement.executeQuery();
        //lendo os resultados
        while (leitor.next()) {
            Responsavel resp = new Responsavel();
            resp.setCpf(leitor.getInt("cpf_resp"));
            resp.setNome(leitor.getString("nome_resp"));
            resp.setData_nasc(leitor.getDate("data_nasc"));
            resp.setTelefone(leitor.getString("telefone"));
            resp.setEmail(leitor.getString("email"));
            resp.setEndereco(leitor.getString("endereco"));
            resp.setCidade(leitor.getString("cidade"));
            resp.setBairro(leitor.getString("bairro"));
            resp.setComplemento(leitor.getString("complemento"));
            resp.setCep(leitor.getInt("cep"));
            resp.setBanco(leitor.getString("banco"));
            resp.setAgencia(leitor.getInt("agencia"));
            resp.setConta(leitor.getInt("conta"));
            retorno.add(resp);
        }
        //fechando a conexão com o banco de dados
        super.desconectar();
        return retorno;
    }
    
}
