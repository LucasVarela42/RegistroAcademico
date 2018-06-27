/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.apresentacao.features.segundaChamada;

import br.edu.ifsc.registro.apresentacao.features.protocolo.*;
import br.edu.ifsc.registro.apresentacao.features.disciplina.*;
import br.edu.ifsc.registro.apresentacao.features.segundaChamada.*;
import br.edu.ifsc.registro.apresentacao.ControllerFormulario;
import br.edu.ifsc.registro.servico.features.segundaChamada.SegundaChamadaServico;

/**
 *
 * @author Lucas
 */
public class ControllerSegundaChamada extends ControllerFormulario {

    private SegundaChamadaServico servico;
    private FrameSegundaChamadaCadastro segundaChamadaCadastro;

    public ControllerSegundaChamada(SegundaChamadaServico segundaChamadaServico) {
        this.servico = segundaChamadaServico;
    }

    @Override
    public void Adicionar() {
        segundaChamadaCadastro = new FrameSegundaChamadaCadastro(servico);
        segundaChamadaCadastro.setVisible(true);
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
