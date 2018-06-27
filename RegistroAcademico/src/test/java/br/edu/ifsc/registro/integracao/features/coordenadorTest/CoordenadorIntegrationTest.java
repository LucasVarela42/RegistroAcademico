/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.integracao.features.coordenadorTest;

import br.edu.ifsc.registro.dominio.features.coordenador.Coordenador;
import br.edu.ifsc.registro.dominio.features.coordenador.ICoordenadorRepositorio;
import br.edu.ifsc.registro.dominio.features.curso.Curso;
import br.edu.ifsc.registro.dominio.features.curso.ICursoRepositorio;
import br.edu.ifsc.registro.infraestrutura.data.features.coordenador.CoordenadorRepositorio;
import br.edu.ifsc.registro.infraestrutura.data.features.curso.CursoRepositorio;
import br.edu.ifsc.registro.servico.features.coordenador.CoordenadorServico;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Lucas
 */
public class CoordenadorIntegrationTest {

    private Coordenador coordenador;
    private Curso c;
    private CoordenadorServico servico;
    private ICoordenadorRepositorio repositorio;
    private ICursoRepositorio cursoRepositorio;

    @Before
    public void setUp() {
        coordenador = new Coordenador();
        c = new Curso();
        repositorio = new CoordenadorRepositorio();
        cursoRepositorio = new CursoRepositorio();
        servico = new CoordenadorServico(repositorio, cursoRepositorio);
    }

    @Test
    public void Integration_Coordenador_AdicionarCorretamente_DevePassar() {
        //Arrange
        coordenador.setEmail("Juliano@Juliano");
        coordenador.setNome("Juliano");
        coordenador.setTelefone("987654321");
        c.setId(3);
        coordenador.setCursoCoordenacao(c);
        //Action
        Coordenador resultado;
        try {
            resultado = servico.add(coordenador);
            //Verify
            assertThat(resultado).isNotNull();
            assertThat(resultado.getNome()).isEqualTo(coordenador.getNome());
            assertThat(resultado.getCursoCoordenacao().getId()).isEqualTo(c.getId());
        } catch (Exception ex) {
            assertThat(ex).doesNotThrowAnyException();
        }
    }

    @Test
    public void Integration_Coordenador_AdicionarInvalido_DeveFalhar() {
        //Arrange
        coordenador.setNome("Juliano");
        coordenador.setTelefone("987654321");
        c.setId(3);
        coordenador.setCursoCoordenacao(c);
        //Action
        Coordenador resultado;
        try {
            resultado = servico.add(coordenador);

        } catch (Exception ex) {
            //Verify
            assertThat(ex).hasMessageContaining("O email não pode ser vazio.");
        }
    }

    @Test
    public void Integration_Coordenador_AtualizarCorretamente_DevePassar() {
        //Arrange
        coordenador.setId(1);
        coordenador.setEmail("lucas@lucas");
        coordenador.setNome("Joao Varela");
        coordenador.setTelefone("987654321");
        c.setId(3);
        coordenador.setCursoCoordenacao(c);
        //Action
        Coordenador resultado;
        try {
            resultado = servico.update(coordenador);
            //Verify
            assertThat(resultado).isNotNull();
            assertThat(resultado.getNome()).isEqualTo(coordenador.getNome());
        } catch (Exception ex) {
            assertThat(ex).doesNotThrowAnyException();
        }
    }

    @Test
    public void Integration_Coordenador_AtualizarInvalido_DeveFalhar() {
        coordenador.setId(1);
        coordenador.setEmail("lucas@lucas");
        coordenador.setTelefone("987654321");
        c.setId(3);
        coordenador.setCursoCoordenacao(c);
        //Action
        Coordenador resultado;
        try {
            resultado = servico.update(coordenador);

        } catch (Exception ex) {
            //Verify
            assertThat(ex).hasMessageContaining("O nome não pode ser vazio.");
        }
    }

    @Test
    public void Integration_Coordenador_BuscarPorId_DevePassar() {
        //Arrange
        Coordenador resultado;
        try {
            resultado = servico.get(1);
            //Verify
            assertThat(resultado).isNotNull();
        } catch (Exception ex) {
            assertThat(ex).doesNotThrowAnyException();
        }
    }

    @Test
    public void Integration_Coordenador_BuscarTodos_DevePassar() {
        //Arrange
        List<Coordenador> coordenadorsRecebidos;
        try {
            coordenadorsRecebidos = servico.getAll();
            //Verify
            assertThat(coordenadorsRecebidos).isNotNull();
        } catch (Exception ex) {
            assertThat(ex).doesNotThrowAnyException();
        }
    }

    @Test
    public void Integration_Coordenador_ExcluirCorretamente_DevePassar() {
        //Arrange
        coordenador.setId(1);
        //Action
        Coordenador resultado;
        try {
            servico.delete(coordenador);
            //Verify
            resultado = servico.get(1);
            assertThat(resultado).isNull();
        } catch (Exception ex) {
            assertThat(ex).doesNotThrowAnyException();
        }
    }
}
