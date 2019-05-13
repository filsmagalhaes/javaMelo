/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleatendimento.classesBasicas;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author aluno
 */
public class Atendimento {
    
private int id_atendimento;
private Date data_atendimento;
private Time hora_inicio;
private Time hora_fim;
private int quantidade_sessoes;
private String descricao_diagnostico;
private String descricao_sessao;
private int valor_sessao;

private Cliente cliente;    
private Terapeuta terapeuta;

 //construtor
 //qual_visibilidade  mesmo_nome_classe(){}
    public Atendimento() {
        this.cliente = new Cliente();
        this.terapeuta = new Terapeuta();        
    }
    
   
    public String toString() {
        String retorno = "";
        retorno += "id_atendimento: " + this.id_atendimento;
        retorno += "\ndata_atendimento: " + this.data_atendimento;
        retorno += "\nhora_inicio: " + this.hora_inicio;
        retorno += "\nhora_inicio: " + this.hora_fim;
        retorno += "\nquantidade_sessoes: " + this.quantidade_sessoes;
        retorno += "\ndescricao_diagnostico: " + this.descricao_diagnostico;
        retorno += "\ndescricao_sessao: " + this.descricao_sessao;
        retorno += "\nvalor_sessao: " + this.valor_sessao;
        
        retorno += "\ncpf_cli: " + this.cliente.getCpf();
        retorno += "\nnome_cli: " + this.cliente.getNome();
        
        return retorno;
    }

    public int getId_atendimento() {
        return id_atendimento;
    }

    public void setId_atendimento(int id_atendimento) {
        this.id_atendimento = id_atendimento;
    }

    public Date getData_atendimento() {
        return data_atendimento;
    }

    public void setData_atendimento(Date data_atendimento) {
        this.data_atendimento = data_atendimento;
    }

    public Time getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Time hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public Time getHora_fim() {
        return hora_fim;
    }

    public void setHora_fim(Time hora_fim) {
        this.hora_fim = hora_fim;
    }

    public int getQuantidade_sessoes() {
        return quantidade_sessoes;
    }

    public void setQuantidade_sessoes(int quantidade_sessoes) {
        this.quantidade_sessoes = quantidade_sessoes;
    }

    public String getDescricao_diagnostico() {
        return descricao_diagnostico;
    }

    public void setDescricao_diagnostico(String descricao_diagnostico) {
        this.descricao_diagnostico = descricao_diagnostico;
    }

    public String getDescricao_sessao() {
        return descricao_sessao;
    }

    public void setDescricao_sessao(String descricao_sessao) {
        this.descricao_sessao = descricao_sessao;
    }

    public int getValor_sessao() {
        return valor_sessao;
    }

    public void setValor_sessao(int valor_sessao) {
        this.valor_sessao = valor_sessao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
public Terapeuta getTerapeuta() {
        return terapeuta;
    }

    public void setTerapeuta(Terapeuta terapeuta) {
        this.terapeuta = terapeuta;
    }
   
}
