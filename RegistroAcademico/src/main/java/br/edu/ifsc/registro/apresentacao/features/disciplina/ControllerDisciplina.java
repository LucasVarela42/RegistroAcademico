/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.apresentacao.features.disciplina;

import br.edu.ifsc.registro.apresentacao.ControllerFormulario;
import br.edu.ifsc.registro.dominio.features.disciplina.Disciplina;
import br.edu.ifsc.registro.servico.features.disciplina.DisciplinaServico;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class ControllerDisciplina extends ControllerFormulario<Disciplina> {

    private DisciplinaServico servico;
    private FrameDisciplinaCadastro disciplinaCadastro;

    /**
     *
     * @param disciplinaServico
     */
    public ControllerDisciplina(DisciplinaServico disciplinaServico) {
        this.servico = disciplinaServico;
    }

    @Override
    public void adicionar() {
        disciplinaCadastro = new FrameDisciplinaCadastro(servico);
        disciplinaCadastro.setVisible(true);
        System.out.println("Chegou no adicionar!!");
    }

    @Override
    public void editar(Disciplina obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Disciplina obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Disciplina> carregarLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atribuirSelecionado(Disciplina obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
