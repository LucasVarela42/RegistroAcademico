/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.integracao.features.cursoTest;

import br.edu.ifsc.registro.dominio.features.curso.Curso;
import br.edu.ifsc.registro.dominio.features.curso.ICursoRepositorio;
import br.edu.ifsc.registro.dominio.features.curso.TipoCurso;
import br.edu.ifsc.registro.infraestrutura.data.features.curso.CursoRepositorio;
import br.edu.ifsc.registro.servico.features.curso.CursoServico;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Lucas
 */
public class CursoIntegrationTest {

    private Curso curso;
    private CursoServico servico;
    private ICursoRepositorio repositorio;

    @Before
    public void setUp() {
        curso = new Curso();
        repositorio = new CursoRepositorio();
        servico = new CursoServico(repositorio);
    }

    @Test
    public void Integration_Curso_AdicionarCorretamente_DevePassar() {
        //Arrange
        curso.setNome("Ciência da Computação");
        curso.setTipoCurso(TipoCurso.GRADUACAO);
        //Action
        Curso resultado;
        try {
            resultado = servico.add(curso);
            //Verify
            assertThat(resultado).isNotNull();
            assertThat(resultado.getNome()).isEqualTo(curso.getNome());
            assertThat(resultado.getTipoCurso()).isEqualTo(curso.getTipoCurso());
        } catch (Exception ex) {
            assertThat(ex).doesNotThrowAnyException();
        }
    }

    @Test
    public void Integration_Curso_AdicionarInvalido_DeveFalhar() {
        //Arrange
        curso.setTipoCurso(TipoCurso.GRADUACAO);
        //Action
        Curso resultado;
        try {
            resultado = servico.add(curso);

        } catch (Exception ex) {
            //Verify
            assertThat(ex).hasMessageContaining("O nome do curso não pode ser vazio.");
        }
    }

    @Test
    public void Integration_Curso_AtualizarCorretamente_DevePassar() {
        //Arrange
        curso.setId(1);
        curso.setNome("Mecatrônica");
        curso.setTipoCurso(TipoCurso.TECNICO);
        //Action
        Curso resultado;
        try {
            resultado = servico.update(curso);
            //Verify
            assertThat(resultado).isNotNull();
            assertThat(resultado.getNome()).isEqualTo(curso.getNome());
            assertThat(resultado.getTipoCurso()).isEqualTo(curso.getTipoCurso());
        } catch (Exception ex) {
            assertThat(ex).doesNotThrowAnyException();
        }
    }

    @Test
    public void Integration_Curso_AtualizarInvalido_DeveFalhar() {
        //Arrange
        curso.setId(0);
        curso.setNome("Mecatrônica");
        curso.setTipoCurso(TipoCurso.TECNICO);
        //Action
        Curso resultado;
        try {
            resultado = servico.update(curso);

        } catch (Exception ex) {
            //Verify
            assertThat(ex).hasMessageContaining("Id indefinido.");
        }
    }

    @Test
    public void Integration_Curso_BuscarPorId_DevePassar() {
        //Arrange
        Curso resultado;
        try {
            resultado = servico.get(1);
            //Verify
            assertThat(resultado).isNotNull();
        } catch (Exception ex) {
            assertThat(ex).doesNotThrowAnyException();
        }
    }

    @Test
    public void Integration_Curso_BuscarTodos_DevePassar() {
        //Arrange
        List<Curso> cursosRecebidos;
        try {
            cursosRecebidos = servico.getAll();
            //Verify
            assertThat(cursosRecebidos).isNotNull();
        } catch (Exception ex) {
            assertThat(ex).doesNotThrowAnyException();
        }
    }

    @Test
    public void Integration_Curso_ExcluirCorretamente_DevePassar() {
        //Arrange
        curso.setId(1);
        //Action
        Curso resultado;
        try {
            servico.delete(curso);
            //Verify
            resultado = servico.get(1);
            assertThat(resultado).isNull();
        } catch (Exception ex) {
            assertThat(ex).doesNotThrowAnyException();
        }
    }
}
