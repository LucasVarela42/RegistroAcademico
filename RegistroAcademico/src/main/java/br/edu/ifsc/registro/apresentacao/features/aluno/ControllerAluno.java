/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.apresentacao.features.aluno;

import br.edu.ifsc.registro.apresentacao.features.aluno.*;
import br.edu.ifsc.registro.apresentacao.ControllerFormulario;
import br.edu.ifsc.registro.servico.features.aluno.AlunoServico;

/**
 *
 * @author Lucas
 */
public class ControllerAluno extends ControllerFormulario {

    private AlunoServico servico;
    private FrameAlunoCadastro alunoCadastro;

    /**
     *
     * @param alunoServico
     */
    public ControllerAluno(AlunoServico alunoServico) {
        this.servico = alunoServico;
    }

    /**
     *
     */
    @Override
    public void Adicionar() {
        alunoCadastro = new FrameAlunoCadastro(servico);
        alunoCadastro.setVisible(true);
        System.out.println("Chegou no adicionar!!");
    }

    /**
     *
     */
    @Override
    public void Editar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     */
    @Override
    public void Remover() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
