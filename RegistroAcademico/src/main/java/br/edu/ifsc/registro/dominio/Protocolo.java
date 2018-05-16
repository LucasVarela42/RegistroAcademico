package br.edu.ifsc.registro.dominio;

/**
 *
 * @author Edoardo Colares, Lucas Varela, Matheus de Medeiros
 */
public abstract class Protocolo {

    private int id;
    private int numero;
    private Tipo tipoProtocolo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void validar() {

    }

}
