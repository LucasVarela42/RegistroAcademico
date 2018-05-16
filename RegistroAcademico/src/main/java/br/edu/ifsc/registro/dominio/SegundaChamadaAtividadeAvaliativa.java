package br.edu.ifsc.registro.dominio;

import java.time.LocalDateTime;

/**
 *
 * @author Edoardo Colares, Lucas Varela, Matheus de Medeiros
 */
public class SegundaChamadaAtividadeAvaliativa extends Protocolo{

    private String local;
    private String turno;
    private LocalDateTime dataPedido;
    private String motivoProva;
    private LocalDateTime dataAvaliacao;
    private String justificativaProfessor;
    private String professorAplicadorProva;
    private Aluno aluno;
    private Coordenador coordenador;

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getMotivoProva() {
        return motivoProva;
    }

    public void setMotivoProva(String motivoProva) {
        this.motivoProva = motivoProva;
    }

    public LocalDateTime getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(LocalDateTime dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public String getJustificativaProfessor() {
        return justificativaProfessor;
    }

    public void setJustificativaProfessor(String justificativaProfessor) {
        this.justificativaProfessor = justificativaProfessor;
    }

    public String getProfessorAplicadorProva() {
        return professorAplicadorProva;
    }

    public void setProfessorAplicadorProva(String professorAplicadorProva) {
        this.professorAplicadorProva = professorAplicadorProva;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Coordenador getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Coordenador coordenador) {
        this.coordenador = coordenador;
    }
    
    public void validar(){
        
    }

}
