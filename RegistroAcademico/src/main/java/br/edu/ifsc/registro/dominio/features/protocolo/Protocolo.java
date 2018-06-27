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
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoProtocolo getTipoProtocolo() {
        return tipoProtocolo;
    }

    public void setTipoProtocolo(TipoProtocolo tipoProtocolo) {
        this.tipoProtocolo = tipoProtocolo;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
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
