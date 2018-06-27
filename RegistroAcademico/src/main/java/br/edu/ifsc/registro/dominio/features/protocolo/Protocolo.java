package br.edu.ifsc.registro.dominio.features.protocolo;

import br.edu.ifsc.registro.dominio.base.Entidade;
import br.edu.ifsc.registro.dominio.features.aluno.Aluno;
import br.edu.ifsc.registro.dominio.features.coordenador.Coordenador;
import java.time.LocalDate;

/**
 *
 * @author Edoardo Colares, Lucas Varela, Matheus de Medeiros
 */
public class Protocolo extends Entidade{
    private String numero;
    private TipoProtocolo tipoProtocolo;
    private LocalDate dataCadastro;
    private Aluno aluno;
    private Coordenador coordenador;
    
    /**
     *
     * @return
     */
    public String getNumero() {
        return numero;
    }

    /**
     *
     * @param numero
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     *
     * @return
     */
    public TipoProtocolo getTipoProtocolo() {
        return tipoProtocolo;
    }

    /**
     *
     * @param tipoProtocolo
     */
    public void setTipoProtocolo(TipoProtocolo tipoProtocolo) {
        this.tipoProtocolo = tipoProtocolo;
    }

    /**
     *
     * @return
     */
    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    /**
     *
     * @param dataCadastro
     */
    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    /**
     *
     * @return
     */
    public Aluno getAluno() {
        return aluno;
    }

    /**
     *
     * @param aluno
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    /**
     *
     * @return
     */
    public Coordenador getCoordenador() {
        return coordenador;
    }

    /**
     *
     * @param coordenador
     */
    public void setCoordenador(Coordenador coordenador) {
        this.coordenador = coordenador;
    }

    /**
     *
     * @throws Exception
     */
    @Override
    public void validar() throws Exception {
        super.validar(); 
        if (numero == null || numero.isEmpty()) {
            throw new Exception("O numero do protocolo não pode ser vazio.");
        }
        if (tipoProtocolo == null) {
            throw new Exception("O tipo do protocolo não pode ser vazio.");
        }
        if (dataCadastro.isAfter(LocalDate.now())) {
            throw new Exception("A data de cadastro não pode ser maior que a atual.");
        }
        if (aluno == null) {
            throw new Exception("O protocolo deve ser vinculado a um aluno.");
        }
        if (aluno == null) {
            throw new Exception("O protocolo deve ser vinculado a um coordenador.");
        }
    }
}
