/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.integracao.features.protocoloTest;

import br.edu.ifsc.registro.dominio.features.aluno.Aluno;
import br.edu.ifsc.registro.dominio.features.aluno.IAlunoRepositorio;
import br.edu.ifsc.registro.dominio.features.coordenador.Coordenador;
import br.edu.ifsc.registro.dominio.features.coordenador.ICoordenadorRepositorio;
import br.edu.ifsc.registro.dominio.features.protocolo.IProtocoloRepositorio;
import br.edu.ifsc.registro.dominio.features.protocolo.Protocolo;
import br.edu.ifsc.registro.dominio.features.protocolo.TipoProtocolo;
import br.edu.ifsc.registro.infraestrutura.data.features.aluno.AlunoRepositorio;
import br.edu.ifsc.registro.infraestrutura.data.features.coordenador.CoordenadorRepositorio;
import br.edu.ifsc.registro.infraestrutura.data.features.protocolo.ProtocoloRepositorio;
import br.edu.ifsc.registro.servico.features.protocolo.ProtocoloServico;
import java.time.LocalDate;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Lucas
 */
public class ProtocoloIntegrationTest {

    private Protocolo protocolo;
    private Coordenador c;
    private Aluno a;
    private ProtocoloServico servico;
    private IProtocoloRepositorio repositorio;
    private IAlunoRepositorio alunoRepositorio;
    private ICoordenadorRepositorio coordenadorRepositorio;

    @Before
    public void setUp() {
        protocolo = new Protocolo();
        a = new Aluno();
        c = new Coordenador();
        
        repositorio = new ProtocoloRepositorio();
        alunoRepositorio = new AlunoRepositorio();
        coordenadorRepositorio = new CoordenadorRepositorio();
        servico = new ProtocoloServico(repositorio, alunoRepositorio, coordenadorRepositorio);
    }

    @Test
    public void Integration_Protocolo_AdicionarCorretamente_DevePassar() {
        //Arrange
        protocolo.setNumero("987654321");
        protocolo.setTipoProtocolo(TipoProtocolo.VALIDACAO);
        protocolo.setDataCadastro(LocalDate.now());
        a.setId(5);
        protocolo.setAluno(a);
        c.setId(2);
        protocolo.setCoordenador(c);
        //Action
        Protocolo resultado;
        try {
            resultado = servico.add(protocolo);
            //Verify
            assertThat(resultado).isNotNull();
            assertThat(resultado.getNumero()).isEqualTo(protocolo.getNumero());
            assertThat(resultado.getAluno().getId()).isEqualTo(a.getId());
            assertThat(resultado.getCoordenador().getId()).isEqualTo(c.getId());
        } catch (Exception ex) {
            assertThat(ex).doesNotThrowAnyException();
        }
    }

    @Test
    public void Integration_Protocolo_AdicionarInvalido_DeveFalhar() {
        //Arrange
        protocolo.setTipoProtocolo(TipoProtocolo.RECONHECIMENTO_DE_SABERES);
        protocolo.setDataCadastro(LocalDate.now());
        a.setId(5);
        protocolo.setAluno(a);
        c.setId(2);
        protocolo.setCoordenador(c);
        //Action
        Protocolo resultado;
        try {
            resultado = servico.add(protocolo);

        } catch (Exception ex) {
            //Verify
            assertThat(ex).hasMessageContaining("O numero do protocolo não pode ser vazio.");
        }
    }

    @Test
    public void Integration_Protocolo_AtualizarCorretamente_DevePassar() {
        //Arrange
        protocolo.setId(1);
        protocolo.setNumero("5555555555");
        protocolo.setTipoProtocolo(TipoProtocolo.RECONHECIMENTO_DE_SABERES);
        protocolo.setDataCadastro(LocalDate.now());
        a.setId(5);
        protocolo.setAluno(a);
        c.setId(2);
        protocolo.setCoordenador(c);
        //Action
        Protocolo resultado;
        try {
            resultado = servico.update(protocolo);
            //Verify
            assertThat(resultado).isNotNull();
            assertThat(resultado.getNumero()).isEqualTo(protocolo.getNumero());
        } catch (Exception ex) {
            assertThat(ex).doesNotThrowAnyException();
        }
    }

    @Test
    public void Integration_Protocolo_AtualizarInvalido_DeveFalhar() {
        //Arrange
        protocolo.setId(1);
        protocolo.setNumero("5555555555");
        protocolo.setDataCadastro(LocalDate.now());
        a.setId(5);
        protocolo.setAluno(a);
        c.setId(2);
        protocolo.setCoordenador(c);
        //Action
        Protocolo resultado;
        try {
            resultado = servico.update(protocolo);

        } catch (Exception ex) {
            //Verify
            assertThat(ex).hasMessageContaining("O tipo do protocolo não pode ser vazio.");
        }
    }

    @Test
    public void Integration_Protocolo_BuscarPorId_DevePassar() {
        //Arrange
        Protocolo resultado;
        try {
            resultado = servico.get(1);
            //Verify
            assertThat(resultado).isNotNull();
        } catch (Exception ex) {
            assertThat(ex).doesNotThrowAnyException();
        }
    }

    @Test
    public void Integration_Protocolo_BuscarTodos_DevePassar() {
        //Arrange
        List<Protocolo> protocolosRecebidos;
        try {
            protocolosRecebidos = servico.getAll();
            //Verify
            assertThat(protocolosRecebidos).isNotNull();
        } catch (Exception ex) {
            assertThat(ex).doesNotThrowAnyException();
        }
    }

    @Test
    public void Integration_Protocolo_ExcluirCorretamente_DevePassar() {
        //Arrange
        protocolo.setId(1);
        //Action
        Protocolo resultado;
        try {
            servico.delete(protocolo);
            //Verify
            resultado = servico.get(1);
            assertThat(resultado).isNull();
        } catch (Exception ex) {
            assertThat(ex).doesNotThrowAnyException();
        }
    }
}
