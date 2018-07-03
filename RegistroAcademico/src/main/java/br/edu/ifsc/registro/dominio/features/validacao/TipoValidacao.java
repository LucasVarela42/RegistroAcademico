package br.edu.ifsc.registro.dominio.features.validacao;

/**
 *
 * @author Edoardo Colares, Lucas Varela, Matheus de Medeiros
 */
public enum TipoValidacao {

    /**
     *
     */
    RECONHECIMENTO_DE_ESTUDOS_NO_IFSC("Reconhecimento de estudos no IFSC"),
    /**
     *
     */
    RECONHECIMENTO_DE_ESTUDOS_EM_OUTRA_INSTITUICAO("Reconhecimento de estudos em outra Instituição");

    private String toString;

    TipoValidacao(String toString) {
        this.toString = toString;
    }

    /**
     *
     * @return
     */
    public String url() {
        return toString;
    }

}
