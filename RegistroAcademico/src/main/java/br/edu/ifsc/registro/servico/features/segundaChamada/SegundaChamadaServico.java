/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.servico.features.segundaChamada;

import br.edu.ifsc.registro.dominio.features.protocolo.IProtocoloRepositorio;
import br.edu.ifsc.registro.dominio.features.segundaChamada.ISegundaChamadaRepositorio;
import br.edu.ifsc.registro.dominio.features.segundaChamada.SegundaChamadaAtividadeAvaliativa;
import br.edu.ifsc.registro.servico.base.Servico;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class SegundaChamadaServico extends Servico<SegundaChamadaAtividadeAvaliativa> {

    ISegundaChamadaRepositorio repositorio;
    IProtocoloRepositorio protocoloRepositorio;

    /**
     *
     * @param repositorio
     * @param protocoloRepositorio
     */
    public SegundaChamadaServico(ISegundaChamadaRepositorio repositorio, IProtocoloRepositorio protocoloRepositorio) {
        super(repositorio);
        this.repositorio = repositorio;
        this.protocoloRepositorio = protocoloRepositorio;
    }

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public SegundaChamadaAtividadeAvaliativa get(int id) throws SQLException {
        SegundaChamadaAtividadeAvaliativa segundaChamada = super.get(id);
        if (segundaChamada == null) {
            return null;
        }
        segundaChamada.setProtocolo(protocoloRepositorio.get(segundaChamada.getProtocolo().getId()));
        return segundaChamada;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public List<SegundaChamadaAtividadeAvaliativa> getAll() throws SQLException {
        List<SegundaChamadaAtividadeAvaliativa> segundaChamadas = super.getAll();
        for (SegundaChamadaAtividadeAvaliativa segundaChamada : segundaChamadas) {
            segundaChamada.setProtocolo(protocoloRepositorio.get(segundaChamada.getProtocolo().getId()));
        }
        return segundaChamadas;
    }

}
