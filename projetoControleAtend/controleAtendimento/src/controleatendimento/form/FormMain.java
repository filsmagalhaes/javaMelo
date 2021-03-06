/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleatendimento.form;

import controleatendimento.conexao.Conexao;
import javax.swing.JOptionPane;

/**
 *
 * @author filip
 */
public class FormMain extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public FormMain() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jButtonTestarConexao = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArquivo = new javax.swing.JMenu();
        jMenuItemFechar = new javax.swing.JMenuItem();
        jMenuCadastro = new javax.swing.JMenu();
        jMenuItemCadastroAtendimento = new javax.swing.JMenuItem();
        jMenuItemCadastroCliente = new javax.swing.JMenuItem();
        jMenuItemCadastroTerapeuta = new javax.swing.JMenuItem();
        jMenuItemCadastroResp = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItemRelatorioAtend = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonTestarConexao.setText("TESTAR CONEXÃO");
        jButtonTestarConexao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTestarConexaoActionPerformed(evt);
            }
        });

        jMenuArquivo.setText("Arquivo");

        jMenuItemFechar.setText("Fechar");
        jMenuArquivo.add(jMenuItemFechar);

        jMenuBar1.add(jMenuArquivo);

        jMenuCadastro.setText("Cadastro");

        jMenuItemCadastroAtendimento.setText("Atendimento");
        jMenuItemCadastroAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroAtendimentoActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemCadastroAtendimento);

        jMenuItemCadastroCliente.setText("Cliente");
        jMenuItemCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroClienteActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemCadastroCliente);

        jMenuItemCadastroTerapeuta.setText("Terapeuta");
        jMenuItemCadastroTerapeuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroTerapeutaActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemCadastroTerapeuta);

        jMenuItemCadastroResp.setText("Responsável");
        jMenuItemCadastroResp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroRespActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemCadastroResp);

        jMenuBar1.add(jMenuCadastro);

        jMenu4.setText("Editar");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Relatórios");

        jMenuItemRelatorioAtend.setText("Atendimentos");
        jMenuItemRelatorioAtend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRelatorioAtendActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItemRelatorioAtend);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(261, Short.MAX_VALUE)
                .addComponent(jButtonTestarConexao)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(243, Short.MAX_VALUE)
                .addComponent(jButtonTestarConexao)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroClienteActionPerformed
        // TODO add your handling code here:
        
        new FormCliente().setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastroClienteActionPerformed

    private void jMenuItemCadastroTerapeutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroTerapeutaActionPerformed
        // TODO add your handling code here:
        
        new FormTerapeuta().setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastroTerapeutaActionPerformed

    private void jMenuItemCadastroRespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroRespActionPerformed
        // TODO add your handling code here:
        
        new FormResponsavel().setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastroRespActionPerformed

    private void jButtonTestarConexaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTestarConexaoActionPerformed
        // TODO add your handling code here:
        
                 
            try
            {
                Conexao conn = new Conexao();
                conn.conectar();
                JOptionPane.showMessageDialog(this, "Conectou");
                conn.desconectar();
                JOptionPane.showMessageDialog(this, "Desconectou");
            }
            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
       
    }//GEN-LAST:event_jButtonTestarConexaoActionPerformed

    private void jMenuItemCadastroAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroAtendimentoActionPerformed
        // TODO add your handling code here:
        
        new FormAtend().setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastroAtendimentoActionPerformed

    private void jMenuItemRelatorioAtendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRelatorioAtendActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemRelatorioAtendActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonTestarConexao;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenuArquivo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastro;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItemCadastroAtendimento;
    private javax.swing.JMenuItem jMenuItemCadastroCliente;
    private javax.swing.JMenuItem jMenuItemCadastroResp;
    private javax.swing.JMenuItem jMenuItemCadastroTerapeuta;
    private javax.swing.JMenuItem jMenuItemFechar;
    private javax.swing.JMenuItem jMenuItemRelatorioAtend;
    // End of variables declaration//GEN-END:variables
}
