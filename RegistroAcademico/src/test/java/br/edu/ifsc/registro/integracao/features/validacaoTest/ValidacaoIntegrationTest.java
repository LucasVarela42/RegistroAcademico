/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.integracao.features.validacaoTest;

import br.edu.ifsc.registro.dominio.features.protocolo.IProtocoloRepositorio;
import br.edu.ifsc.registro.dominio.features.protocolo.Protocolo;
import br.edu.ifsc.registro.dominio.features.validacao.IValidacaoRepositorio;
import br.edu.ifsc.registro.dominio.features.validacao.TipoValidacao;
import br.edu.ifsc.registro.dominio.features.validacao.Validacao;
import br.edu.ifsc.registro.infraestrutura.data.features.protocolo.ProtocoloRepositorio;
import br.edu.ifsc.registro.infraestrutura.data.features.validacao.ValidacaoRepositorio;
import br.edu.ifsc.registro.servico.features.validacao.ValidacaoServico;
import java.time.LocalDate;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Lucas
 */
public class ValidacaoIntegrationTest {

    private Validacao validacao;
    private Protocolo p;
    private ValidacaoServico servico;
    private IValidacaoRepositorio repositorio;
    private IProtocoloRepositorio protocoloRepositorio;

    @Before
    public void setUp() {
        validacao = new Validacao();
        p = new Protocolo();

        repositorio = new ValidacaoRepositorio();
        protocoloRepositorio = new ProtocoloRepositorio();
        servico = new ValidacaoServico(repositorio, protocoloRepositorio);
    }

    @Test
    public void Integration_Validacao_AdicionarCorretamente_DevePassar() {
        //Arrange
        validacao.setNota(10);
        validacao.setObservacao("testestsetsetseste");
        validacao.setDeferido(false);
        validacao.setTipoValidacao(TipoValidacao.RECONHECIMENTO_DE_ESTUDOS_NO_IFSC);
        p.setId(1);
        validacao.setProtocolo(p);
        //Action
        Validacao resultado;
        try {
            resultado = servico.add(validacao);
            //Verify
            assertThat(resultado).isNotNull();
            assertThat(resultado.getNota()).isEqualTo(validacao.getNota());
            assertThat(resultado.getProtocolo().getId()).isEqualTo(p.getId());
            assertThat(resultado.getObservacao()).isEqualTo(validacao.getObservacao());
        } catch (Exception ex) {
            assertThat(ex).doesNotThrowAnyException();
        }
    }

    @Test
    public void Integration_Validacao_AdicionarInvalido_DeveFalhar() {
        //Arrange
        validacao.setNota(-10);
        validacao.setObservacao("testestsetsetseste");
        validacao.setTipoValidacao(TipoValidacao.RECONHECIMENTO_DE_ESTUDOS_NO_IFSC);
        p.setId(1);
        validacao.setProtocolo(p);

        //Action
        Validacao resultado;
        try {
            resultado = servico.add(validacao);

        } catch (Exception ex) {
            //Verify
            assertThat(ex).hasMessageContaining("A nota da validação não pode ser menor que zero.");
        }
    }

    @Test
    public void Integration_Validacao_AtualizarCorretamente_DevePassar() {
        //Arrange
        validacao.setId(1);
        validacao.setNota(10);
        validacao.setDeferido(true);
        validacao.setObservacao("É um excelente aluno!");
        validacao.setTipoValidacao(TipoValidacao.RECONHECIMENTO_DE_ESTUDOS_NO_IFSC);
        p.setId(1);
        validacao.setProtocolo(p);
        //Action
        Validacao resultado;
        try {
            resultado = servico.update(validacao);
            //Verify
            assertThat(resultado).isNotNull();
            assertThat(resultado.getObservacao()).isEqualTo(validacao.getObservacao());
        } catch (Exception ex) {
            assertThat(ex).doesNotThrowAnyException();
        }
    }

    @Test
    public void Integration_Validacao_AtualizarInvalido_DeveFalhar() {
        //Arrange
        validacao.setId(1);
        validacao.setNota(10);
        validacao.setTipoValidacao(TipoValidacao.RECONHECIMENTO_DE_ESTUDOS_NO_IFSC);
        p.setId(1);
        validacao.setProtocolo(p);
        //Action
        Validacao resultado;
        try {
            resultado = servico.update(validacao);

        } catch (Exception ex) {
            //Verify
            assertThat(ex).hasMessageContaining("A observação da validação não pode ser vazia.");
        }
    }

    @Test
    public void Integration_Validacao_BuscarPorId_DevePassar() {
        //Arrange
        Validacao resultado;
        try {
            resultado = servico.get(1);
            //Verify
            assertThat(resultado).isNotNull();
        } catch (Exception ex) {
            assertThat(ex).doesNotThrowAnyException();
        }
    }

    @Test
    public void Integration_Validacao_BuscarTodos_DevePassar() {
        //Arrange
        List<Validacao> validacaosRecebidos;
        try {
            validacaosRecebidos = servico.getAll();
            //Verify
            assertThat(validacaosRecebidos).isNotNull();
        } catch (Exception ex) {
            assertThat(ex).doesNotThrowAnyException();
        }
    }

    @Test
    public void Integration_Validacao_ExcluirCorretamente_DevePassar() {
        //Arrange
        validacao.setId(1);
        //Action
        Validacao resultado;
        try {
            servico.delete(validacao);
            //Verify
            resultado = servico.get(1);
            assertThat(resultado).isNull();
        } catch (Exception ex) {
            assertThat(ex).doesNotThrowAnyException();
        }
    }
}
