/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.apresentacao.features.validacao;

import br.edu.ifsc.registro.apresentacao.ControllerFormulario;
import br.edu.ifsc.registro.dominio.features.validacao.Validacao;
import br.edu.ifsc.registro.servico.features.aluno.AlunoServico;
import br.edu.ifsc.registro.servico.features.coordenador.CoordenadorServico;
import br.edu.ifsc.registro.servico.features.protocolo.ProtocoloServico;
import br.edu.ifsc.registro.servico.features.validacao.ValidacaoServico;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class ControllerValidacao extends ControllerFormulario<Validacao> {

    private ValidacaoServico servico;
    private ProtocoloServico protocoloServico;
    private AlunoServico alunoServico;
    private CoordenadorServico coordenadorServico;
    private FrameValidacaoCadastro validacaoCadastro;

    /**
     *
     * @param validacaoServico
     * @param protocoloServico
     * @param coordenadorServico
     * @param alunoServico
     */
    public ControllerValidacao(ValidacaoServico validacaoServico,
            ProtocoloServico protocoloServico,
            AlunoServico alunoServico,
            CoordenadorServico coordenadorServico) {
        this.servico = validacaoServico;
        this.protocoloServico = protocoloServico;
        this.alunoServico = alunoServico;
        this.coordenadorServico = coordenadorServico;
    }

    @Override
    public void adicionar() {
        validacaoCadastro = new FrameValidacaoCadastro(servico,
                protocoloServico,
                alunoServico,
                coordenadorServico);
        validacaoCadastro.setVisible(true);
        System.out.println("Chegou no adicionar!!");
    }

    /**
     *
     * @param obj
     */
    @Override
    public void editar(Validacao obj) {
        if (obj != null) {
            validacaoCadastro = new FrameValidacaoCadastro(servico, protocoloServico, alunoServico, coordenadorServico);
            atribuirSelecionado(obj);
            validacaoCadastro.setVisible(true);
            System.out.println("Chegou no editar!!");
        } else {
            JOptionPane.showMessageDialog(validacaoCadastro, "Selecione uma validação!");
        }
    }

    /**
     *
     * @param obj
     */
    @Override
    public void remover(Validacao obj) {
        try {
            if (obj != null) {
                int opc = JOptionPane.showConfirmDialog(validacaoCadastro,
                        "Deseja excluir a validação Número " + obj.getProtocolo().getNumero() + "?",
                        "Remover validação",
                        JOptionPane.YES_NO_OPTION);
                if (opc == JOptionPane.YES_OPTION) {
                    servico.delete(obj);
                }
            } else {
                JOptionPane.showMessageDialog(validacaoCadastro, "Selecione uma validação!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(validacaoCadastro, ex.getMessage());
        }
    }

    /**
     *
     * @return
     */
    @Override
    public List<Validacao> carregarLista() {
        try {
            return servico.getAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(validacaoCadastro, ex.getMessage());
        }
        return null;
    }

    /**
     *
     * @param obj
     */
    @Override
    public void atribuirSelecionado(Validacao obj) {
        validacaoCadastro.setValidacao(obj);
        validacaoCadastro.setProtocolo(obj.getProtocolo());

        validacaoCadastro.getTxaObservacao().setText(obj.getObservacao());
        validacaoCadastro.getSpNota().setValue(obj.getNota());
        validacaoCadastro.getCbTipoValidacao().setSelectedIndex(obj.getTipoValidacao().ordinal());
        validacaoCadastro.getChkDeferida().setSelected(obj.isDeferido());

        validacaoCadastro.getTxfNumeroProtocolo().setText(obj.getProtocolo().getNumero());
        validacaoCadastro.getCbAlunoProtocolo().setSelectedItem(obj.getProtocolo().getAluno());
        validacaoCadastro.getCbCoordenadorProtocolo().setSelectedItem(obj.getProtocolo().getCoordenador());
    }

}
