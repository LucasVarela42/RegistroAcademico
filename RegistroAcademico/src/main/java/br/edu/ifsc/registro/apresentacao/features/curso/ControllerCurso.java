/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.apresentacao.features.curso;

import br.edu.ifsc.registro.apresentacao.ControllerFormulario;
import br.edu.ifsc.registro.dominio.features.curso.Curso;
import br.edu.ifsc.registro.servico.features.curso.CursoServico;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class ControllerCurso extends ControllerFormulario<Curso> {

    private CursoServico servico;
    private FrameCursoCadastro cursoCadastro;

    /**
     *
     * @param cursoServico
     */
    public ControllerCurso(CursoServico cursoServico) {
        this.servico = cursoServico;

    }

    /**
     *
     */
    @Override
    public void adicionar() {
        cursoCadastro = new FrameCursoCadastro(servico);
        cursoCadastro.setVisible(true);
        System.out.println("Chegou no adicionar!!");
    }

    /**
     *
     * @param obj
     */
    @Override
    public void editar(Curso obj) {
        if (obj != null) {
            cursoCadastro = new FrameCursoCadastro(servico);
            atribuirSelecionado(obj);
            cursoCadastro.setVisible(true);
            System.out.println("Chegou no editar!!");
        } else {
            JOptionPane.showMessageDialog(cursoCadastro, "Selecione um curso!");
        }
    }

    /**
     *
     * @param obj
     */
    @Override
    public void remover(Curso obj) {
        try {
            if (obj != null) {
                int opc = JOptionPane.showConfirmDialog(cursoCadastro,
                        "Deseja excluir o curso " + obj.getNome() + "?",
                        "Remover curso",
                        JOptionPane.YES_NO_OPTION);
                if (opc == JOptionPane.YES_OPTION) {
                    servico.delete(obj);
                }
            } else {
                JOptionPane.showMessageDialog(cursoCadastro, "Selecione um curso!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(cursoCadastro, "Não é possivel excluir curso vinculado!");
        }
    }

    /**
     *
     * @return
     */
    @Override
    public List<Curso> carregarLista() {
        try {
            return servico.getAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(cursoCadastro, ex.getMessage());
        }
        return null;
    }

    /**
     *
     * @param obj
     */
    @Override
    public void atribuirSelecionado(Curso obj) {
        cursoCadastro.setCurso(obj);
        cursoCadastro.getTxfNome().setText(obj.getNome());
        cursoCadastro.getCbTipoCurso().setSelectedIndex(obj.getTipoCurso().ordinal());
    }

}
