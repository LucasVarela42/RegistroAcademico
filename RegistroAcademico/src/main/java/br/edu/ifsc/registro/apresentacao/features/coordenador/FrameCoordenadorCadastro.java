/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.apresentacao.features.coordenador;

import br.edu.ifsc.registro.dominio.features.coordenador.Coordenador;
import br.edu.ifsc.registro.dominio.features.curso.Curso;
import br.edu.ifsc.registro.servico.features.coordenador.CoordenadorServico;
import br.edu.ifsc.registro.servico.features.curso.CursoServico;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Lucas
 */
public class FrameCoordenadorCadastro extends javax.swing.JFrame {

    private Coordenador coordenador;
    private CoordenadorServico servico;
    private CursoServico cursoServico;

    /**
     * Creates new form FrameCoordenadorCadastro
     */
    public FrameCoordenadorCadastro() {
        initComponents();
    }

    FrameCoordenadorCadastro(CoordenadorServico coordenadorServico, CursoServico cursoServico) {
        initComponents();
        this.servico = coordenadorServico;
        this.cursoServico = cursoServico;
        System.out.println("Carregou FrameCoordenador");
        carregarCurso();
        limparCampos();
    }

    private void carregarCurso() {
        try {
            List<Curso> cursos = cursoServico.getAll();
            for (Curso curso : cursos) {
                cbCurso.addItem(curso);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }

    private void limparCampos() {
        txfNome.setText("");
        txfFone.setText("");
        txfEmail.setText("");
        cbCurso.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelButtons = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        jPanelRegisters = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txfNome = new javax.swing.JTextField();
        cbCurso = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txfEmail = new javax.swing.JTextField();
        txfFone = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de curso");
        setResizable(false);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelButtonsLayout = new javax.swing.GroupLayout(jPanelButtons);
        jPanelButtons.setLayout(jPanelButtonsLayout);
        jPanelButtonsLayout.setHorizontalGroup(
            jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelButtonsLayout.createSequentialGroup()
                .addContainerGap(123, Short.MAX_VALUE)
                .addComponent(btnAdicionar)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addContainerGap())
        );
        jPanelButtonsLayout.setVerticalGroup(
            jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAdicionar))
                .addContainerGap())
        );

        getContentPane().add(jPanelButtons, java.awt.BorderLayout.PAGE_END);

        jLabel1.setText("Nome");

        jLabel2.setText("Curso");

        jLabel3.setText("Fone");

        jLabel4.setText("Email");

        try {
            txfFone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanelRegistersLayout = new javax.swing.GroupLayout(jPanelRegisters);
        jPanelRegisters.setLayout(jPanelRegistersLayout);
        jPanelRegistersLayout.setHorizontalGroup(
            jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistersLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txfEmail)
                    .addComponent(cbCurso, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txfNome, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txfFone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                .addGap(37, 37, 37))
        );
        jPanelRegistersLayout.setVerticalGroup(
            jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistersLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txfNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txfFone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txfEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbCurso))
                .addContainerGap())
        );

        getContentPane().add(jPanelRegisters, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        // TODO add your handling code here:
        try {
            if (coordenador == null) {
                coordenador = new Coordenador();
                System.out.println("Chegou no Adicionar do FrameCoordenadorCadastro!!");
                coordenador.setNome(txfNome.getText());
                coordenador.setTelefone(txfFone.getText());
                coordenador.setEmail(txfEmail.getText());
                coordenador.setCursoCoordenacao((Curso) cbCurso.getSelectedItem());
                servico.add(coordenador);
            } else {
                System.out.println("Chegou no Editar do FrameCoordenadorCadastro!!");
                coordenador.setNome(txfNome.getText());
                coordenador.setTelefone(txfFone.getText());
                coordenador.setEmail(txfEmail.getText());
                coordenador.setCursoCoordenacao((Curso) cbCurso.getSelectedItem());
                servico.update(coordenador);
            }
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        limparCampos();
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(FrameCoordenadorCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameCoordenadorCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameCoordenadorCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameCoordenadorCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameCoordenadorCadastro().setVisible(true);
            }
        });
    }

    public Coordenador getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Coordenador coordenador) {
        this.coordenador = coordenador;
    }

    public JComboBox getCbCurso() {
        return cbCurso;
    }

    public void setCbCurso(JComboBox cbCurso) {
        this.cbCurso = cbCurso;
    }

    public JTextField getTxfEmail() {
        return txfEmail;
    }

    public void setTxfEmail(JTextField txfEmail) {
        this.txfEmail = txfEmail;
    }

    public JFormattedTextField getTxfFone() {
        return txfFone;
    }

    public void setTxfFone(JFormattedTextField txfFone) {
        this.txfFone = txfFone;
    }

    public JTextField getTxfNome() {
        return txfNome;
    }

    public void setTxfNome(JTextField txfNome) {
        this.txfNome = txfNome;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cbCurso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanelButtons;
    private javax.swing.JPanel jPanelRegisters;
    private javax.swing.JTextField txfEmail;
    private javax.swing.JFormattedTextField txfFone;
    private javax.swing.JTextField txfNome;
    // End of variables declaration//GEN-END:variables
}
