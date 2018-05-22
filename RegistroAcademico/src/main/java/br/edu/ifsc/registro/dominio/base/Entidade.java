package br.edu.ifsc.registro.dominio.base;

/**
 *
 * @author Edoardo Colares, Lucas Varela, Matheus de Medeiros
 */
public abstract class Entidade {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id: " + id;
    }

    public void validar() {

    }

}
