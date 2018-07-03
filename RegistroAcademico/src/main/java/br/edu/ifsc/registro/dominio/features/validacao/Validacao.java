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

    /**
     *
     * @return
     */
    public double getNota() {
        return nota;
    }

    /**
     *
     * @param nota
     */
    public void setNota(double nota) {
        this.nota = nota;
    }

    /**
     *
     * @return
     */
    public boolean isDeferido() {
        return deferido;
    }

    /**
     *
     * @param deferido
     */
    public void setDeferido(boolean deferido) {
        this.deferido = deferido;
    }

    /**
     *
     * @return
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     *
     * @param observacao
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    /**
     *
     * @return
     */
    public TipoValidacao getTipoValidacao() {
        return tipoValidacao;
    }

    /**
     *
     * @param tipoValidacao
     */
    public void setTipoValidacao(TipoValidacao tipoValidacao) {
        this.tipoValidacao = tipoValidacao;
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
        if (nota < 0) {
            throw new Exception("A nota da validação não pode ser menor que zero.");
        }
        if (nota > 10) {
            throw new Exception("A nota da validação não pode ser maior que dez.");
        }
        if (observacao == null || observacao.isEmpty()) {
            throw new Exception("A observação da validação não pode ser vazia.");
        }
        if (tipoValidacao == null) {
            throw new Exception("O tipo da validação não pode ser nula.");
        }
        if (protocolo == null) {
            throw new Exception("O protocolo da validação não pode ser nula.");
        }
    }
    
    @Override
    public String toString() {
        return "Protocolo Número: " + protocolo.getNumero() + ", Tipo da validação : " + tipoValidacao.url() + ", é deferido? " + deferido;
    }
    
}
