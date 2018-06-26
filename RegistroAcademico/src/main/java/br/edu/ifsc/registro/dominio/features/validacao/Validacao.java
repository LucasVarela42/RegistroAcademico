package br.edu.ifsc.registro.dominio.features.validacao;

import br.edu.ifsc.registro.dominio.base.Entidade;
import br.edu.ifsc.registro.dominio.features.protocolo.Protocolo;

/**
 *
 * @author Edoardo Colares, Lucas Varela, Matheus de Medeiros
 */
public class Validacao extends Entidade {

    private double nota;
    private boolean deferido;
    private String observacao;
    private TipoValidacao tipoValidacao;
    private Protocolo protocolo;

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public boolean isDeferido() {
        return deferido;
    }

    public void setDeferido(boolean deferido) {
        this.deferido = deferido;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public TipoValidacao getTipoValidacao() {
        return tipoValidacao;
    }

    public void setTipoValidacao(TipoValidacao tipoValidacao) {
        this.tipoValidacao = tipoValidacao;
    }

    public Protocolo getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(Protocolo protocolo) {
        this.protocolo = protocolo;
    }

    @Override
    public void validar() throws Exception {
        super.validar(); //To change body of generated methods, choose Tools | Templates.
        if (nota < 0) {
            throw new Exception("A nota da validação não pode ser menor que zero.");
        }
        if (observacao.isEmpty()) {
            throw new Exception("A observação da validação não pode ser vazia.");
        }
        if (tipoValidacao == null) {
            throw new Exception("O tipo da validação não pode ser nula.");
        }
        if (protocolo == null) {
            throw new Exception("O protocolo da validação não pode ser nula.");
        }
    }
}
