/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.dominio.features.cursoTest;

import br.edu.ifsc.registro.dominio.features.curso.Curso;
import br.edu.ifsc.registro.dominio.features.curso.TipoCurso;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.assertj.core.api.Assertions.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Aluno
 */
public class CursoTest {

    private Curso curso;

    @Before
    public void setUp() {
        curso = new Curso();
    }

    @Test
    public void dominio_curso_validacao_devePassar() {
        //Organização
        curso.setNome("Ciencia Da Computacação");
        curso.setTipoCurso(TipoCurso.GRADUACAO);
        try {
            //Ação
            curso.validar();
        } catch (Exception ex) {
            //Verificação
            assertThat(ex).doesNotThrowAnyException();
        }
    }

    @Test
    public void dominio_curso_validacaoNomeVazio_deveFalhar() {
        //Organização
        curso.setNome("");
        curso.setTipoCurso(TipoCurso.TECNICO);

        try {
            //Ação
            curso.validar();
        } catch (Exception ex) {
            //Verificação
            assertThat(ex).hasMessageContaining("O nome do curso não pode ser vazio.");
        }
    }

    @Test
    public void dominio_curso_validacaoTipoCursoVazio_deveFalhar() {
        //Organização
        curso.setNome("teste");
        curso.setTipoCurso(null);

        try {
            //Ação
            curso.validar();
        } catch (Exception ex) {
            //Verificação
            assertThat(ex).hasMessageContaining("O tipo do curso não pode ser vazio.");
        }
    }

    @Test
    public void dominio_curso_validacaoNomeMaior50_deveFalhar() {
        //Organização
        curso.setNome("testegkajslbd jlbasdjflbsjdklhfvjisodmhvfipdhfvjipmsahdjfivmshdjivpfhsjidmfjsipmhgvjipmdhfguipmvshdjipfvhsjdiphfvispdhgvipsdhiopahraphsdipuvgbjpaisfdvbgjipmhgvipa");
        curso.setTipoCurso(TipoCurso.GRADUACAO);

        try {
            //Ação
            curso.validar();
        } catch (Exception ex) {
            //Verificação
            assertThat(ex).hasMessageContaining("O nome do curso não pode ter mais que 50 caracteres.");
        }
    }

}
