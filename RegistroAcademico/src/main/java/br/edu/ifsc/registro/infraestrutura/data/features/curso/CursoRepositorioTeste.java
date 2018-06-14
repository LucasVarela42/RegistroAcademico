/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.infraestrutura.data.features.curso;

import br.edu.ifsc.registro.dominio.features.curso.Curso;
import br.edu.ifsc.registro.dominio.features.curso.ICursoRepositorio;
import br.edu.ifsc.registro.dominio.features.curso.TipoCurso;
import br.edu.ifsc.registro.infraestrutura.data.features.curso.CursoRepositorio;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class CursoRepositorioTeste {

    public static void main(String[] args) {

        ICursoRepositorio repositorio;
        repositorio = new CursoRepositorio();

        try {
            //INSERIR
            Curso curso = new Curso();
            curso.setNome("Programação");
            curso.setTipoCurso(TipoCurso.POS_GRADUACAO);
            curso = repositorio.save(curso);

            //ATUALIZAR
            curso.setNome("Laboratório de programação");
            curso = repositorio.update(curso);

            //GETALL
            List<Curso> cursos = repositorio.getAll();
            for (Curso c : cursos) {
                System.out.println(c.toString());
            }

            //GETBYID
            curso = repositorio.get(curso.getId());
            System.out.println(curso.toString());

            //DELETAR
            repositorio.delete(curso.getId());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
