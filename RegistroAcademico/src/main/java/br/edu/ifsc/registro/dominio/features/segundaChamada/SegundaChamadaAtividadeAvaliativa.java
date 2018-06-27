package br.edu.ifsc.registro.dominio.features.segundaChamada;

import br.edu.ifsc.registro.dominio.base.Entidade;
import br.edu.ifsc.registro.dominio.features.protocolo.Protocolo;
import java.time.LocalDate;

/**
 *
 * @author Edoardo Colares, Lucas Varela, Matheus de Medeiros
 */
public class SegundaChamadaAtividadeAvaliativa extends Entidade {

    private String localProva;
    private TurnoEnum turno;
    private String motivoProva;
    private LocalDate dataAvaliacao;
    private String justificativaProfessor;
    private String professorAplicadorProva;
    private Protocolo protocolo;

    /**
     *
     * @return
     */
    public String getLocalProva() {
        return localProva;
    }

    /**
     *
     * @param localProva
     */
    public void setLocalProva(String localProva) {
        this.localProva = localProva;
    }

    /**
     *
     * @return
     */
    public TurnoEnum getTurno() {
        return turno;
    }

    /**
     *
     * @param turno
     */
    public void setTurno(TurnoEnum turno) {
        this.turno = turno;
    }

    /**
     *
     * @return
     */
    public String getMotivoProva() {
        return motivoProva;
    }

    /**
     *
     * @param motivoProva
     */
    public void setMotivoProva(String motivoProva) {
        this.motivoProva = motivoProva;
    }

    /**
     *
     * @return
     */
    public LocalDate getDataAvaliacao() {
        return dataAvaliacao;
    }

    /**
     *
     * @param dataAvaliacao
     */
    public void setDataAvaliacao(LocalDate dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    /**
     *
     * @return
     */
    public String getJustificativaProfessor() {
        return justificativaProfessor;
    }

    /**
     *
     * @param justificativaProfessor
     */
    public void setJustificativaProfessor(String justificativaProfessor) {
        this.justificativaProfessor = justificativaProfessor;
    }

    /**
     *
     * @return
     */
    public String getProfessorAplicadorProva() {
        return professorAplicadorProva;
    }

    /**
     *
     * @param professorAplicadorProva
     */
    public void setProfessorAplicadorProva(String professorAplicadorProva) {
        this.professorAplicadorProva = professorAplicadorProva;
    }

    /**
     *
     * @return
     */
    public Protocolo getProtocolo() {
        return protocolo;
    }

    /**
     *
     * @param protocolo
     */
    public void setProtocolo(Protocolo protocolo) {
        this.protocolo = protocolo;
    }
    
    /**
     *
     * @throws Exception
     */
    @Override
    public void validar() throws Exception {
        super.validar();
        if (localProva == null || localProva.isEmpty()) {
            throw new Exception("O local da Prova da segunda chamada não pode ser vazia.");
        }
        if (turno == null) {
            throw new Exception("O turno do protocolo não pode ser nulo.");
        }
        if (motivoProva == null || motivoProva.isEmpty()) {
            throw new Exception("O motivo da prova não pode ser vazio.");
        }
        if (dataAvaliacao.isBefore(LocalDate.now())) {
            throw new Exception("A data de avaliação não pode ser menor que a atual.");
        }
        if (justificativaProfessor == null || justificativaProfessor.isEmpty()) {
            throw new Exception("A justificativa do professor não pode ser vazia.");
        }
        if (professorAplicadorProva == null || professorAplicadorProva.isEmpty()) {
            throw new Exception("O nome do professor não pode ser vazio.");
        }
        if (protocolo == null) {
            throw new Exception("O protocolo da segunda chamada não pode ser nulo.");
        }
    }
}
