/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.dominio.features.protocoloTest;

import br.edu.ifsc.registro.dominio.features.aluno.Aluno;
import br.edu.ifsc.registro.dominio.features.coordenador.Coordenador;
import br.edu.ifsc.registro.dominio.features.protocolo.Protocolo;
import br.edu.ifsc.registro.dominio.features.protocolo.TipoProtocolo;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

/**
 *
 * @author Aluno
 */
public class ProtocoloTest {

    private Protocolo protocolo;

    @Before
    public void setUp() {
        protocolo = new Protocolo();
    }

    @Test
    public void dominio_protocolo_validacaoReconhecimentoSaberes_devePassar() {
        //Organização
        protocolo.setId(1);
        protocolo.setNumero("123654789");
        protocolo.setTipoProtocolo(TipoProtocolo.RECONHECIMENTO_DE_SABERES);
        protocolo.setDataCadastro(LocalDate.now());
        protocolo.setAluno(new Aluno());
        protocolo.setCoordenador(new Coordenador());
        try {
            //Ação
            protocolo.validar();
        } catch (Exception ex) {
            //Verificação
            assertThat(ex).doesNotThrowAnyException();
        }
    }

    @Test
    public void dominio_protocolo_validacaoValidacao_devePassar() {
        //Organização
        protocolo.setId(1);
        protocolo.setNumero("123654789");
        protocolo.setTipoProtocolo(TipoProtocolo.VALIDACAO);
        protocolo.setDataCadastro(LocalDate.now());
        protocolo.setAluno(new Aluno());
        protocolo.setCoordenador(new Coordenador());
        try {
            //Ação
            protocolo.validar();
        } catch (Exception ex) {
            //Verificação
            assertThat(ex).doesNotThrowAnyException();
        }
    }

    @Test
    public void dominio_protocolo_validacaoNumeroVazio_deveFalhar() {
        //Organização
        protocolo.setId(1);
        protocolo.setNumero("");
        protocolo.setTipoProtocolo(TipoProtocolo.VALIDACAO);
        protocolo.setDataCadastro(LocalDate.now());
        protocolo.setAluno(new Aluno());
        protocolo.setCoordenador(new Coordenador());

        try {
            //Ação
            protocolo.validar();
        } catch (Exception ex) {
            //Verificação
            assertThat(ex).hasMessageContaining("O numero do protocolo não pode ser vazio.");
        }
    }

    @Test
    public void dominio_protocolo_validacaoTipoProtocoloVazio_deveFalhar() {
        //Organização
        protocolo.setId(1);
        protocolo.setNumero("6547987321");
        protocolo.setTipoProtocolo(null);
        protocolo.setDataCadastro(LocalDate.now());
        protocolo.setAluno(new Aluno());
        protocolo.setCoordenador(new Coordenador());

        try {
            //Ação
            protocolo.validar();
        } catch (Exception ex) {
            //Verificação
            assertThat(ex).hasMessageContaining("O tipo do protocolo não pode ser vazio.");
        }
    }
    
    @Test
    public void dominio_protocolo_validacaoDataCadastroInvalido_deveFalhar() {
        //Organização
        protocolo.setId(1);
        protocolo.setNumero("654987321");
        protocolo.setTipoProtocolo(TipoProtocolo.VALIDACAO);
        protocolo.setDataCadastro(LocalDate.now().plusDays(1));
        protocolo.setAluno(new Aluno());
        protocolo.setCoordenador(new Coordenador());

        try {
            //Ação
            protocolo.validar();
        } catch (Exception ex) {
            //Verificação
            assertThat(ex).hasMessageContaining("A data de cadastro não pode ser maior que a atual.");
        }
    }
    
    @Test
    public void dominio_protocolo_validacaoAlunoInvalido_deveFalhar() {
        //Organização
        protocolo.setId(1);
        protocolo.setNumero("654987321");
        protocolo.setTipoProtocolo(TipoProtocolo.VALIDACAO);
        protocolo.setDataCadastro(LocalDate.now());
        protocolo.setAluno(null);
        protocolo.setCoordenador(new Coordenador());

        try {
            //Ação
            protocolo.validar();
        } catch (Exception ex) {
            //Verificação
            assertThat(ex).hasMessageContaining("O protocolo deve ser vinculado a um aluno.");
        }
    }
    
    @Test
    public void dominio_protocolo_validacaoCoordenadorInvalido_deveFalhar() {
        //Organização
        protocolo.setId(1);
        protocolo.setNumero("654987321");
        protocolo.setTipoProtocolo(TipoProtocolo.VALIDACAO);
        protocolo.setDataCadastro(LocalDate.now());
        protocolo.setAluno(new Aluno());
        protocolo.setCoordenador(null);

        try {
            //Ação
            protocolo.validar();
        } catch (Exception ex) {
            //Verificação
            assertThat(ex).hasMessageContaining("O protocolo deve ser vinculado a um coordenador.");
        }
    }
   
}
