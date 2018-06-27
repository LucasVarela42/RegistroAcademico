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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

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
}
