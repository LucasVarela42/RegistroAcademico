/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.integracao.features.segundaChamadaTest;

import br.edu.ifsc.registro.dominio.features.protocolo.IProtocoloRepositorio;
import br.edu.ifsc.registro.dominio.features.protocolo.Protocolo;
import br.edu.ifsc.registro.dominio.features.segundaChamada.ISegundaChamadaRepositorio;
import br.edu.ifsc.registro.dominio.features.segundaChamada.SegundaChamadaAtividadeAvaliativa;
import br.edu.ifsc.registro.dominio.features.segundaChamada.TurnoEnum;
import br.edu.ifsc.registro.infraestrutura.data.features.protocolo.ProtocoloRepositorio;
import br.edu.ifsc.registro.infraestrutura.data.features.segundaChamada.SegundaChamadaRepositorio;
import br.edu.ifsc.registro.servico.features.segundaChamada.SegundaChamadaServico;
import java.time.LocalDate;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Lucas
 */
public class SegundaChamadaIntegrationTest {

    private SegundaChamadaAtividadeAvaliativa segundaChamada;
    private Protocolo p;
    private SegundaChamadaServico servico;
    private ISegundaChamadaRepositorio repositorio;
    private IProtocoloRepositorio protocoloRepositorio;

    @Before
    public void setUp() {
        segundaChamada = new SegundaChamadaAtividadeAvaliativa();
        p = new Protocolo();

        repositorio = new SegundaChamadaRepositorio();
        protocoloRepositorio = new ProtocoloRepositorio();
        servico = new SegundaChamadaServico(repositorio, protocoloRepositorio);
    }

    @Test
    public void Integration_SegundaChamada_AdicionarCorretamente_DevePassar() {
        //Arrange
        segundaChamada.setDataAvaliacao(LocalDate.now().plusDays(10));
        segundaChamada.setJustificativaProfessor("Justificativa");
        segundaChamada.setLocalProva("Câmpus Lages");
        segundaChamada.setMotivoProva("Têm condições");
        segundaChamada.setProfessorAplicadorProva("Ailton Durigon");
        segundaChamada.setTurno(TurnoEnum.NOTURNO);
        p.setId(1);
        segundaChamada.setProtocolo(p);
        //Action
        SegundaChamadaAtividadeAvaliativa resultado;
        try {
            resultado = servico.add(segundaChamada);
            //Verify
            assertThat(resultado).isNotNull();
            assertThat(resultado.getLocalProva()).isEqualTo(segundaChamada.getLocalProva());
            assertThat(resultado.getProtocolo().getId()).isEqualTo(p.getId());
            assertThat(resultado.getTurno()).isEqualTo(segundaChamada.getTurno());
        } catch (Exception ex) {
            assertThat(ex).doesNotThrowAnyException();
        }
    }

    @Test
    public void Integration_SegundaChamada_AdicionarInvalido_DeveFalhar() {
        //Arrange
        segundaChamada.setDataAvaliacao(LocalDate.now().plusDays(-10));
        segundaChamada.setJustificativaProfessor("Justificativa");
        segundaChamada.setLocalProva("Câmpus Lages");
        segundaChamada.setMotivoProva("Têm condições");
        segundaChamada.setProfessorAplicadorProva("Ailton Durigon");
        segundaChamada.setTurno(TurnoEnum.NOTURNO);
        p.setId(1);
        segundaChamada.setProtocolo(p);
        //Action
        SegundaChamadaAtividadeAvaliativa resultado;
        try {
            resultado = servico.add(segundaChamada);

        } catch (Exception ex) {
            //Verify
            assertThat(ex).hasMessageContaining("A data de avaliação não pode ser menor que a atual.");
        }
    }

    @Test
    public void Integration_SegundaChamada_AtualizarCorretamente_DevePassar() {
        //Arrange
        segundaChamada.setId(1);
        segundaChamada.setDataAvaliacao(LocalDate.now().plusDays(10));
        segundaChamada.setJustificativaProfessor("Justificativa");
        segundaChamada.setLocalProva("Câmpus Lages");
        segundaChamada.setMotivoProva("Possui experiencia na area");
        segundaChamada.setProfessorAplicadorProva("Ailton Durigon");
        segundaChamada.setTurno(TurnoEnum.NOTURNO);
        p.setId(1);
        segundaChamada.setProtocolo(p);
        //Action
        SegundaChamadaAtividadeAvaliativa resultado;
        try {
            resultado = servico.update(segundaChamada);
            //Verify
            assertThat(resultado).isNotNull();
            assertThat(resultado.getMotivoProva()).isEqualTo(segundaChamada.getMotivoProva());
        } catch (Exception ex) {
            assertThat(ex).doesNotThrowAnyException();
        }
    }

    @Test
    public void Integration_SegundaChamada_AtualizarInvalido_DeveFalhar() {
        //Arrange
        segundaChamada.setId(1);
        segundaChamada.setDataAvaliacao(LocalDate.now().plusDays(10));
        segundaChamada.setJustificativaProfessor("Justificativa");
        segundaChamada.setLocalProva("Câmpus Lages");
        segundaChamada.setProfessorAplicadorProva("Ailton Durigon");
        segundaChamada.setTurno(TurnoEnum.NOTURNO);
        p.setId(1);
        segundaChamada.setProtocolo(p);
        //Action
        SegundaChamadaAtividadeAvaliativa resultado;
        try {
            resultado = servico.update(segundaChamada);

        } catch (Exception ex) {
            //Verify
            assertThat(ex).hasMessageContaining("O motivo da prova não pode ser vazio.");
        }
    }

    @Test
    public void Integration_SegundaChamada_BuscarPorId_DevePassar() {
        //Arrange
        SegundaChamadaAtividadeAvaliativa resultado;
        try {
            resultado = servico.get(1);
            //Verify
            assertThat(resultado).isNotNull();
        } catch (Exception ex) {
            assertThat(ex).doesNotThrowAnyException();
        }
    }

    @Test
    public void Integration_SegundaChamada_BuscarTodos_DevePassar() {
        //Arrange
        List<SegundaChamadaAtividadeAvaliativa> segundaChamadasRecebidos;
        try {
            segundaChamadasRecebidos = servico.getAll();
            //Verify
            assertThat(segundaChamadasRecebidos).isNotNull();
        } catch (Exception ex) {
            assertThat(ex).doesNotThrowAnyException();
        }
    }

    @Test
    public void Integration_SegundaChamada_ExcluirCorretamente_DevePassar() {
        //Arrange
        segundaChamada.setId(1);
        //Action
        SegundaChamadaAtividadeAvaliativa resultado;
        try {
            servico.delete(segundaChamada);
            //Verify
            resultado = servico.get(1);
            assertThat(resultado).isNull();
        } catch (Exception ex) {
            assertThat(ex).doesNotThrowAnyException();
        }
    }
}
