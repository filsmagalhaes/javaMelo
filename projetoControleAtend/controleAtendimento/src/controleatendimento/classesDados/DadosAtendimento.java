/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleatendimento.classesDados;

import controleatendimento.classesBasicas.Atendimento;
import controleatendimento.conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class DadosAtendimento extends Conexao {
    
   public void cadastrarAtendimento(Atendimento atend) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "insert into atendimento (data_atendimento, hora_inicio, hora_fim, " +
        " quantidade_sessoes, descricao_diagnostico, descricao_sessao, valor_sessao, IdTer, IdCli) ";
        sql += " VALUES (?,?,?,?,?,?,?,?,?)";
        //preparando a instrução
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setDate(1, atend.getData_atendimento());
        preparedStatement.setString(2, atend.getHora_inicio());
        preparedStatement.setString(3, atend.getHora_fim());
        preparedStatement.setInt(4, atend.getQuantidade_sessoes());
        preparedStatement.setString(5, atend.getDescricao_diagnostico());
        preparedStatement.setString(6, atend.getDescricao_sessao());
        preparedStatement.setDouble(7, atend.getValor_sessao());
        preparedStatement.setInt(8, atend.getTerapeuta().getId());
        preparedStatement.setInt(9, atend.getCliente().getId());
                
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.desconectar();
    }

    public void removerAtendimento(Atendimento atend) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "DELETE FROM atendimento WHERE id_atendimento = ? ";

        //preparando a instrução
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setInt(1, atend.getId_atendimento());
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.desconectar();
    }

    public void atualizarAvaliacao(Atendimento atend) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "UPDATE atendimento SET data_atendimento = ?, hora_inicio = ?, hora_fim = ?,"
                + "quantidade_sessoes = ?, descricao_diagnostico = ?, descricao_sessao = ?,"
                + "valor_sessao = ?, IdTer = ?, IdCli = ? WHERE id_atendimento = ? ";
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setDate(1, atend.getData_atendimento());
        preparedStatement.setString(2, atend.getHora_inicio());
        preparedStatement.setString(3, atend.getHora_fim());
        preparedStatement.setInt(4, atend.getQuantidade_sessoes());
        preparedStatement.setString(5, atend.getDescricao_diagnostico());
        preparedStatement.setString(6, atend.getDescricao_sessao());
        preparedStatement.setDouble(7, atend.getValor_sessao());
        preparedStatement.setInt(8, atend.getTerapeuta().getId());
        preparedStatement.setInt(9, atend.getCliente().getId());
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.desconectar();
    }

    public ArrayList<Atendimento> listar(Atendimento filtro) throws Exception {
        ArrayList<Atendimento> retorno = new ArrayList<>();
        
        //instrução sql correspondente a inserção do aluno
        String sql = " select  ";
        sql += " a.id_atendimento, a.data_atendimento, a.hora_inicio, a.hora_fim, " 
        + "a.quantidade_sessoes, a.descricao_diagnostico, a.descricao_sessao, "
        + "a.valor_sessao, " 
        + "c. idCli, c.cpf_cli, c.idade, c.idade_corrigida, c.data_nasc, c.nome_cli, "
        + "t.idTer, t.nome_terapeuta ";
        sql += " from atendimento as a ";
        sql += " inner join cliente as c ";
        sql += " on a.IdCli = c.idCli ";
        sql += " inner join terapeuta as t "; 
        sql += " on a.IdTer = t.IdTer ";
        sql += " where a.id_atendimento > 0 ";
        
        //preparando a instrução
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        //executando a instrução sql
        ResultSet leitor = preparedStatement.executeQuery();
        //lendo os resultados
        while (leitor.next()) {
            Atendimento atend = new Atendimento();
            atend.setId(leitor.getInt("id_atendimento"));
            atend.setData_atendimento(leitor.getDate("data_atendimento"));
            atend.setHora_inicio(leitor.getString("hora_inicio"));
            atend.setHora_fim(leitor.getString("hora_fim"));
            atend.setQuantidade_sessoes(leitor.getInt("quantidade_sessoes"));
            atend.setDescricao_diagnostico(leitor.getString("descricao_diagnostico"));
            atend.setDescricao_sessao(leitor.getString("descricao_sessao"));
            atend.setDescricao_sessao(leitor.getString("descricao_sessao"));
            atend.setValor_sessao(leitor.getDouble("valor_sessao"));
            
            atend.getCliente().setId(leitor.getInt("idCli")); 
            atend.getCliente().setCpf(leitor.getString("cpf_cli")); 
            atend.getCliente().setIdade(leitor.getString("idade"));
            atend.getCliente().setIdade_corrigida(leitor.getString("idade_corrigida"));
            atend.getCliente().setData_nasc(leitor.getDate("data_nasc"));
            atend.getCliente().setNome(leitor.getString("nome_cli"));
            
            atend.getTerapeuta().setId(leitor.getInt("idTer"));            
            atend.getTerapeuta().setNome(leitor.getString("nome_terapeuta")); 
                                 
            retorno.add(atend);
        }
        //fechando a conexão com o banco de dados
        super.desconectar();
        return retorno;
    } 
    
}
