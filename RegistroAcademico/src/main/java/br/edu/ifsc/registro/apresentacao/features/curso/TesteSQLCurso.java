/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.apresentacao.features.curso;

import br.edu.ifsc.registro.dominio.features.curso.Curso;
import br.edu.ifsc.registro.dominio.features.curso.ICursoRepositorio;
import br.edu.ifsc.registro.dominio.features.curso.TipoCurso;
import br.edu.ifsc.registro.infraestrutura.data.features.curso.CursoRepositorio;

/**
 *
 * @author Lucas
 */
public class TesteSQLCurso {

    public static void main(String[] args) {
        //INSERIR
        ICursoRepositorio repositorio;
        repositorio = new CursoRepositorio();
        
        Curso curso = new Curso();
        curso.setNome("Programação");
        curso.setTipoCurso(TipoCurso.POS_GRADUACAO);
        
        try {
            repositorio.save(curso);
            
            curso.setNome("Laboratório de programação");
            
            repositorio.update(curso);
            
            repositorio.delete(curso.getId());
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
