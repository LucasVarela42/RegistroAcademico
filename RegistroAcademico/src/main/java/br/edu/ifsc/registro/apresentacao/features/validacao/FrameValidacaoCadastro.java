/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.apresentacao.features.validacao;

import br.edu.ifsc.registro.dominio.features.aluno.Aluno;
import br.edu.ifsc.registro.dominio.features.coordenador.Coordenador;
import br.edu.ifsc.registro.dominio.features.protocolo.Protocolo;
import br.edu.ifsc.registro.dominio.features.protocolo.TipoProtocolo;
import br.edu.ifsc.registro.dominio.features.validacao.TipoValidacao;
import br.edu.ifsc.registro.dominio.features.validacao.Validacao;
import br.edu.ifsc.registro.servico.features.aluno.AlunoServico;
import br.edu.ifsc.registro.servico.features.coordenador.CoordenadorServico;
import br.edu.ifsc.registro.servico.features.protocolo.ProtocoloServico;
import br.edu.ifsc.registro.servico.features.validacao.ValidacaoServico;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Lucas
 */
public class FrameValidacaoCadastro extends javax.swing.JFrame {

    private Validacao validacao;
    private ValidacaoServico servico;
    private Protocolo protocolo;
    private ProtocoloServico protocoloServico;
    private AlunoServico alunoServico;
    private CoordenadorServico coordenadorServico;

    /**
     * Creates new form FrameValidacaoCadastro
     */
    public FrameValidacaoCadastro() {
        initComponents();
    }

    FrameValidacaoCadastro(ValidacaoServico validacaoServico, ProtocoloServico protocoloServico,
            AlunoServico alunoServico,
            CoordenadorServico coordenadorServico) {
        initComponents();
        this.servico = validacaoServico;
        this.protocoloServico = protocoloServico;
        this.alunoServico = alunoServico;
        this.coordenadorServico = coordenadorServico;
        System.out.println("Carregou FrameValidacao");
        carregarAluno();
        carregarCoordenador();
        carregarTipoValidacao();
        limparCampos();
        gerarNumeroProtocolo();
    }

    private void gerarNumeroProtocolo() {
        int instante = Instant.now().hashCode();
        if (instante < 0) {
            instante = instante * (-1);
        }
        txfNumeroProtocolo.setText(String.valueOf(instante));
    }

    private Protocolo gerarProtocolo() {
        protocolo = new Protocolo();
        protocolo.setNumero(txfNumeroProtocolo.getText());
        protocolo.setTipoProtocolo(TipoProtocolo.VALIDACAO);
        protocolo.setDataCadastro(LocalDate.now());
        protocolo.setAluno((Aluno) cbAlunoProtocolo.getSelectedItem());
        protocolo.setCoordenador((Coordenador) cbCoordenadorProtocolo.getSelectedItem());

        return protocolo;
    }

    private void limparCampos() {
        txfNumeroProtocolo.setText("");
        cbAlunoProtocolo.setSelectedIndex(0);
        cbCoordenadorProtocolo.setSelectedIndex(0);
        cbTipoValidacao.setSelectedIndex(0);
    }

