/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleatendimento.classesBasicas;

import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class Cliente extends Pessoa{

private String idade_corrigida;
private String idade;
private Responsavel responsavel;

private ArrayList<Terapeuta> listaTerapeutas;
private ArrayList<Responsavel> listaResponsavel;

public Cliente(){
this.responsavel = new Responsavel();
}

    public String getIdade_corrigida() {
        return idade_corrigida;
    }

    public void setIdade_corrigida(String idade_corrigida) {
        this.idade_corrigida = idade_corrigida;
    }
    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }
        
    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    } 
  
        public ArrayList<Terapeuta> getListaTerapeutas() {
        return listaTerapeutas;
    }

    public void setListaTerapeutas(ArrayList<Terapeuta> listaTerapeutas) {
        this.listaTerapeutas = listaTerapeutas;
    }

    public ArrayList<Responsavel> getListaResponsavel() {
        return listaResponsavel;
    }

    public void setListaResponsavel(ArrayList<Responsavel> listaResponsavel) {
        this.listaResponsavel = listaResponsavel;
    }
}
