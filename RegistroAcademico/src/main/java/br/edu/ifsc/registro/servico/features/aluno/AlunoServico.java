/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.servico.features.aluno;

import br.edu.ifsc.registro.dominio.features.aluno.Aluno;
import br.edu.ifsc.registro.dominio.features.aluno.IAlunoRepositorio;
import br.edu.ifsc.registro.dominio.features.curso.ICursoRepositorio;
import br.edu.ifsc.registro.servico.base.Servico;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Matheus
 */
public class AlunoServico extends Servico<Aluno> {

    IAlunoRepositorio repositorio;
    ICursoRepositorio cursoRepositorio;

    public AlunoServico(IAlunoRepositorio repositorio, ICursoRepositorio cursoRepositorio) {
        super(repositorio);
        this.repositorio = repositorio;
        this.cursoRepositorio = cursoRepositorio;
    }

    @Override
    public Aluno get(int id) throws SQLException {
        Aluno aluno = super.get(id);
        if (aluno == null) {
            return null;
        }
        aluno.setCurso(cursoRepositorio.get(aluno.getCurso().getId()));
        return aluno;
    }

    @Override
    public List<Aluno> getAll() throws SQLException {
        List<Aluno> alunos = super.getAll();
        for (Aluno aluno : alunos) {
            aluno.setCurso(cursoRepositorio.get(aluno.getCurso().getId()));
        }
        return alunos;
    }

}
