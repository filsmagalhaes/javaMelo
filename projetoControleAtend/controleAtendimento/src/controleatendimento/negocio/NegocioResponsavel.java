/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleatendimento.negocio;

import controleatendimento.classesBasicas.Responsavel;
import controleatendimento.classesDados.DadosResponsavel;

/**
 *
 * @author aluno
 */
public class NegocioResponsavel {
    public void cadastrarResponsavel(Responsavel r) throws Exception {
        if (r == null) {
            throw new Exception("Informar os dados do aluno");
        }
        if (r.getCpf() == null) {
            throw new Exception("Informar a matricula do aluno");
        }
        if (r.getNome() == null) {
            throw new Exception("Informar o nome do aluno");
        }
        if (r.getNome().trim().equals("") == true) {
            throw new Exception("Informar o nome do aluno");
        }
        if (r.getNome().trim().length() > 100) {
            throw new Exception("O nome do aluno deverá ter menos de 100 caracteres");
        }
        DadosResponsavel dados = new DadosResponsavel();
        dados.cadastrarResponsavel(r);
    }
    
}

