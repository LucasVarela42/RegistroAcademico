/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.dominio.features.validacaoTest;

import br.edu.ifsc.registro.dominio.features.protocolo.Protocolo;
import br.edu.ifsc.registro.dominio.features.validacao.TipoValidacao;
import br.edu.ifsc.registro.dominio.features.validacao.Validacao;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

/**
 *
 * @author Aluno
 */
public class ValidacaoTest {

    private Validacao validacao;

    @Before
    public void setUp() {
        validacao = new Validacao();
    }

    @Test
    public void dominio_validacao_validar_devePassar() {
        //Organização
        validacao.setId(1);
        validacao.setNota(10);
        validacao.setObservacao("testestsetsetseste");
        validacao.setTipoValidacao(TipoValidacao.RECONHECIMENTO_DE_ESTUDOS_NO_IFSC);
        validacao.setProtocolo(new Protocolo());
        try {
            //Ação
            validacao.validar();
        } catch (Exception ex) {
            //Verificação
            assertThat(ex).doesNotThrowAnyException();
        }
    }
    
    @Test
    public void dominio_validacao_validacaoNotaMenorQueZero_deveFalhar() {
        //Organização
        validacao.setId(1);
        validacao.setNota(-10);
        validacao.setObservacao("testestsetsetseste");
        validacao.setTipoValidacao(TipoValidacao.RECONHECIMENTO_DE_ESTUDOS_NO_IFSC);
        validacao.setProtocolo(new Protocolo());

        try {
            //Ação
            validacao.validar();
        } catch (Exception ex) {
            //Verificação
            assertThat(ex).hasMessageContaining("A nota da validação não pode ser menor que zero.");
        }
    }

    @Test
    public void dominio_validacao_validacaoObservacaoVazia_deveFalhar() {
        //Organização
        validacao.setId(1);
        validacao.setNota(10);
        validacao.setObservacao("");
        validacao.setTipoValidacao(TipoValidacao.RECONHECIMENTO_DE_ESTUDOS_NO_IFSC);
        validacao.setProtocolo(new Protocolo());

        try {
            //Ação
            validacao.validar();
        } catch (Exception ex) {
            //Verificação
            assertThat(ex).hasMessageContaining("A observação da validação não pode ser vazia.");
        }
    }
    
    @Test
    public void dominio_validacao_validacaoTipoValidacaoVazio_devePassar() {
        //Organização
        validacao.setId(1);
        validacao.setNota(10);
        validacao.setObservacao("testestsetsetseste");
        validacao.setTipoValidacao(null);
        validacao.setProtocolo(new Protocolo());
        try {
            //Ação
            validacao.validar();
        } catch (Exception ex) {
            //Verificação
            assertThat(ex).hasMessageContaining("O tipo da validação não pode ser nula.");
        }
    }
    
    @Test
    public void dominio_validacao_validacaoProtocoloNulo_devePassar() {
        //Organização
        validacao.setId(1);
        validacao.setNota(10);
        validacao.setObservacao("testestsetsetseste");
        validacao.setTipoValidacao(TipoValidacao.RECONHECIMENTO_DE_ESTUDOS_NO_IFSC);
        validacao.setProtocolo(null);
        try {
            //Ação
            validacao.validar();
        } catch (Exception ex) {
            //Verificação
            assertThat(ex).hasMessageContaining("O protocolo da validação não pode ser nula.");
        }
    }

}
