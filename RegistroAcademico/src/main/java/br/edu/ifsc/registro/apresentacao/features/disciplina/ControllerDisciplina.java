/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.apresentacao.features.disciplina;

import br.edu.ifsc.registro.apresentacao.ControllerFormulario;
import br.edu.ifsc.registro.dominio.features.disciplina.Disciplina;
import br.edu.ifsc.registro.servico.features.curso.CursoServico;
import br.edu.ifsc.registro.servico.features.disciplina.DisciplinaServico;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class ControllerDisciplina extends ControllerFormulario<Disciplina> {

    private DisciplinaServico servico;
    private CursoServico cursoServico;
    private FrameDisciplinaCadastro disciplinaCadastro;

    /**
     *
     * @param disciplinaServico
     * @param cursoServico
     */
    public ControllerDisciplina(DisciplinaServico disciplinaServico, CursoServico cursoServico) {
        this.servico = disciplinaServico;
        this.cursoServico = cursoServico;
    }

    /**
     *
     */
    @Override
    public void adicionar() {
        disciplinaCadastro = new FrameDisciplinaCadastro(servico, cursoServico);
        disciplinaCadastro.setVisible(true);
        System.out.println("Chegou no adicionar!!");
    }

    /**
     *
     * @param obj
     */
    @Override
    public void editar(Disciplina obj) {
        if (obj != null) {
            disciplinaCadastro = new FrameDisciplinaCadastro(servico, cursoServico);
            atribuirSelecionado(obj);
            disciplinaCadastro.setVisible(true);
            System.out.println("Chegou no editar!!");
        } else {
            JOptionPane.showMessageDialog(disciplinaCadastro, "Selecione uma disciplina!");
        }
    }

    /**
     *
     * @param obj
     */
    @Override
    public void remover(Disciplina obj) {
        try {
            if (obj != null) {
                int opc = JOptionPane.showConfirmDialog(disciplinaCadastro,
                        "Deseja excluir a disciplina " + obj.getNome() + "?",
                        "Remover disciplina",
                        JOptionPane.YES_NO_OPTION);
                if (opc == JOptionPane.YES_OPTION) {
                    servico.delete(obj);
                }
            } else {
                JOptionPane.showMessageDialog(disciplinaCadastro, "Selecione uma disciplina!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(disciplinaCadastro, ex.getMessage());
        }
    }

    /**
     *
     * @return
     */
    @Override
    public List<Disciplina> carregarLista() {
        try {
            return servico.getAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(disciplinaCadastro, ex.getMessage());
        }
        return null;
    }

    /**
     *
     * @param obj
     */
    @Override
    public void atribuirSelecionado(Disciplina obj) {
        disciplinaCadastro.setDisciplina(obj);
        disciplinaCadastro.getTxfNome().setText(obj.getNome());
        disciplinaCadastro.getTxfSigla().setText(obj.getSigla());
        disciplinaCadastro.getSpCargaHoraria().setValue(obj.getCargaHoraria());
        disciplinaCadastro.getCbCurso().setSelectedItem(obj.getCurso());
    }
    
    @Override
    public String ObtemTipoCadastro() {
        return "Cadastro de Disciplina";
    }

}
