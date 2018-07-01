/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.apresentacao.features.segundaChamada;

import br.edu.ifsc.registro.apresentacao.ControllerFormulario;
import br.edu.ifsc.registro.dominio.features.segundaChamada.SegundaChamadaAtividadeAvaliativa;
import br.edu.ifsc.registro.servico.features.segundaChamada.SegundaChamadaServico;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class ControllerSegundaChamada extends ControllerFormulario<SegundaChamadaAtividadeAvaliativa> {

    private SegundaChamadaServico servico;
    private FrameSegundaChamadaCadastro segundaChamadaCadastro;

    /**
     *
     * @param segundaChamadaServico
     */
    public ControllerSegundaChamada(SegundaChamadaServico segundaChamadaServico) {
        this.servico = segundaChamadaServico;
    }

    @Override
    public void adicionar() {
        segundaChamadaCadastro = new FrameSegundaChamadaCadastro(servico);
        segundaChamadaCadastro.setVisible(true);
        System.out.println("Chegou no adicionar!!");
    }

    @Override
    public void editar(SegundaChamadaAtividadeAvaliativa obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(SegundaChamadaAtividadeAvaliativa obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SegundaChamadaAtividadeAvaliativa> carregarLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atribuirSelecionado(SegundaChamadaAtividadeAvaliativa obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
