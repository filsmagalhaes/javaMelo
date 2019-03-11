/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaobancoexemplo;

import conexaobancoexemplo.conexao.Conexao;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class ConexaoBancoExemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Conexao con = new Conexao();
            con.conectar();
            JOptionPane.showMessageDialog(null, "Conectou");
            con.desconectar();
            JOptionPane.showMessageDialog(null, "desconectou");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
}
