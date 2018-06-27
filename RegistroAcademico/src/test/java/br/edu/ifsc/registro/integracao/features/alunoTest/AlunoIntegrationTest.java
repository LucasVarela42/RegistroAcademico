/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.integracao.features.alunoTest;

import br.edu.ifsc.registro.dominio.features.aluno.Aluno;
import br.edu.ifsc.registro.dominio.features.aluno.IAlunoRepositorio;
import br.edu.ifsc.registro.dominio.features.curso.Curso;
import br.edu.ifsc.registro.dominio.features.curso.ICursoRepositorio;
import br.edu.ifsc.registro.infraestrutura.data.features.aluno.AlunoRepositorio;
import br.edu.ifsc.registro.infraestrutura.data.features.curso.CursoRepositorio;
import br.edu.ifsc.registro.servico.features.aluno.AlunoServico;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Lucas
 */
public class AlunoIntegrationTest {

    private Aluno aluno;
    private Curso c;
    private AlunoServico servico;
    private IAlunoRepositorio repositorio;
    private ICursoRepositorio cursoRepositorio;

    @Before
    public void setUp() {
        aluno = new Aluno();
        c = new Curso();
        repositorio = new AlunoRepositorio();
        cursoRepositorio = new CursoRepositorio();
        servico = new AlunoServico(repositorio, cursoRepositorio);
    }

    @Test
    public void Integration_Aluno_AdicionarCorretamente_DevePassar() {
        //Arrange
        aluno.setEmail("lucas@lucas");
        aluno.setNome("Lucas");
        aluno.setTelefone("987654321");
        c.setId(3);
        aluno.setCurso(c);
        //Action
        Aluno resultado;
        try {
            resultado = servico.add(aluno);
            //Verify
            assertThat(resultado).isNotNull();
            assertThat(resultado.getNome()).isEqualTo(aluno.getNome());
            assertThat(resultado.getCurso().getId()).isEqualTo(c.getId());
        } catch (Exception ex) {
            assertThat(ex).doesNotThrowAnyException();
        }
    }

    @Test
    public void Integration_Aluno_AdicionarInvalido_DeveFalhar() {
        //Arrange
        aluno.setNome("Lucas");
        aluno.setTelefone("987654321");
        c.setId(1);
        aluno.setCurso(c);
        //Action
        Aluno resultado;
        try {
            resultado = servico.add(aluno);

        } catch (Exception ex) {
            //Verify
            assertThat(ex).hasMessageContaining("O email não pode ser vazio.");
        }
    }

    @Test
    public void Integration_Aluno_AtualizarCorretamente_DevePassar() {
        //Arrange
        aluno.setId(1);
        aluno.setEmail("lucas@lucas");
        aluno.setNome("Lucas Varela");
        aluno.setTelefone("987654321");
        c.setId(1);
        aluno.setCurso(c);
        //Action
        Aluno resultado;
        try {
            resultado = servico.update(aluno);
            //Verify
            assertThat(resultado).isNotNull();
            assertThat(resultado.getNome()).isEqualTo(aluno.getNome());
        } catch (Exception ex) {
            assertThat(ex).doesNotThrowAnyException();
        }
    }

    @Test
    public void Integration_Aluno_AtualizarInvalido_DeveFalhar() {
        aluno.setId(1);
        aluno.setEmail("lucas@lucas");
        aluno.setTelefone("987654321");
        c.setId(1);
        aluno.setCurso(c);
        //Action
        Aluno resultado;
        try {
            resultado = servico.update(aluno);

        } catch (Exception ex) {
            //Verify
            assertThat(ex).hasMessageContaining("O nome não pode ser vazio.");
        }
    }

    @Test
    public void Integration_Aluno_BuscarPorId_DevePassar() {
        //Arrange
        Aluno resultado;
        try {
            resultado = servico.get(1);
            //Verify
            assertThat(resultado).isNotNull();
        } catch (Exception ex) {
            assertThat(ex).doesNotThrowAnyException();
        }
    }

    @Test
    public void Integration_Aluno_BuscarTodos_DevePassar() {
        //Arrange
        List<Aluno> alunosRecebidos;
        try {
            alunosRecebidos = servico.getAll();
            //Verify
            assertThat(alunosRecebidos).isNotNull();
        } catch (Exception ex) {
            assertThat(ex).doesNotThrowAnyException();
        }
    }

    @Test
    public void Integration_Aluno_ExcluirCorretamente_DevePassar() {
        //Arrange
        aluno.setId(1);
        //Action
        Aluno resultado;
        try {
            servico.delete(aluno);
            //Verify
            resultado = servico.get(1);
            assertThat(resultado).isNull();
        } catch (Exception ex) {
            assertThat(ex).doesNotThrowAnyException();
        }
    }
}
