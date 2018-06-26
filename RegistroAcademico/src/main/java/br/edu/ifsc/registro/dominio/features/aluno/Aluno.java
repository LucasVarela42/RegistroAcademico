package br.edu.ifsc.registro.dominio.features.aluno;

import br.edu.ifsc.registro.dominio.features.curso.Curso;
import br.edu.ifsc.registro.dominio.base.Pessoa;

/**
 *
 * @author Edoardo Colares, Lucas Varela, Matheus de Medeiros
 */
public class Aluno extends Pessoa {

    private Curso curso;

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public void validar() throws Exception {
        super.validar();
        if (curso == null) {
            throw new Exception("O aluno deve ser vinculado a um curso.");
        }
    }
    
    

}
