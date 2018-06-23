package br.edu.ifsc.registro.dominio.features.validacao;

import br.edu.ifsc.registro.dominio.base.Entidade;
import br.edu.ifsc.registro.dominio.features.protocolo.Protocolo;

/**
 *
 * @author Edoardo Colares, Lucas Varela, Matheus de Medeiros
 */
public class Validacao extends Entidade{
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

    @Override
    public void validar() throws Exception {
        super.validar(); //To change body of generated methods, choose Tools | Templates.
    }
  

}
