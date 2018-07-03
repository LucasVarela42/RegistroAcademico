/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.apresentacao;

import br.edu.ifsc.registro.apresentacao.features.aluno.ControllerAluno;
import br.edu.ifsc.registro.apresentacao.features.coordenador.ControllerCoordenador;
import br.edu.ifsc.registro.apresentacao.features.curso.ControllerCurso;
import br.edu.ifsc.registro.apresentacao.features.disciplina.ControllerDisciplina;
import br.edu.ifsc.registro.apresentacao.features.segundaChamada.ControllerSegundaChamada;
import br.edu.ifsc.registro.apresentacao.features.validacao.ControllerValidacao;
import br.edu.ifsc.registro.dominio.features.aluno.IAlunoRepositorio;
import br.edu.ifsc.registro.dominio.features.coordenador.ICoordenadorRepositorio;
import br.edu.ifsc.registro.dominio.features.curso.ICursoRepositorio;
import br.edu.ifsc.registro.dominio.features.disciplina.IDisciplinaRepositorio;
import br.edu.ifsc.registro.dominio.features.protocolo.IProtocoloRepositorio;
import br.edu.ifsc.registro.dominio.features.segundaChamada.ISegundaChamadaRepositorio;
import br.edu.ifsc.registro.dominio.features.validacao.IValidacaoRepositorio;
import br.edu.ifsc.registro.infraestrutura.data.features.aluno.AlunoRepositorio;
import br.edu.ifsc.registro.infraestrutura.data.features.coordenador.CoordenadorRepositorio;
import br.edu.ifsc.registro.infraestrutura.data.features.curso.CursoRepositorio;
import br.edu.ifsc.registro.infraestrutura.data.features.disciplina.DisciplinaRepositorio;
import br.edu.ifsc.registro.infraestrutura.data.features.protocolo.ProtocoloRepositorio;
import br.edu.ifsc.registro.infraestrutura.data.features.segundaChamada.SegundaChamadaRepositorio;
import br.edu.ifsc.registro.infraestrutura.data.features.validacao.ValidacaoRepositorio;
import br.edu.ifsc.registro.servico.features.aluno.AlunoServico;
import br.edu.ifsc.registro.servico.features.coordenador.CoordenadorServico;
import br.edu.ifsc.registro.servico.features.curso.CursoServico;
import br.edu.ifsc.registro.servico.features.disciplina.DisciplinaServico;
import br.edu.ifsc.registro.servico.features.protocolo.ProtocoloServico;
import br.edu.ifsc.registro.servico.features.segundaChamada.SegundaChamadaServico;
import br.edu.ifsc.registro.servico.features.validacao.ValidacaoServico;
import javax.swing.DefaultListModel;

/**
 *
 * @author Lucas
 */
public class FramePrincipal extends javax.swing.JFrame {

    private ICursoRepositorio cursoRepositorio;
    private CursoServico cursoServico;

    private IDisciplinaRepositorio disciplinaRepositorio;
    private DisciplinaServico disciplinaServico;

    private IAlunoRepositorio alunoRepositorio;
    private AlunoServico alunoServico;

    private ICoordenadorRepositorio coordenadorRepositorio;
    private CoordenadorServico coordenadorServico;

    private IProtocoloRepositorio protocoloRepositorio;
    private ProtocoloServico protocoloServico;

    private ISegundaChamadaRepositorio segundaChamadaRepositorio;
    private SegundaChamadaServico segundaChamadaServico;

    private IValidacaoRepositorio validacaoRepositorio;
    private ValidacaoServico validacaoServico;

    private ControllerFormulario controller;
    private ControllerCurso controllerCurso;
    private ControllerDisciplina controllerDisciplina;
    private ControllerAluno controllerAluno;
    private ControllerCoordenador controllerCoordenador;
    private ControllerSegundaChamada controllerSegundaChamada;
    private ControllerValidacao controllerValidacao;
    private DefaultListModel modelLista;

