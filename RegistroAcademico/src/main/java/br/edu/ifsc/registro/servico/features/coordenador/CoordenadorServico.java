/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.servico.features.coordenador;

import br.edu.ifsc.registro.dominio.base.IRepositorio;
import br.edu.ifsc.registro.dominio.features.coordenador.Coordenador;
import br.edu.ifsc.registro.dominio.features.coordenador.ICoordenadorRepositorio;
import br.edu.ifsc.registro.servico.base.Servico;

/**
 *
 * @author admin
 */
public class CoordenadorServico extends Servico<Coordenador> {

    ICoordenadorRepositorio repositorio;

    public CoordenadorServico(ICoordenadorRepositorio repositorio) {
        super(repositorio);
        this.repositorio = repositorio;
    }

}
