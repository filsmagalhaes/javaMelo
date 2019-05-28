/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleatendimento.negocio;

import controleatendimento.classesBasicas.Terapeuta;
import controleatendimento.classesDados.DadosTerapeuta;


/**
 *
 * @author aluno
 */
public class NegocioTerapeuta {
    public void cadastrarTerapeuta(Terapeuta t) throws Exception {
        if (t == null) {
            throw new Exception("Informar os dados da Terapeuta");
        }
        if (t.getCpf() == null) {
            throw new Exception("Informar a matricula da Terapeuta");
        }
        if (t.getNome() == null) {
            throw new Exception("Informar o nome da Terapeuta");
        }
        if (t.getNome().trim().equals("") == true) {
            throw new Exception("Informar o nome da Terapeuta");
        }
        if (t.getNome().trim().length() > 100) {
            throw new Exception("O nome da Terapeuta deverá ter menos de 100 caracteres");
        }
        DadosTerapeuta dados = new DadosTerapeuta();
        dados.cadastrarTerapeuta(t);
    }
    
}