    /**
     * Creates new form FramePrincipal
     */
    public FramePrincipal() {
        initComponents();

        this.cursoRepositorio = new CursoRepositorio();
        this.cursoServico = new CursoServico(cursoRepositorio);

        this.disciplinaRepositorio = new DisciplinaRepositorio();
        this.disciplinaServico = new DisciplinaServico(disciplinaRepositorio);

        this.alunoRepositorio = new AlunoRepositorio();
        this.alunoServico = new AlunoServico(alunoRepositorio, cursoRepositorio);

        this.coordenadorRepositorio = new CoordenadorRepositorio();
        this.coordenadorServico = new CoordenadorServico(coordenadorRepositorio, cursoRepositorio);

        this.protocoloRepositorio = new ProtocoloRepositorio();
        this.protocoloServico = new ProtocoloServico(protocoloRepositorio, alunoRepositorio, coordenadorRepositorio);

        this.segundaChamadaRepositorio = new SegundaChamadaRepositorio();
        this.segundaChamadaServico = new SegundaChamadaServico(segundaChamadaRepositorio, protocoloRepositorio);

        this.validacaoRepositorio = new ValidacaoRepositorio();
        this.validacaoServico = new ValidacaoServico(validacaoRepositorio, protocoloRepositorio);

    }

    private void carregarListaPrincipal() {
        modelLista = new DefaultListModel();
        for (Object object : controller.carregarLista()) {
            modelLista.addElement(object);
        }
        listPrincipal.setModel(modelLista);
    }

