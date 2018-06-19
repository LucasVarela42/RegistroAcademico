package br.edu.ifsc.registro.dominio.features.segundaChamada;

import br.edu.ifsc.registro.dominio.features.coordenador.Coordenador;
import br.edu.ifsc.registro.dominio.features.aluno.Aluno;

import br.edu.ifsc.registro.dominio.features.protocolo.Protocolo;
import java.time.LocalDateTime;

/**
 *
 * @author Edoardo Colares, Lucas Varela, Matheus de Medeiros
 */
public class SegundaChamadaAtividadeAvaliativa extends Protocolo{

    private String local;
    private String turno;
    private String motivoProva;
    private LocalDateTime dataAvaliacao;
    private String justificativaProfessor;
    private String professorAplicadorProva;

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

    @Override
    public void validar() throws Exception {
        super.validar(); //To change body of generated methods, choose Tools | Templates.
    }
    
  
}
