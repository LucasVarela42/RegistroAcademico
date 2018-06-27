/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.apresentacao.features.validacao;

import br.edu.ifsc.registro.apresentacao.features.segundaChamada.*;
import br.edu.ifsc.registro.apresentacao.features.protocolo.*;
import br.edu.ifsc.registro.apresentacao.features.disciplina.*;
import br.edu.ifsc.registro.apresentacao.features.validacao.*;
import br.edu.ifsc.registro.apresentacao.ControllerFormulario;
import br.edu.ifsc.registro.servico.features.validacao.ValidacaoServico;

/**
 *
 * @author Lucas
 */
public class ControllerValidacao extends ControllerFormulario {

    private ValidacaoServico servico;
    private FrameValidacaoCadastro validacaoCadastro;

    public ControllerValidacao(ValidacaoServico validacaoServico) {
        this.servico = validacaoServico;
    }

    @Override
    public void Adicionar() {
        validacaoCadastro = new FrameValidacaoCadastro(servico);
        validacaoCadastro.setVisible(true);
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
