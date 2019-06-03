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
     * @param resp
     * @throws java.sql.SQLException
     */
    
  public void cadastrarResponsavel(Responsavel resp) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "INSERT INTO responsavel (cpf_resp, nome_resp, data_nasc, telefone, email, endereco, cidade, "
        + "bairro, complemento, cep, banco, agencia, conta)  ";
        sql += " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        //preparando a instrução
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setString(1, resp.getCpf());
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
     * @param resp
     * @throws java.sql.SQLException
     */
  
  public void removerResponsavel (Responsavel resp) throws SQLException, Exception {        
        String sql = "DELETE FROM responsavel WHERE IdResp = ? ";        
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);        
        
        preparedStatement.setInt(1, resp.getId());        
        
        preparedStatement.executeUpdate();        
        super.desconectar();
    }
  
   /**
     * Criando CRUD: Update
     * @param resp
     * @throws java.sql.SQLException
     */
  
      public void atualizarResponsavel(Responsavel resp) throws SQLException, Exception {       
        String sql = "UPDATE responsavel SET cpf_resp = ?, nome_resp = ?, data_nasc = ?, telefone = ?, email = ?, endereco = ?, cidade = ?, "
        + "bairro = ?, complemento = ?, cep = ?, banco = ?, agencia = ?, conta = ?  WHERE IdResp = ? ";        
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        
        preparedStatement.setInt(1, resp.getId());
        preparedStatement.setString(2, resp.getCpf());
        preparedStatement.setString(3, resp.getNome());
        preparedStatement.setDate(4, resp.getData_nasc());
        preparedStatement.setString(5, resp.getTelefone());
        preparedStatement.setString(6, resp.getEmail());
        preparedStatement.setString(7, resp.getEndereco());
        preparedStatement.setString(8, resp.getCidade());
        preparedStatement.setString(9, resp.getBairro());
        preparedStatement.setString(10, resp.getComplemento());
        preparedStatement.setInt(11, resp.getCep());
        preparedStatement.setString(12, resp.getBanco());
        preparedStatement.setInt(13, resp.getAgencia());
        preparedStatement.setInt(14, resp.getConta());
        
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
        String sql = " select IdResp, cpf_resp, nome_resp, data_nasc, telefone, email, endereco, cidade, "
        + "bairro, complemento, cep, banco, agencia, conta ";
        sql += " from responsavel as resp " ;
        sql += " where resp.IdResp > 0";
        
        if (filtro.getId() > 0) {
            sql += " and resp.IdResp = ? ";
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
            Responsavel resp = new Responsavel();
            
            resp.setId(leitor.getInt("IdResp"));
            resp.setCpf(leitor.getString("cpf_resp"));
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
