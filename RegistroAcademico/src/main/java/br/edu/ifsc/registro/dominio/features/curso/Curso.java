package br.edu.ifsc.registro.dominio.features.curso;

import br.edu.ifsc.registro.dominio.base.Entidade;

/**
 *
 * @author Edoardo Colares, Lucas Varela, Matheus de Medeiros
 */
public class Curso extends Entidade {

    private String nome;
    private TipoCurso tipoCurso;

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
    public TipoCurso getTipoCurso() {
        return tipoCurso;
    }

    /**
     *
     * @param tipoCurso
     */
    public void setTipoCurso(TipoCurso tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    /**
     *
     * @throws Exception
     */
    @Override
    public void validar() throws Exception {
        if (nome == null || nome.isEmpty() ) {
            throw new Exception("O nome do curso não pode ser vazio.");
        }
        if (nome.length() > 50) {
            throw new Exception("O nome do curso não pode ter mais que 50 caracteres.");
        }
        if (tipoCurso == null) {
            throw new Exception("O tipo do curso não pode ser vazio.");
        }
    }

    @Override
    public String toString() {
        return nome + ": " + tipoCurso.url();
    }
}
