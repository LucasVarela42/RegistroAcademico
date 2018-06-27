package br.edu.ifsc.registro.dominio.base;

/**
 *
 * @author Edoardo Colares, Lucas Varela, Matheus de Medeiros
 */
public abstract class Pessoa extends Entidade {

    private String nome;
    private String telefone;
    private String email;

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     *
     * @param telefone
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @throws Exception
     */
    @Override
    public void validar() throws Exception {
        super.validar();
        if (nome == null || nome.isEmpty()) {
            throw new Exception("O nome não pode ser vazio.");
        }
        if (telefone == null || telefone.isEmpty()) {
            throw new Exception("O telefone não pode ser vazio.");
        }
        if (email == null || email.isEmpty()) {
            throw new Exception("O email não pode ser vazio.");
        }

    }

}
