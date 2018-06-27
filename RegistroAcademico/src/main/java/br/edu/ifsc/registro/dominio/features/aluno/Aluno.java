package br.edu.ifsc.registro.dominio.features.aluno;

import br.edu.ifsc.registro.dominio.features.curso.Curso;
import br.edu.ifsc.registro.dominio.base.Pessoa;

/**
 *
 * @author Edoardo Colares, Lucas Varela, Matheus de Medeiros
 */
public class Aluno extends Pessoa {

    private Curso curso;

    /**
     *
     * @return
     */
    public Curso getCurso() {
        return curso;
    }

    /**
     *
     * @param curso
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    /**
     *
     * @throws Exception
     */
    @Override
    public void validar() throws Exception {
        super.validar();
        if (curso == null) {
            throw new Exception("O aluno deve ser vinculado a um curso.");
        }
    }
    
    

}
