/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.servico.features.validacao;

import br.edu.ifsc.registro.dominio.features.validacao.IValidacaoRepositorio;
import br.edu.ifsc.registro.dominio.features.validacao.Validacao;
import br.edu.ifsc.registro.servico.base.Servico;

/**
 *
 * @author Lucas
 */
public class ValidacaoServico extends Servico<Validacao> {

    IValidacaoRepositorio repositorio;

    public ValidacaoServico(IValidacaoRepositorio repositorio) {
        super(repositorio);
        this.repositorio = repositorio;
    }
}
