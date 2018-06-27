/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.infraestrutura.data.features.aluno;

import br.edu.ifsc.registro.dominio.features.aluno.Aluno;
import br.edu.ifsc.registro.dominio.features.aluno.IAlunoRepositorio;
import br.edu.ifsc.registro.dominio.features.curso.Curso;
import br.edu.ifsc.registro.dominio.features.curso.ICursoRepositorio;
import br.edu.ifsc.registro.infraestrutura.data.features.curso.CursoRepositorio;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class AlunoRepositorioTeste {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        IAlunoRepositorio repositorio;
        repositorio = new AlunoRepositorio();
        
        ICursoRepositorio cursoRepositorio;
        cursoRepositorio = new CursoRepositorio();
        
        try {
            //INSERIR
            Curso c = new Curso();
            c = cursoRepositorio.get(4);
            
            Aluno aluno = new Aluno();
            aluno.setNome("Lucas");
            aluno.setTelefone("999999999");
            aluno.setEmail("lucas@lucas.com");
            aluno.setCurso(c);
            aluno = repositorio.save(aluno);

            //ATUALIZAR
            aluno.setNome("Lucas Varela");
            aluno = repositorio.update(aluno);

            //GETALL
            List<Aluno> alunos = repositorio.getAll();
            for (Aluno a : alunos) {
                System.out.println(a.toString());
            }

            //GETBYID
            aluno = repositorio.get(aluno.getId());
            System.out.println(aluno.toString());

            //DELETAR
            repositorio.delete(aluno.getId());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
