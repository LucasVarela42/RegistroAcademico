/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.dominio.features.coordenadorTest;

import br.edu.ifsc.registro.dominio.features.coordenador.Coordenador;
import br.edu.ifsc.registro.dominio.features.curso.Curso;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

/**
 *
 * @author Aluno
 */
public class CoordenadorTest {

    private Coordenador c;

    @Before
    public void setUp() {
        c = new Coordenador();
    }

    //O coordenador deve ter vinculado a um curso
    @Test
    public void dominio_coordenador_validacao_devePassar() {
        //Organizacao
        c.setEmail("coordenador@teste");
        c.setNome("Teste");
        c.setTelefone("123456789");
        c.setCursoCoordenacao(new Curso());
        //Acao
        try {
            c.validar();
        } catch (Exception ex) {
            assertThat(ex).doesNotThrowAnyException();
        }

    }

    @Test
    public void dominio_coordenador_validacaoCursoNull_deveFalhar() {
        //Organizacao
        c.setEmail("coordenador@teste");
        c.setNome("Teste");
        c.setTelefone("123456789");
        //c.setCursoCoordenacao(new Curso());
        //Acao
        try {
            c.validar();
        } catch (Exception ex) {
            assertThat(ex).hasMessageContaining("O coordenador deve ter vinculado a um curso.");
        }

    }
    
    @Test
    public void dominio_coordenador_validacaoNomeNull_deveFalhar() {
        //Organizacao
        c.setEmail("coordenador@teste");
        c.setNome("");
        c.setTelefone("123456789");
        //c.setCursoCoordenacao(new Curso());
        //Acao
        try {
            c.validar();
        } catch (Exception ex) {
            assertThat(ex).hasMessageContaining("O nome não pode ser vazio.");
        }

    }
    
    @Test
    public void dominio_coordenador_validacaoTelefoneNull_deveFalhar() {
        //Organizacao
        c.setEmail("coordenador@teste");
        c.setNome("teste");
        c.setTelefone("");
        //c.setCursoCoordenacao(new Curso());
        //Acao
        try {
            c.validar();
        } catch (Exception ex) {
            assertThat(ex).hasMessageContaining("O telefone não pode ser vazio.");
        }

    }
    
    
     @Test
    public void dominio_coordenador_validacaoEmailNull_deveFalhar() {
        //Organizacao
        c.setEmail("");
        c.setNome("teste");
        c.setTelefone("123456789");
        //c.setCursoCoordenacao(new Curso());
        //Acao
        try {
            c.validar();
        } catch (Exception ex) {
            assertThat(ex).hasMessageContaining("O email não pode ser vazio.");
        }

    }
}
