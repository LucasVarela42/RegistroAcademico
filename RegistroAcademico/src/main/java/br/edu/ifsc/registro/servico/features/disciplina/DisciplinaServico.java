/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.servico.features.disciplina;

import br.edu.ifsc.registro.dominio.features.disciplina.Disciplina;
import br.edu.ifsc.registro.dominio.features.disciplina.IDisciplinaRepositorio;
import br.edu.ifsc.registro.servico.base.Servico;

/**
 *
 * @author Lucas
 */
public class DisciplinaServico extends Servico<Disciplina> {

    IDisciplinaRepositorio repositorio;

    /**
     *
     * @param repositorio
     */
    public DisciplinaServico(IDisciplinaRepositorio repositorio) {
        super(repositorio);
        this.repositorio = repositorio;
    }
}
