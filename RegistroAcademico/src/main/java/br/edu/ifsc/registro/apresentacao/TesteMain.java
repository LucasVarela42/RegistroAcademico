package br.edu.ifsc.registro.apresentacao;

import br.edu.ifsc.registro.dominio.features.aluno.Aluno;
import br.edu.ifsc.registro.dominio.features.coordenador.Coordenador;
import br.edu.ifsc.registro.dominio.features.curso.Curso;
import br.edu.ifsc.registro.dominio.features.curso.TipoCurso;
import br.edu.ifsc.registro.dominio.features.disciplina.Disciplina;

import br.edu.ifsc.registro.dominio.features.segundaChamada.SegundaChamadaAtividadeAvaliativa;
import br.edu.ifsc.registro.dominio.features.protocolo.TipoProtocolo;
import br.edu.ifsc.registro.dominio.features.validacao.TipoValidacao;
import br.edu.ifsc.registro.dominio.features.validacao.Validacao;
import java.time.LocalDateTime;

/**
 *
 * @author Edoardo Colares, Lucas Varela, Matheus de Medeiros
 */
public class TesteMain {

    public static void main(String[] args) {
        //Base
        Curso curso = new Curso();
        Disciplina disciplina = new Disciplina();
        Coordenador coordenador = new Coordenador();
        Aluno aluno = new Aluno();
        
        //Protocolos
        SegundaChamadaAtividadeAvaliativa scaa = new SegundaChamadaAtividadeAvaliativa();
        Validacao validacao = new Validacao();
        
        //Atribuições base
        curso.setId(0);
        curso.setNome("Ciência da Computação");
        curso.setTipoCurso(TipoCurso.GRADUACAO);
        
        disciplina.setId(0);
        disciplina.setNome("Laboratório de Programação");
        disciplina.setSigla("LDP");
        disciplina.setCargaHoraria(72);
        disciplina.setCurso(curso);
        
        coordenador.setId(0);
        coordenador.setNome("Coordenador");
        coordenador.setEmail("co@co.com");
        coordenador.setTelefone("(99)9999-9999");
        coordenador.setCursoCoordenacao(curso);
        
        
        aluno.setId(0);
        aluno.setNome("Ciclano");
        aluno.setEmail("ci@ci.com");
        aluno.setTelefone("(49)9999-8888");
        aluno.setCurso(curso);
        
        //Construindo protocolo - Reconhecimento de saberes
        scaa.setId(0);
        scaa.setNumero(123654789);
        scaa.setTipoProtocolo(TipoProtocolo.RECONHECIMENTO_DE_SABERES);
        
        scaa.setDataCadastro(LocalDateTime.now());
        scaa.setAluno(aluno);
        scaa.setCoordenador(coordenador);
        scaa.setProfessorAplicadorProva("João");
        scaa.setJustificativaProfessor("");
        
        scaa.setDataAvaliacao(LocalDateTime.now().plusDays(5));
        scaa.setLocal("IFSC Lages");
        scaa.setMotivoProva("Já tem experiencia na area");
        scaa.setTurno("Noturno");
        
        //Construindo protocolo - Validação pelo ifsc
        validacao.setId(0);
        validacao.setNumero(987456321);
        validacao.setTipoProtocolo(TipoProtocolo.VALIDACAO);
        
        validacao.setDataCadastro(LocalDateTime.now());
        validacao.setAluno(aluno);
        validacao.setCoordenador(coordenador);
        validacao.setTipoValidacao(TipoValidacao.RECONHECIMENTO_DE_ESTUDOS_NO_IFSC);
        
        validacao.setDeferido(true);
        validacao.setNota(6);
        validacao.setObservacao("Tem conhecimentos suficientes, porém deve frequentar a aula");
        
        //Construindo protocolo - Validação por outra instituição
        validacao.setId(2);
        validacao.setNumero(456289731);
        validacao.setTipoProtocolo(TipoProtocolo.VALIDACAO);
        
        validacao.setDataCadastro(LocalDateTime.now());
        validacao.setAluno(aluno);
        validacao.setCoordenador(coordenador);
        validacao.setTipoValidacao(TipoValidacao.RECONHECIMENTO_DE_ESTUDOS_EM_OUTRA_INSTITUICAO);
        
        validacao.setDeferido(true);
        validacao.setNota(9);
        validacao.setObservacao("");
        
    }
}
