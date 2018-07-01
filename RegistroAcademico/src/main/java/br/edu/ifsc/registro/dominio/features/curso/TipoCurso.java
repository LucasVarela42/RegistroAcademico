/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.dominio.features.curso;

/**
 *
 * @author Edoardo Colares, Lucas Varela, Matheus de Medeiros
 */
public enum TipoCurso {

    /**
     *
     */
    POS_GRADUACAO("Pós graduação"),
    /**
     *
     */
    GRADUACAO("Graduação"),
    /**
     *
     */
    TECNICO("Técnico");

    private String toString;

    TipoCurso(String toString) {
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
