/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleatendimento.negocio;

import controleatendimento.classesBasicas.Atendimento;
import controleatendimento.classesDados.DadosAtendimento;

/**
 *
 * @author filip
 */
public class NegocioAtendimento {
    
    
/**
 *
 * @author filip
     * @param atend
     * @throws java.lang.Exception
 */

    public void cadastrarAtendimento(Atendimento atend) throws Exception {
        if (atend == null) {
            throw new Exception("Informar os dados do Atendimento");
        }
        
        if (atend.getCliente().getNome() == null) {
            throw new Exception("Informar o nome do(a) Cliente");
        }
        if (atend.getCliente().getNome().trim().equals("") == true) {
            throw new Exception("Informar o nome do(a) Cliente");
        }
        if (atend.getCliente().getNome().trim().length() > 100) {
            throw new Exception("O nome do(a) Cliente deverá ter menos de 100 caracteres");
        }
        if (atend.getTerapeuta().getNome() == null) {
            throw new Exception("Informar o nome do(a) Terapeuta");
        }
        if (atend.getTerapeuta().getNome().trim().equals("") == true) {
            throw new Exception("Informar o nome do(a) Terapeuta");
        }
        if (atend.getTerapeuta().getNome().trim().length() > 100) {
            throw new Exception("O nome do(a) Terapeuta deverá ter menos de 100 caracteres");
        }
        
        DadosAtendimento dados = new DadosAtendimento();
        dados.cadastrarAtendimento(atend);
    }
}