    private void carregarAluno() {
        try {
            List<Aluno> alunos = alunoServico.getAll();
            for (Aluno aluno : alunos) {
                cbAlunoProtocolo.addItem(aluno);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }

    private void carregarCoordenador() {
        try {
            List<Coordenador> coordenadores = coordenadorServico.getAll();
            for (Coordenador coordenador : coordenadores) {
                cbCoordenadorProtocolo.addItem(coordenador);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }

    private void carregarTipoValidacao() {
        for (TipoValidacao value : TipoValidacao.values()) {
            cbTipoValidacao.addItem(value.url());
        }
    }

    /**
     *
     * @param nome
     * @return
     */
    public TipoValidacao getTipoValidacaoByNome(String nome) {
        for (TipoValidacao value : TipoValidacao.values()) {
            if (nome.equals(value.url())) {
                return value;
            }
        }
        return null;
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
        cbTipoValidacao = new javax.swing.JComboBox();
        spNota = new javax.swing.JSpinner();
        chkDeferida = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxaObservacao = new javax.swing.JTextArea();
        jPanelProtocolo = new javax.swing.JPanel();
        cbAlunoProtocolo = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbCoordenadorProtocolo = new javax.swing.JComboBox();
        txfNumeroProtocolo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Validação");
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
                .addContainerGap(136, Short.MAX_VALUE)
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

        jLabel1.setText("Nota");

        jLabel2.setText("Tipo da Validação");

        spNota.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        spNota.setEnabled(false);

        chkDeferida.setText("Validação deferida?");
        chkDeferida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkDeferidaActionPerformed(evt);
            }
        });

        jLabel3.setText("Observação:");

        TxaObservacao.setColumns(20);
        TxaObservacao.setRows(5);
        jScrollPane1.setViewportView(TxaObservacao);

        jPanelProtocolo.setBorder(javax.swing.BorderFactory.createTitledBorder("Protocolo"));

        jLabel7.setText("Aluno");

        jLabel8.setText("Coordenador");

        txfNumeroProtocolo.setEnabled(false);

        jLabel9.setText("Número");

        javax.swing.GroupLayout jPanelProtocoloLayout = new javax.swing.GroupLayout(jPanelProtocolo);
        jPanelProtocolo.setLayout(jPanelProtocoloLayout);
        jPanelProtocoloLayout.setHorizontalGroup(
            jPanelProtocoloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProtocoloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProtocoloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProtocoloLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanelProtocoloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelProtocoloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbAlunoProtocolo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txfNumeroProtocolo)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProtocoloLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCoordenadorProtocolo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelProtocoloLayout.setVerticalGroup(
            jPanelProtocoloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProtocoloLayout.createSequentialGroup()
                .addGroup(jPanelProtocoloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txfNumeroProtocolo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelProtocoloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAlunoProtocolo)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelProtocoloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbCoordenadorProtocolo))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelRegistersLayout = new javax.swing.GroupLayout(jPanelRegisters);
        jPanelRegisters.setLayout(jPanelRegistersLayout);
        jPanelRegistersLayout.setHorizontalGroup(
            jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistersLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelRegistersLayout.createSequentialGroup()
                        .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbTipoValidacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanelRegistersLayout.createSequentialGroup()
                                .addComponent(spNota, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkDeferida)))))
                .addGap(17, 17, 17))
            .addGroup(jPanelRegistersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelProtocolo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelRegistersLayout.setVerticalGroup(
            jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRegistersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelProtocolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTipoValidacao)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(spNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkDeferida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanelRegisters, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        // TODO add your handling code here:
        try {
            if (validacao == null) {
                validacao = new Validacao();
                System.out.println("Chegou no Adicionar do FrameValidacaoCadastro!!");
                validacao.setObservacao(TxaObservacao.getText());
                validacao.setTipoValidacao(getTipoValidacaoByNome(cbTipoValidacao.getSelectedItem().toString()));

                if (chkDeferida.isSelected()) {
                    spNota.setEnabled(true);
                }
                validacao.setNota((int) spNota.getValue());
                validacao.setDeferido(chkDeferida.isSelected());

                protocolo = protocoloServico.add(gerarProtocolo());
                validacao.setProtocolo(protocolo);

                servico.add(validacao);
            } else {
                System.out.println("Chegou no Editar do FrameValidacaoCadastro!!");
                validacao.setObservacao(TxaObservacao.getText());
                validacao.setTipoValidacao(getTipoValidacaoByNome(cbTipoValidacao.getSelectedItem().toString()));

                validacao.setNota((int) spNota.getValue());
                validacao.setDeferido(chkDeferida.isSelected());

                protocolo = protocoloServico.update(protocolo);
                validacao.setProtocolo(protocolo);
                servico.update(validacao);
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

    private void chkDeferidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkDeferidaActionPerformed
        // TODO add your handling code here:
        if (chkDeferida.isSelected()) {
            spNota.setEnabled(true);
        } else{
            spNota.setEnabled(false);
        }
    }//GEN-LAST:event_chkDeferidaActionPerformed

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
            java.util.logging.Logger.getLogger(FrameValidacaoCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameValidacaoCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameValidacaoCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameValidacaoCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new FrameValidacaoCadastro().setVisible(true);
            }
        });
    }

    /**
     *
     * @return
     */
    public Validacao getValidacao() {
        return validacao;
    }

    /**
     *
     * @param validacao
     */
    public void setValidacao(Validacao validacao) {
        this.validacao = validacao;
    }

    /**
     *
     * @return
     */
    public JTextArea getTxaObservacao() {
        return TxaObservacao;
    }

    /**
     *
     * @param TxaObservacao
     */
    public void setTxaObservacao(JTextArea TxaObservacao) {
        this.TxaObservacao = TxaObservacao;
    }

    /**
     *
     * @return
     */
    public JComboBox getCbAlunoProtocolo() {
        return cbAlunoProtocolo;
    }

    /**
     *
     * @param cbAlunoProtocolo
     */
    public void setCbAlunoProtocolo(JComboBox cbAlunoProtocolo) {
        this.cbAlunoProtocolo = cbAlunoProtocolo;
    }

    /**
     *
     * @return
     */
    public JComboBox getCbCoordenadorProtocolo() {
        return cbCoordenadorProtocolo;
    }

    /**
     *
     * @param cbCoordenadorProtocolo
     */
    public void setCbCoordenadorProtocolo(JComboBox cbCoordenadorProtocolo) {
        this.cbCoordenadorProtocolo = cbCoordenadorProtocolo;
    }

    /**
     *
     * @return
     */
    public JComboBox getCbTipoValidacao() {
        return cbTipoValidacao;
    }

    /**
     *
     * @param cbTipoValidacao
     */
    public void setCbTipoValidacao(JComboBox cbTipoValidacao) {
        this.cbTipoValidacao = cbTipoValidacao;
    }

    /**
     *
     * @return
     */
    public JCheckBox getChkDeferida() {
        return chkDeferida;
    }

    /**
     *
     * @param chkDeferida
     */
    public void setChkDeferida(JCheckBox chkDeferida) {
        this.chkDeferida = chkDeferida;
    }

    /**
     *
     * @return
     */
    public JSpinner getSpNota() {
        return spNota;
    }

    /**
     *
     * @param spNota
     */
    public void setSpNota(JSpinner spNota) {
        this.spNota = spNota;
    }

    /**
     *
     * @return
     */
    public JTextField getTxfNumeroProtocolo() {
        return txfNumeroProtocolo;
    }

    /**
     *
     * @param txfNumeroProtocolo
     */
    public void setTxfNumeroProtocolo(JTextField txfNumeroProtocolo) {
        this.txfNumeroProtocolo = txfNumeroProtocolo;
    }

    /**
     *
     * @return
     */
    public Protocolo getProtocolo() {
        return protocolo;
    }

    /**
     *
     * @param protocolo
     */
    public void setProtocolo(Protocolo protocolo) {
        this.protocolo = protocolo;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TxaObservacao;
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cbAlunoProtocolo;
    private javax.swing.JComboBox cbCoordenadorProtocolo;
    private javax.swing.JComboBox cbTipoValidacao;
    private javax.swing.JCheckBox chkDeferida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelButtons;
    private javax.swing.JPanel jPanelProtocolo;
    private javax.swing.JPanel jPanelRegisters;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spNota;
    private javax.swing.JTextField txfNumeroProtocolo;
    // End of variables declaration//GEN-END:variables
}
