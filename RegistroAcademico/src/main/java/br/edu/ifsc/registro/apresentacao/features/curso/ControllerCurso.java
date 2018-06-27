/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.apresentacao.features.curso;

import br.edu.ifsc.registro.apresentacao.ControllerFormulario;
import br.edu.ifsc.registro.servico.features.curso.CursoServico;

/**
 *
 * @author Lucas
 */
public class ControllerCurso extends ControllerFormulario {

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
    public void Adicionar() {
        cursoCadastro = new FrameCursoCadastro(servico);
        cursoCadastro.setVisible(true);
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
