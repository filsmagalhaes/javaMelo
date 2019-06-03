/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleatendimento.classesDados;

import controleatendimento.classesBasicas.Terapeuta;
import controleatendimento.conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class DadosTerapeuta extends Conexao {
    
    /**
     * Criando CRUD: Insert
     */
    
    public void cadastrarTerapeuta(Terapeuta ter) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "INSERT INTO terapeuta (cpf_terapeuta, nome_terapeuta, especialidade, data_nasc, telefone, email, endereco, cidade, "
        + "bairro, complemento, cep, banco, agencia, conta)  ";
        sql += " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        //preparando a instrução
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setString(1, ter.getCpf());
        preparedStatement.setString(2, ter.getNome());
        preparedStatement.setString(3, ter.getEspecialidade());
        preparedStatement.setDate(4, ter.getData_nasc()); 
        preparedStatement.setString(5, ter.getTelefone());
        preparedStatement.setString(6, ter.getEmail());
        preparedStatement.setString(7, ter.getEndereco());
        preparedStatement.setString(8, ter.getCidade());
        preparedStatement.setString(9, ter.getBairro());
        preparedStatement.setString(10, ter.getComplemento());
        preparedStatement.setInt(11, ter.getCep());
        preparedStatement.setString(12, ter.getBanco());
        preparedStatement.setInt(13, ter.getAgencia());
        preparedStatement.setInt(14, ter.getConta());
        
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.desconectar();
    } 
    
     /**
     * Criando CRUD: Delete
     * @param ter
     * @throws java.sql.SQLException
     */
  
  public void removerTerapeuta (Terapeuta ter) throws SQLException, Exception {        
        String sql = "DELETE FROM terapeuta WHERE IdTer = ? ";        
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);        
        preparedStatement.setInt(1, ter.getId());        
        preparedStatement.executeUpdate();        
        super.desconectar();
    }
    
  /**
     * Criando CRUD: Update
     * @param ter
     * @throws java.sql.SQLException
     */
  
      public void atualizarTerapeuta(Terapeuta ter) throws SQLException, Exception {       
        String sql = "UPDATE terapeuta SET nome_terapeuta = ? WHERE IdTer = ? ";        
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        
        preparedStatement.setString(1, ter.getCpf());
        preparedStatement.setString(2, ter.getNome());
        preparedStatement.setString(3, ter.getEspecialidade());
        preparedStatement.setDate(4, ter.getData_nasc()); 
        preparedStatement.setString(5, ter.getTelefone());
        preparedStatement.setString(6, ter.getEmail());
        preparedStatement.setString(7, ter.getEndereco());
        preparedStatement.setString(8, ter.getCidade());
        preparedStatement.setString(9, ter.getBairro());
        preparedStatement.setString(10, ter.getComplemento());
        preparedStatement.setInt(11, ter.getCep());
        preparedStatement.setString(12, ter.getBanco());
        preparedStatement.setInt(13, ter.getAgencia());
        preparedStatement.setInt(14, ter.getConta());
        
        preparedStatement.executeUpdate();        
        super.desconectar();
    }
  
    /**
     * Criando SELECT
     * @param filtro
     * @return 
     * @throws java.lang.Exception
     */
      
 public ArrayList<Terapeuta> listar(Terapeuta filtro) throws Exception {
        ArrayList<Terapeuta> retorno = new ArrayList<>();

        //instrução sql correspondente a inserção do aluno
        String sql = " select IdTer, cpf_terapeuta, nome_terapeuta, especialidade, data_nasc, telefone, email, endereco, cidade, "
        + "bairro, complemento, cep, banco, agencia, conta ";
        sql += " from terapeuta as terapeuta " ;
        sql += " where terapeuta.IdTer > 0";
        
        if (filtro.getId() > 0) {
            sql += " and terapeuta.IdTer = ? ";
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
            Terapeuta terapeuta = new Terapeuta();
            terapeuta.setId(leitor.getInt("idTer"));
            terapeuta.setCpf(leitor.getString("cpf_terapeuta"));
            terapeuta.setNome(leitor.getString("nome_terapeuta"));
            terapeuta.setEspecialidade(leitor.getString("especialidade"));
            terapeuta.setData_nasc(leitor.getDate("data_nasc"));
            terapeuta.setTelefone(leitor.getString("telefone"));
            terapeuta.setEmail(leitor.getString("email"));
            terapeuta.setEndereco(leitor.getString("endereco"));
            terapeuta.setCidade(leitor.getString("cidade"));
            terapeuta.setBairro(leitor.getString("bairro"));
            terapeuta.setComplemento(leitor.getString("complemento"));
            terapeuta.setCep(leitor.getInt("cep"));
            terapeuta.setBanco(leitor.getString("banco"));
            terapeuta.setAgencia(leitor.getInt("agencia"));
            terapeuta.setConta(leitor.getInt("conta"));
            retorno.add(terapeuta);
        }
        //fechando a conexão com o banco de dados
        super.desconectar();
        return retorno;
    }  
  
  
  
}
