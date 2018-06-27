/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.apresentacao.features.disciplina;

import br.edu.ifsc.registro.apresentacao.features.disciplina.*;
import br.edu.ifsc.registro.apresentacao.ControllerFormulario;
import br.edu.ifsc.registro.servico.features.disciplina.DisciplinaServico;

/**
 *
 * @author Lucas
 */
public class ControllerDisciplina extends ControllerFormulario {

    private DisciplinaServico servico;
    private FrameDisciplinaCadastro disciplinaCadastro;

    public ControllerDisciplina(DisciplinaServico disciplinaServico) {
        this.servico = disciplinaServico;
    }

    @Override
    public void Adicionar() {
        disciplinaCadastro = new FrameDisciplinaCadastro(servico);
        disciplinaCadastro.setVisible(true);
        System.out.println("Chegou no adicionar!!");
    }

    @Override
    public void Editar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Remover() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
