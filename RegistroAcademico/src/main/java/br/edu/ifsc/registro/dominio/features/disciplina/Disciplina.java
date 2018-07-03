package br.edu.ifsc.registro.dominio.features.disciplina;

import br.edu.ifsc.registro.dominio.base.Entidade;
import br.edu.ifsc.registro.dominio.features.curso.Curso;

/**
 *
 * @author Edoardo Colares, Lucas Varela, Matheus de Medeiros
 */
public class Disciplina extends Entidade{
    private String nome;
    private int cargaHoraria;
    private String sigla;
    private Curso curso;

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
    public int getCargaHoraria() {
        return cargaHoraria;
    }

    /**
     *
     * @param cargaHoraria
     */
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    /**
     *
     * @return
     */
    public String getSigla() {
        return sigla;
    }

    /**
     *
     * @param sigla
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

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
    public void validar() throws Exception{
        super.validar(); //To change body of generated methods, choose Tools | Templates.
        if (nome == null || nome.isEmpty()) {
            throw new Exception("O nome da disciplina não pode ser vazia.");
        }
        if (nome.length() > 50) {
            throw new Exception("O nome da disciplina não pode ter mais que 50 caracteres.");
        }
        if (cargaHoraria == 0) {
            throw new Exception("A carga horaria não pode ser zero.");
        }
        if (sigla == null || sigla.isEmpty()) {
            throw new Exception("A sigla da disciplina não pode ser vazia.");
        }
        if (curso == null) {
            throw new Exception("A disciplina deve ser vinculada a um curso.");
        }
    }
    
    @Override
    public String toString() {
        return "Disciplina: " + nome + ", Carga horária: " + cargaHoraria + ", Sigla: " + sigla + ", Curso: " + curso.getNome();
    }
}
