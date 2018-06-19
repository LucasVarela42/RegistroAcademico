package br.edu.ifsc.registro.dominio.features.protocolo;

import br.edu.ifsc.registro.dominio.base.Entidade;
import br.edu.ifsc.registro.dominio.features.aluno.Aluno;
import br.edu.ifsc.registro.dominio.features.coordenador.Coordenador;
import java.time.LocalDateTime;

/**
 *
 * @author Edoardo Colares, Lucas Varela, Matheus de Medeiros
 */
public abstract class Protocolo extends Entidade{
    private long numero;
    private TipoProtocolo tipoProtocolo;
    private LocalDateTime dataCadastro;
    private Aluno aluno;
    private Coordenador coordenador;

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public TipoProtocolo getTipoProtocolo() {
        return tipoProtocolo;
    }

    public void setTipoProtocolo(TipoProtocolo tipoProtocolo) {
        this.tipoProtocolo = tipoProtocolo;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
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

    @Override
    public void validar() throws Exception {
        super.validar(); //To change body of generated methods, choose Tools | Templates.
    }
    
  

}
