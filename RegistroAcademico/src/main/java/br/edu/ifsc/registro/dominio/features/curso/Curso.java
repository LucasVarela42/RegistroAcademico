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

    @Override
    public void validar() throws Exception {
        if (nome.isEmpty()|| nome.length() > 50) {
            throw new Exception("O nome do curso não pode ser vazio ou maior que 50 caracteres.");
        }
        if (tipoCurso == null) {
            throw new Exception("O tipo do curso não pode ser vazio.");
        }
    }
    
    @Override
    public String toString() {
        return "id=" + this.getId() + ", nome=" + nome + ", tipoCurso=" + tipoCurso;
    }
}
