package br.edu.ifsc.registro.dominio.features.curso;

import br.edu.ifsc.registro.dominio.base.Entidade;

/**
 *
 * @author Edoardo Colares, Lucas Varela, Matheus de Medeiros
 */
public class Curso extends Entidade {

    private String nome;
    private TipoCurso tipoCurso;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoCurso getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(TipoCurso tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    public void validar() {

    }

    @Override
    public String toString() {
        return "id=" + this.getId() + "nome=" + nome + ", tipoCurso=" + tipoCurso;
    }
}
