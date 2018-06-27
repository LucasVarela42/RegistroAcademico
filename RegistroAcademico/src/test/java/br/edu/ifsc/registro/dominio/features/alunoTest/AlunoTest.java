/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.dominio.features.alunoTest;

import br.edu.ifsc.registro.dominio.features.aluno.Aluno;
import br.edu.ifsc.registro.dominio.features.curso.Curso;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Lucas
 */
public class AlunoTest  {

    private Aluno aluno;

    @Before
    public void setUp() {
        aluno = new Aluno();
    }

    @Test
    public void dominio_coordenador_validacao_devePassar() {
        //Organizacao
        aluno.setId(1);
        aluno.setEmail("coordenador@teste");
        aluno.setNome("Teste");
        aluno.setTelefone("123456789");
        aluno.setCurso(new Curso());
        //Acao
        try {
            aluno.validar();
        } catch (Exception ex) {
            assertThat(ex).doesNotThrowAnyException();
        }
    }

    @Test
    public void dominio_coordenador_validacaoCursoNull_deveFalhar() {
        //Organizacao
        aluno.setId(1);
        aluno.setEmail("coordenador@teste");
        aluno.setNome("Teste");
        aluno.setTelefone("123456789");
        aluno.setCurso(null);
        //Acao
        try {
            aluno.validar();
        } catch (Exception ex) {
            assertThat(ex).hasMessageContaining("O aluno deve ser vinculado a um curso.");
        }

    }
    
    @Test
    public void dominio_coordenador_validacaoNomeNull_deveFalhar() {
        //Organizacao
        aluno.setId(1);
        aluno.setEmail("coordenador@teste");
        aluno.setNome("");
        aluno.setTelefone("123456789");
        aluno.setCurso(new Curso());
        //Acao
        try {
            aluno.validar();
        } catch (Exception ex) {
            assertThat(ex).hasMessageContaining("O nome não pode ser vazio.");
        }

    }
    
    @Test
    public void dominio_coordenador_validacaoTelefoneNull_deveFalhar() {
        //Organizacao
        aluno.setId(1);
        aluno.setEmail("coordenador@teste");
        aluno.setNome("teste");
        aluno.setTelefone("");
        aluno.setCurso(new Curso());
        //Acao
        try {
            aluno.validar();
        } catch (Exception ex) {
            assertThat(ex).hasMessageContaining("O telefone não pode ser vazio.");
        }

    }
    
    
     @Test
    public void dominio_coordenador_validacaoEmailNull_deveFalhar() {
        //Organizacao
        aluno.setId(1);
        aluno.setEmail("");
        aluno.setNome("teste");
        aluno.setTelefone("123456789");
        aluno.setCurso(new Curso());
        //Acao
        try {
            aluno.validar();
        } catch (Exception ex) {
            assertThat(ex).hasMessageContaining("O email não pode ser vazio.");
        }

    }
}
