/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.servico.features.protocolo;

import br.edu.ifsc.registro.dominio.features.protocolo.IProtocoloRepositorio;
import br.edu.ifsc.registro.dominio.features.protocolo.Protocolo;
import br.edu.ifsc.registro.servico.base.Servico;

/**
 *
 * @author Lucas
 */
public class ProtocoloServico  extends Servico<Protocolo> {

    IProtocoloRepositorio repositorio;

    public ProtocoloServico(IProtocoloRepositorio repositorio) {
        super(repositorio);
        this.repositorio = repositorio;
    }
}
