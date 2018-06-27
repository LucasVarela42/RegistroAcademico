/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.servico.features.curso;

import br.edu.ifsc.registro.dominio.features.curso.Curso;
import br.edu.ifsc.registro.dominio.features.curso.ICursoRepositorio;
import br.edu.ifsc.registro.servico.base.Servico;

/**
 *
 * @author Lucas
 */
public class CursoServico extends Servico<Curso> {

    ICursoRepositorio repositorio;

    /**
     *
     * @param repositorio
     */
    public CursoServico(ICursoRepositorio repositorio) {
        super(repositorio);
        this.repositorio = repositorio;
    }
}
