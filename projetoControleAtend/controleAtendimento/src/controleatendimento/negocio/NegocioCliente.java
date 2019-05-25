/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleatendimento.negocio;

import controleatendimento.classesBasicas.Cliente;
import controleatendimento.classesDados.DadosCliente;

/**
 *
 * @author filip
 */
public class NegocioCliente {
    public void cadastrarCliente(Cliente c) throws Exception {
        if (c == null) {
            throw new Exception("Informar os dados da Terapeuta");
        }
        if (c.getCpf() <= 0) {
            throw new Exception("Informar a matricula da Terapeuta");
        }
        if (c.getNome() == null) {
            throw new Exception("Informar o nome da Terapeuta");
        }
        if (c.getNome().trim().equals("") == true) {
            throw new Exception("Informar o nome da Terapeuta");
        }
        if (c.getNome().trim().length() > 100) {
            throw new Exception("O nome da Terapeuta deverá ter menos de 100 caracteres");
        }
        DadosCliente dados = new DadosCliente();
        dados.cadastrarCliente(c);
    }
}
