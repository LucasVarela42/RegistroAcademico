/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.dominio.features.segundaChamadaTest;

import br.edu.ifsc.registro.dominio.features.protocolo.Protocolo;
import br.edu.ifsc.registro.dominio.features.segundaChamada.SegundaChamadaAtividadeAvaliativa;
import br.edu.ifsc.registro.dominio.features.segundaChamada.TurnoEnum;
import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Aluno
 */
public class SegundaChamadaTest {

    private SegundaChamadaAtividadeAvaliativa scaa;

    @Before
    public void setUp() {
        scaa = new SegundaChamadaAtividadeAvaliativa();
    }

    @Test
    public void dominio_segundaChamadaAtividadeAvaliativa_validacao_devePassar() {
        //Organização
        scaa.setDataAvaliacao(LocalDate.now().plusDays(10));
        scaa.setId(1);
        scaa.setJustificativaProfessor("Justificativa");
        scaa.setLocalProva("Câmpus Lages");
        scaa.setMotivoProva("Têm condições");
        scaa.setProfessorAplicadorProva("Ailton Durigon");
        scaa.setProtocolo(new Protocolo());
        scaa.setTurno(TurnoEnum.NOTURNO);

        //Ação
        try {
            scaa.validar();
        } catch (Exception ex) {
            assertThat(ex).doesNotThrowAnyException();
        }
    }

    @Test
    public void dominio_segundaChamadaAtividadeAvaliativa_validacaoDataErrada_deveFalhar() {
        //Organização
        scaa.setDataAvaliacao(LocalDate.now().plusDays(-10));
        scaa.setId(1);
        scaa.setJustificativaProfessor("Justificativa");
        scaa.setLocalProva("Câmpus Lages");
        scaa.setMotivoProva("Têm condições");
        scaa.setProfessorAplicadorProva("Ailton Durigon");
        scaa.setProtocolo(new Protocolo());
        scaa.setTurno(TurnoEnum.NOTURNO);

        //Ação
        try {
            scaa.validar();
        } catch (Exception ex) {
            assertThat(ex).hasMessageContaining("A data de avaliação não pode ser menor que a atual.");
        }
    }

    @Test
    public void dominio_segundaChamadaAtividadeAvaliativa_validacaoIdZero_deveFalhar() {
        //Organização
        scaa.setDataAvaliacao(LocalDate.now().plusDays(-10));
        scaa.setId(0);
        scaa.setJustificativaProfessor("Justificativa");
        scaa.setLocalProva("Câmpus Lages");
        scaa.setMotivoProva("Têm condições");
        scaa.setProfessorAplicadorProva("Ailton Durigon");
        scaa.setProtocolo(new Protocolo());
        scaa.setTurno(TurnoEnum.NOTURNO);

        //Ação
        try {
            scaa.validar();
        } catch (Exception ex) {
            assertThat(ex).hasMessageContaining("Id indefinido.");
        }
    }

    @Test
    public void dominio_segundaChamadaAtividadeAvaliativa_validacaoJustificativaVazia_deveFalhar() {
        //Organização
        scaa.setDataAvaliacao(LocalDate.now().plusDays(10));
        scaa.setId(1);
        scaa.setJustificativaProfessor("");
        scaa.setLocalProva("Câmpus Lages");
        scaa.setMotivoProva("Têm condições");
        scaa.setProfessorAplicadorProva("Ailton Durigon");
        scaa.setProtocolo(new Protocolo());
        scaa.setTurno(TurnoEnum.NOTURNO);

        //Ação
        try {
            scaa.validar();
        } catch (Exception ex) {
            assertThat(ex).hasMessageContaining("A justificativa do professor não pode ser vazia.");
        }
    }
}
