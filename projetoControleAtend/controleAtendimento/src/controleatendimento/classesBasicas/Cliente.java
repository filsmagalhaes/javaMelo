/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleatendimento.classesBasicas;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class Cliente extends Pessoa{

private int idade_corrigida;
private int idade;
private String descricao_diagnostico;
private Responsavel responsavel;

private ArrayList<Terapeuta> listaTerapeutas;


    public int getIdade_corrigida() {
        return idade_corrigida;
    }

    public void setIdade_corrigida(int idade_corrigida) {
        this.idade_corrigida = idade_corrigida;
    }
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getDescricao_diagnostico() {
        return descricao_diagnostico;
    }

    public void setDescricao_diagnostico(String descricao_diagnostico) {
        this.descricao_diagnostico = descricao_diagnostico;
    }
    
    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }
    

    
    
}
