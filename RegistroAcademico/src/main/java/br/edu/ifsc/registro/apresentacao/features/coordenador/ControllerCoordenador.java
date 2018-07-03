/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.apresentacao.features.coordenador;

import br.edu.ifsc.registro.apresentacao.ControllerFormulario;
import br.edu.ifsc.registro.dominio.features.coordenador.Coordenador;
import br.edu.ifsc.registro.servico.features.coordenador.CoordenadorServico;
import br.edu.ifsc.registro.servico.features.curso.CursoServico;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class ControllerCoordenador extends ControllerFormulario<Coordenador> {

    private CoordenadorServico servico;
    private CursoServico cursoServico;
    private FrameCoordenadorCadastro coordenadorCadastro;

    /**
     *
     * @param coordenadorServico
     */
    public ControllerCoordenador(CoordenadorServico coordenadorServico, CursoServico cursoServico) {
        this.servico = coordenadorServico;
        this.cursoServico = cursoServico;
    }

    /**
     *
     */
    @Override
    public void adicionar() {
        coordenadorCadastro = new FrameCoordenadorCadastro(servico, cursoServico);
        coordenadorCadastro.setVisible(true);
        System.out.println("Chegou no adicionar!!");
    }

    /**
     *
     */
    @Override
    public void editar(Coordenador obj) {
        if (obj != null) {
            coordenadorCadastro = new FrameCoordenadorCadastro(servico, cursoServico);
            atribuirSelecionado(obj);
            coordenadorCadastro.setVisible(true);
            System.out.println("Chegou no editar!!");
        } else {
            JOptionPane.showMessageDialog(coordenadorCadastro, "Selecione um coordenador!");
        }
    }

    /**
     *
     */
    @Override
    public void remover(Coordenador obj) {
        try {
            if (obj != null) {
                int opc = JOptionPane.showConfirmDialog(coordenadorCadastro,
                        "Deseja excluir o coordenador " + obj.getNome() + "?",
                        "Remover coordenador",
                        JOptionPane.YES_NO_OPTION);
                if (opc == JOptionPane.YES_OPTION) {
                    servico.delete(obj);
                }
            } else {
                JOptionPane.showMessageDialog(coordenadorCadastro, "Selecione um coordenador!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(coordenadorCadastro, ex.getMessage());
        }
    }

    @Override
    public List<Coordenador> carregarLista() {
        try {
            return servico.getAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(coordenadorCadastro, ex.getMessage());
        }
        return null;
    }

    @Override
    public void atribuirSelecionado(Coordenador obj) {
        coordenadorCadastro.setCoordenador(obj);
        coordenadorCadastro.getTxfNome().setText(obj.getNome());
        coordenadorCadastro.getTxfFone().setText(obj.getTelefone());
        coordenadorCadastro.getTxfEmail().setText(obj.getEmail());
        coordenadorCadastro.getCbCurso().setSelectedItem(obj.getCursoCoordenacao());
    }

}
