package br.edu.ifsc.registro.apresentacao;

import br.edu.ifsc.registro.dominio.Aluno;
import br.edu.ifsc.registro.dominio.Coordenador;
import br.edu.ifsc.registro.dominio.Curso;
import br.edu.ifsc.registro.dominio.Disciplina;
import br.edu.ifsc.registro.dominio.Protocolo;
import br.edu.ifsc.registro.dominio.SegundaChamadaAtividadeAvaliativa;
import br.edu.ifsc.registro.dominio.Validacao;

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
        curso.setTipo("Graduação");
        
        disciplina.setId(0);
        disciplina.setNome("Laboratório de Programação");
        disciplina.setSigla("LDP");
        disciplina.setCargaHoraria(72);
        disciplina.setCurso(curso);
        
        coordenador.setId(0);
        coordenador.setNome("Coordenador");
        coordenador.setEmail("co@co.com");
        coordenador.setTelefone("(99)9999-9999");
        coordenador.setCoordenacao(curso);
        
        aluno.setId(0);
        aluno.setNome("Ciclano");
        aluno.setEmail("ci@ci.com");
        aluno.setTelefone("(49)9999-8888");
        aluno.setCurso(curso);
        
        
        
        
    }
}
