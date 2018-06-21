/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.infraestrutura.data.features.disciplina;

import br.edu.ifsc.registro.dominio.features.curso.Curso;
import br.edu.ifsc.registro.dominio.features.curso.ICursoRepositorio;
import br.edu.ifsc.registro.dominio.features.disciplina.Disciplina;
import br.edu.ifsc.registro.dominio.features.disciplina.IDisciplinaRepositorio;
import br.edu.ifsc.registro.infraestrutura.data.features.curso.CursoRepositorio;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class DisciplinaRepositorioTeste {
     public static void main(String[] args) {

        IDisciplinaRepositorio repositorio;
        repositorio = new DisciplinaRepositorio();
        
        ICursoRepositorio cursoRepositorio;
        cursoRepositorio = new CursoRepositorio();
        
        
        try {
            //INSERIR
            Curso c = new Curso();
            c = cursoRepositorio.get(4);
            
            Disciplina disciplina = new Disciplina();
            disciplina.setNome("Laboratório de Programação");
            disciplina.setCargaHoraria(72);
            disciplina.setSigla("LDP");
            disciplina.setCurso(c);
            disciplina = repositorio.save(disciplina);

            //ATUALIZAR
            disciplina.setNome("Estatistica e Probabilidade");
            disciplina = repositorio.update(disciplina);

            //GETALL
            List<Disciplina> disciplinas = repositorio.getAll();
            for (Disciplina d : disciplinas) {
                System.out.println(d.toString());
            }

            //GETBYID
            disciplina = repositorio.get(1);
            System.out.println(disciplina.toString());

            //DELETAR
            repositorio.delete(disciplina.getId());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
