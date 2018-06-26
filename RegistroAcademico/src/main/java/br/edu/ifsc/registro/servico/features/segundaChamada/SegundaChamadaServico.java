/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.servico.features.segundaChamada;

import br.edu.ifsc.registro.dominio.features.segundaChamada.ISegundaChamadaRepositorio;
import br.edu.ifsc.registro.dominio.features.segundaChamada.SegundaChamadaAtividadeAvaliativa;
import br.edu.ifsc.registro.servico.base.Servico;

/**
 *
 * @author Lucas
 */
public class SegundaChamadaServico extends Servico<SegundaChamadaAtividadeAvaliativa> {

    ISegundaChamadaRepositorio repositorio;

    public SegundaChamadaServico(ISegundaChamadaRepositorio repositorio) {
        super(repositorio);
        this.repositorio = repositorio;
    }
}