    private void CarregarCadastro(ControllerFormulario controller) {
        this.controller = controller;
        carregarListaPrincipal();
        btnAdicionar.setEnabled(true);
        btnEditar.setEnabled(true);
        btnRemover.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBarCadastros = new javax.swing.JToolBar();
        btnAdicionar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        panelPrincipal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listPrincipal = new javax.swing.JList();
        jMenuBarPrincipal = new javax.swing.JMenuBar();
        jMenuCadastros = new javax.swing.JMenu();
        menuItemCurso = new javax.swing.JMenuItem();
        menuItemDisciplina = new javax.swing.JMenuItem();
        menuItemAluno = new javax.swing.JMenuItem();
        menuItemCoordenador = new javax.swing.JMenuItem();
        menuItemSegundaChamada = new javax.swing.JMenuItem();
        menuItemValidacao = new javax.swing.JMenuItem();
        menuItemSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jToolBarCadastros.setFloatable(false);

        btnAdicionar.setText("Adicionar");
        btnAdicionar.setEnabled(false);
        btnAdicionar.setFocusable(false);
        btnAdicionar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdicionar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        jToolBarCadastros.add(btnAdicionar);

        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.setFocusable(false);
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jToolBarCadastros.add(btnEditar);

        btnRemover.setText("Remover");
        btnRemover.setEnabled(false);
        btnRemover.setFocusable(false);
        btnRemover.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRemover.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });
        jToolBarCadastros.add(btnRemover);

        panelPrincipal.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        listPrincipal.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(listPrincipal);

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
        );

        jMenuCadastros.setText("Cadastros");

        menuItemCurso.setText("Curso");
        menuItemCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCursoActionPerformed(evt);
            }
        });
        jMenuCadastros.add(menuItemCurso);

        menuItemDisciplina.setText("Disciplina");
        menuItemDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemDisciplinaActionPerformed(evt);
            }
        });
        jMenuCadastros.add(menuItemDisciplina);

        menuItemAluno.setText("Aluno");
        menuItemAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAlunoActionPerformed(evt);
            }
        });
        jMenuCadastros.add(menuItemAluno);

        menuItemCoordenador.setText("Coordenador");
        menuItemCoordenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCoordenadorActionPerformed(evt);
            }
        });
        jMenuCadastros.add(menuItemCoordenador);

        menuItemSegundaChamada.setText("Segunda Chamada Avaliativa");
        menuItemSegundaChamada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSegundaChamadaActionPerformed(evt);
            }
        });
        jMenuCadastros.add(menuItemSegundaChamada);

        menuItemValidacao.setText("Validação");
        menuItemValidacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemValidacaoActionPerformed(evt);
            }
        });
        jMenuCadastros.add(menuItemValidacao);

        menuItemSair.setText("Sair");
        menuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSairActionPerformed(evt);
            }
        });
        jMenuCadastros.add(menuItemSair);

        jMenuBarPrincipal.add(jMenuCadastros);

        setJMenuBar(jMenuBarPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBarCadastros, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBarCadastros, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCursoActionPerformed
        // TODO add your handling code here:
        if (controllerCurso == null) {
            controllerCurso = new ControllerCurso(cursoServico);
        }
        CarregarCadastro(controllerCurso);

    }//GEN-LAST:event_menuItemCursoActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        // TODO add your handling code here:
        this.controller.adicionar();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void menuItemDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemDisciplinaActionPerformed
        // TODO add your handling code here:
        if (controllerDisciplina == null) {
            controllerDisciplina = new ControllerDisciplina(disciplinaServico, cursoServico);
        }
        CarregarCadastro(controllerDisciplina);
    }//GEN-LAST:event_menuItemDisciplinaActionPerformed

    private void menuItemAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAlunoActionPerformed
        // TODO add your handling code here:
        if (controllerAluno == null) {
            controllerAluno = new ControllerAluno(alunoServico, cursoServico);
        }
        CarregarCadastro(controllerAluno);
    }//GEN-LAST:event_menuItemAlunoActionPerformed

    private void menuItemCoordenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCoordenadorActionPerformed
        // TODO add your handling code here:
        if (controllerCoordenador == null) {
            controllerCoordenador = new ControllerCoordenador(coordenadorServico, cursoServico);
        }
        CarregarCadastro(controllerCoordenador);
    }//GEN-LAST:event_menuItemCoordenadorActionPerformed

    private void menuItemSegundaChamadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSegundaChamadaActionPerformed
        // TODO add your handling code here:
        if (controllerSegundaChamada == null) {
            controllerSegundaChamada = new ControllerSegundaChamada(segundaChamadaServico, protocoloServico, alunoServico, coordenadorServico);
        }
        CarregarCadastro(controllerSegundaChamada);
    }//GEN-LAST:event_menuItemSegundaChamadaActionPerformed

    private void menuItemValidacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemValidacaoActionPerformed
        // TODO add your handling code here:
        if (controllerValidacao == null) {
            controllerValidacao = new ControllerValidacao(validacaoServico, protocoloServico, alunoServico, coordenadorServico);
        }
        CarregarCadastro(controllerValidacao);
    }//GEN-LAST:event_menuItemValidacaoActionPerformed

    private void menuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSairActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_menuItemSairActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if (modelLista != null) {
            carregarListaPrincipal();
        }
    }//GEN-LAST:event_formWindowActivated

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        this.controller.editar(listPrincipal.getSelectedValue());
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        // TODO add your handling code here:
        this.controller.remover(listPrincipal.getSelectedValue());
        carregarListaPrincipal();
    }//GEN-LAST:event_btnRemoverActionPerformed

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
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JMenuBar jMenuBarPrincipal;
    private javax.swing.JMenu jMenuCadastros;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBarCadastros;
    private javax.swing.JList listPrincipal;
    private javax.swing.JMenuItem menuItemAluno;
    private javax.swing.JMenuItem menuItemCoordenador;
    private javax.swing.JMenuItem menuItemCurso;
    private javax.swing.JMenuItem menuItemDisciplina;
    private javax.swing.JMenuItem menuItemSair;
    private javax.swing.JMenuItem menuItemSegundaChamada;
    private javax.swing.JMenuItem menuItemValidacao;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
