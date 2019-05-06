/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleatendimento.classesBasicas;

import java.sql.Date;

/**
 *
 * @author aluno
 */
public abstract class Pessoa {
    
    
private int cpf_resp;
private String nome_resp;

    
private int cpf_terapeuta;
private String nome_terapeuta;
private Date data_nasc;
private String telefone;
private String email;
private String endereco;
private String cidade;
private String bairro;
private String complemento;
private int cep;
private String banco;
private int agencia;
private int conta;



    public int getCpf_resp() {
        return cpf_resp;
    }

    public void setCpf_resp(int cpf_resp) {
        this.cpf_resp = cpf_resp;
    }

    public String getNome_resp() {
        return nome_resp;
    }

    public void setNome_resp(String nome_resp) {
        this.nome_resp = nome_resp;
    }
    
    public int getCpf_terapeuta() {
        return cpf_terapeuta;
    }

    public void setCpf_terapeuta(int cpf_terapeuta) {
        this.cpf_terapeuta = cpf_terapeuta;
    }

    public String getNome_terapeuta() {
        return nome_terapeuta;
    }

    public void setNome_terapeuta(String nome_terapeuta) {
        this.nome_terapeuta = nome_terapeuta;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }
    
       
}
