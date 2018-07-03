/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.apresentacao.features.aluno;

import br.edu.ifsc.registro.apresentacao.ControllerFormulario;
import br.edu.ifsc.registro.dominio.features.aluno.Aluno;
import br.edu.ifsc.registro.servico.features.aluno.AlunoServico;
import br.edu.ifsc.registro.servico.features.curso.CursoServico;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class ControllerAluno extends ControllerFormulario<Aluno> {

    private AlunoServico servico;
    private CursoServico cursoServico;
    private FrameAlunoCadastro alunoCadastro;

    /**
     *
     * @param alunoServico
     * @param cursoServico
     */
    public ControllerAluno(AlunoServico alunoServico, CursoServico cursoServico) {
        this.servico = alunoServico;
        this.cursoServico = cursoServico;
    }

    /**
     *
     */
    @Override
    public void adicionar() {
        alunoCadastro = new FrameAlunoCadastro(servico, cursoServico);
        alunoCadastro.setVisible(true);
        System.out.println("Chegou no adicionar!!");
    }

    /**
     *
     * @param obj
     */
    @Override
    public void editar(Aluno obj) {
        if (obj != null) {
            alunoCadastro = new FrameAlunoCadastro(servico, cursoServico);
            atribuirSelecionado(obj);
            alunoCadastro.setVisible(true);
            System.out.println("Chegou no editar!!");
        } else {
            JOptionPane.showMessageDialog(alunoCadastro, "Selecione um aluno!");
        }
    }

    /**
     *
     * @param obj
     */
    @Override
    public void remover(Aluno obj) {
        try {
            if (obj != null) {
                int opc = JOptionPane.showConfirmDialog(alunoCadastro,
                        "Deseja excluir o aluno " + obj.getNome() + "?",
                        "Remover aluno",
                        JOptionPane.YES_NO_OPTION);
                if (opc == JOptionPane.YES_OPTION) {
                    servico.delete(obj);
                }
            } else {
                JOptionPane.showMessageDialog(alunoCadastro, "Selecione um aluno!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(alunoCadastro, ex.getMessage());
        }
    }

    /**
     *
     * @return
     */
    @Override
    public List<Aluno> carregarLista() {
        try {
            return servico.getAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(alunoCadastro, ex.getMessage());
        }
        return null;
    }

    /**
     *
     * @param obj
     */
    @Override
    public void atribuirSelecionado(Aluno obj) {
        alunoCadastro.setAluno(obj);
        alunoCadastro.getTxfNome().setText(obj.getNome());
        alunoCadastro.getTxfFone().setText(obj.getTelefone());
        alunoCadastro.getTxfEmail().setText(obj.getEmail());
        alunoCadastro.getCbCurso().setSelectedItem(obj.getCurso());
    }

}
