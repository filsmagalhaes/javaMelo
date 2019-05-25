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
public class Terapeuta extends Pessoa{

    private String especialidade;
    
    private ArrayList<Cliente> listaClientes;
    
            
    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    
    
    
}
