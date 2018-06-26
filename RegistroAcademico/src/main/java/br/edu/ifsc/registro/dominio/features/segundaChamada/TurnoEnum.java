/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.dominio.features.segundaChamada;

/**
 *
 * @author Lucas
 */
public enum TurnoEnum {
    MATUTINO("Matutino"),
    VESPERTINO("Vespertino"),
    NOTURNO("Noturno");
    
    private String toString;

    TurnoEnum(String toString) {
        this.toString = toString;
    }

    public String url() {
        return toString;
    }

}
