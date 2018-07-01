/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.apresentacao.features.coordenador;

import br.edu.ifsc.registro.apresentacao.ControllerFormulario;
import br.edu.ifsc.registro.dominio.features.coordenador.Coordenador;
import br.edu.ifsc.registro.servico.features.coordenador.CoordenadorServico;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class ControllerCoordenador extends ControllerFormulario<Coordenador> {

    private CoordenadorServico servico;
    private FrameCoordenadorCadastro coordenadorCadastro;

    /**
     *
     * @param coordenadorServico
     */
    public ControllerCoordenador(CoordenadorServico coordenadorServico) {
        this.servico = coordenadorServico;
    }

    @Override
    public void adicionar() {
        coordenadorCadastro = new FrameCoordenadorCadastro(servico);
        coordenadorCadastro.setVisible(true);
        System.out.println("Chegou no adicionar!!");
    }

    @Override
    public void editar(Coordenador obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Coordenador obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Coordenador> carregarLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atribuirSelecionado(Coordenador obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     */
}
