/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleatendimento.cliente;

import controleatendimento.pessoa.Pessoa;
import controleatendimento.responsavel.Responsavel;
import java.sql.Date;

/**
 *
 * @author aluno
 */
public class Cliente extends Pessoa{

private int idade;
private int idade_corrigida;
private String descricao_diagnostico;
private Date data_nasc;
private Responsavel responsavel;


    
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getIdade_corrigida() {
        return idade_corrigida;
    }

    public void setIdade_corrigida(int idade_corrigida) {
        this.idade_corrigida = idade_corrigida;
    }

    public String getDescricao_diagnostico() {
        return descricao_diagnostico;
    }

    public void setDescricao_diagnostico(String descricao_diagnostico) {
        this.descricao_diagnostico = descricao_diagnostico;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }
    

    
    
}
