/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaobancoexemplo.aluno;


import conexaobancoexemplo.conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class DadosAluno extends Conexao {

    
    public void cadastrarAluno(Aluno a) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "INSERT INTO aluno (matricula, nome) ";
        sql += " VALUES (?,?)";
        //preparando a instrução
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setInt(1, a.getMatricula());
        preparedStatement.setString(2, a.getNome());
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.desconectar();
    }

    
    public void removerAluno(Aluno a) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "DELETE FROM aluno WHERE matricula = ? ";

        //preparando a instrução
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setInt(1, a.getMatricula());
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.desconectar();
    }


    public void atualizarAluno(Aluno a) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "UPDATE aluno SET nome = ? WHERE matricula = ? ";

        //preparando a instrução
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setString(1, a.getNome());
        preparedStatement.setInt(2, a.getMatricula());
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.desconectar();
    }


    public ArrayList<Aluno> listar(Aluno filtro) throws Exception {
        ArrayList<Aluno> retorno = new ArrayList<>();

        //instrução sql correspondente a inserção do aluno
        String sql = " select a.matricula, a.nome ";
        sql += " from aluno as a ";
        sql += " where a.matricula > 0 ";
        if (filtro.getMatricula() > 0) {
            sql += " and a.matricula = ? ";
        }
        //preparando a instrução
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        if (filtro.getMatricula() > 0) {
            preparedStatement.setInt(1, filtro.getMatricula());
        }
        //executando a instrução sql
        ResultSet leitor = preparedStatement.executeQuery();
        //lendo os resultados
        while (leitor.next()) {
            Aluno a = new Aluno();
            a.setMatricula(leitor.getInt("matricula"));
            a.setNome(leitor.getString("nome"));
            retorno.add(a);
        }
        //fechando a conexão com o banco de dados
        super.desconectar();
        return retorno;
    }
}
