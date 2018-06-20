/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.servico.features.aluno;

import br.edu.ifsc.registro.dominio.features.aluno.Aluno;
import br.edu.ifsc.registro.dominio.features.aluno.IAlunoRepositorio;
import br.edu.ifsc.registro.servico.base.Servico;

/**
 *
 * @author Matheus
 */
public class AlunoServico extends Servico<Aluno> {

    IAlunoRepositorio repositorio;

    public AlunoServico(IAlunoRepositorio repositorio) {
        super(repositorio);
        this.repositorio = repositorio;
    }

}
