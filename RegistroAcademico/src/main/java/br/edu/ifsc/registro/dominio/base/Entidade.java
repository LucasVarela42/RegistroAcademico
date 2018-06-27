package br.edu.ifsc.registro.dominio.base;

/**
 *
 * @author Edoardo Colares, Lucas Varela, Matheus de Medeiros
 */
public abstract class Entidade {

    private int id;

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id: " + id;
    }
    
    /**
     *
     * @throws Exception
     */
    public void validar() throws Exception{ }
}
