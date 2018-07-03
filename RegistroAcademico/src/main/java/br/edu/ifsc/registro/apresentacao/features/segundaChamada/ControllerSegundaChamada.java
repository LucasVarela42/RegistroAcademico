/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.apresentacao.features.segundaChamada;

import br.edu.ifsc.registro.apresentacao.ControllerFormulario;
import br.edu.ifsc.registro.dominio.features.segundaChamada.SegundaChamadaAtividadeAvaliativa;
import br.edu.ifsc.registro.servico.features.aluno.AlunoServico;
import br.edu.ifsc.registro.servico.features.coordenador.CoordenadorServico;
import br.edu.ifsc.registro.servico.features.protocolo.ProtocoloServico;
import br.edu.ifsc.registro.servico.features.segundaChamada.SegundaChamadaServico;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class ControllerSegundaChamada extends ControllerFormulario<SegundaChamadaAtividadeAvaliativa> {

    private SegundaChamadaServico servico;
    private ProtocoloServico protocoloServico;
    private AlunoServico alunoServico;
    private CoordenadorServico coordenadorServico;
    private FrameSegundaChamadaCadastro segundaChamadaCadastro;

    /**
     *
     * @param segundaChamadaServico
     * @param protocoloServico
     * @param alunoServico
     * @param coordenadorServico
     */
    public ControllerSegundaChamada(
            SegundaChamadaServico segundaChamadaServico,
            ProtocoloServico protocoloServico,
            AlunoServico alunoServico,
            CoordenadorServico coordenadorServico) {
        this.servico = segundaChamadaServico;
        this.protocoloServico = protocoloServico;
        this.alunoServico = alunoServico;
        this.coordenadorServico = coordenadorServico;
    }

    /**
     *
     */
    @Override
    public void adicionar() {
        segundaChamadaCadastro = new FrameSegundaChamadaCadastro(servico,
                protocoloServico,
                alunoServico,
                coordenadorServico);
        segundaChamadaCadastro.setVisible(true);
        System.out.println("Chegou no adicionar!!");
    }

    /**
     *
     * @param obj
     */
    @Override
    public void editar(SegundaChamadaAtividadeAvaliativa obj) {
        if (obj != null) {
            segundaChamadaCadastro = new FrameSegundaChamadaCadastro(servico, protocoloServico, alunoServico, coordenadorServico);
            atribuirSelecionado(obj);
            segundaChamadaCadastro.setVisible(true);
            System.out.println("Chegou no editar!!");
        } else {
            JOptionPane.showMessageDialog(segundaChamadaCadastro, "Selecione uma segunda chamada!");
        }
    }

    /**
     *
     * @param obj
     */
    @Override
    public void remover(SegundaChamadaAtividadeAvaliativa obj) {
        try {
            if (obj != null) {
                int opc = JOptionPane.showConfirmDialog(segundaChamadaCadastro,
                        "Deseja excluir a segunda chamada Número " + obj.getProtocolo().getNumero()+ "?",
                        "Remover segunda chamada",
                        JOptionPane.YES_NO_OPTION);
                if (opc == JOptionPane.YES_OPTION) {
                    servico.delete(obj);
                }
            } else {
                JOptionPane.showMessageDialog(segundaChamadaCadastro, "Selecione uma segunda chamada!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(segundaChamadaCadastro, ex.getMessage());
        }
    }

    /**
     *
     * @return
     */
    @Override
    public List<SegundaChamadaAtividadeAvaliativa> carregarLista() {
        try {
            return servico.getAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(segundaChamadaCadastro, ex.getMessage());
        }
        return null;
    }

    /**
     *
     * @param obj
     */
    @Override
    public void atribuirSelecionado(SegundaChamadaAtividadeAvaliativa obj) {
        segundaChamadaCadastro.setSegundaChamada(obj);
        segundaChamadaCadastro.setProtocolo(obj.getProtocolo());
        
        segundaChamadaCadastro.getTxfLocalProva().setText(obj.getLocalProva());
        segundaChamadaCadastro.getTxfMotivoProva().setText(obj.getMotivoProva());
        segundaChamadaCadastro.getCbTurno().setSelectedIndex(obj.getTurno().ordinal());
        segundaChamadaCadastro.getTxfDataProva().setText(obj.getDataAvaliacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        segundaChamadaCadastro.getTxfProfessorAplicadorProva().setText(obj.getProfessorAplicadorProva());
        segundaChamadaCadastro.getTxaJustificativaProfessor().setText(obj.getJustificativaProfessor());
        
        segundaChamadaCadastro.getTxfNumeroProtocolo().setText(obj.getProtocolo().getNumero());
        segundaChamadaCadastro.getCbAlunoProtocolo().setSelectedItem(obj.getProtocolo().getAluno());
        segundaChamadaCadastro.getCbCoordenadorProtocolo().setSelectedItem(obj.getProtocolo().getCoordenador());
    }
    
    @Override
    public String ObtemTipoCadastro() {
        return "Cadastro de Segunda Chamada";
    }

}
